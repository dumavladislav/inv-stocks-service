package ru.vladislavduma.invstocksservice.APIs.TinkoffInvest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import ru.vladislavduma.invstocksservice.APIs.JWTTemplate;
import ru.vladislavduma.invstocksservice.ErrorHandling.StockServiceError;
import ru.vladislavduma.invstocksservice.ErrorHandling.TickerNotFoundException;
import ru.vladislavduma.invstocksservice.InstrumentData;
import ru.vladislavduma.invstocksservice.StockServiceResponseJson;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:application.properties")
public class TCSApi extends JWTTemplate {

    Logger logger = LoggerFactory.getLogger(TCSApi.class);

    HttpHeaders headers;
    HttpEntity<String> entity;
    ObjectMapper objectMapper;

    @Autowired
    private Environment env;

    @Value("${tinkoff.baseUrl}")
    private String baseUrl;

    public TCSApi(@Value("${tinkoff.apiKey}") String apiKey) {
        super(apiKey);
        objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        objectMapper.disable(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES);
        objectMapper.disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES);
    }

    public StockServiceResponseJson searchByTicker(String ticker) {

        try {
            ResponseEntity<TCSResponse<TCSSearchByTickerResponseJson>> responseSearchByTicker =
                    restTemplate.exchange(
                            baseUrl + "/market/search/by-ticker?ticker=" + ticker,
                            HttpMethod.GET, entity,
                            new ParameterizedTypeReference<TCSResponse<TCSSearchByTickerResponseJson>>() {
                            });
//            logger.info("BODY" + response.getBody().toString());
//            logger.info("PAYLOAD" + response.getBody().getPayload().toString());

            if (responseSearchByTicker.getBody().getPayload().getTotal() > 0) {
                TCSSearchByTickerResponseInstrumentJson instrumentJson = responseSearchByTicker.getBody().getPayload().getInstruments().get(0);

                ResponseEntity<TCSResponse<TCSOrderBookResponseJson>> responseOrderBook =
                        restTemplate.exchange(
                                baseUrl + "/market/orderbook?figi=" + instrumentJson.getFigi() + "&depth=0",
                                HttpMethod.GET, entity,
                                new ParameterizedTypeReference<TCSResponse<TCSOrderBookResponseJson>>() {
                                });

                logger.info(responseOrderBook.getBody().getPayload().toString());

                List<InstrumentData> instrumentsList = new ArrayList<InstrumentData>();
                instrumentsList.add(new InstrumentData(
                        instrumentJson.getFigi(),
                        instrumentJson.getTicker(),
                        instrumentJson.getIsin(),
                        instrumentJson.getMinPriceIncrement(),
                        instrumentJson.getLot(),
                        instrumentJson.getCurrency(),
                        instrumentJson.getName(),
                        instrumentJson.getType(),
                        responseOrderBook.getBody().getPayload().getLastPrice()
                ));

                return new StockServiceResponseJson(
                        null,
                        "OK",
                        instrumentsList
                );
            }
            else throw new TickerNotFoundException();
        }
        catch (RestClientException e) {
            return new StockServiceResponseJson(
                    null,
                    "ERROR",
                    new StockServiceError("TCS_ERR_001", "Tinkoff Service Error"));
        }
        catch (Exception e) {
            return new StockServiceResponseJson(
                    null,
                    "ERROR",
                    new StockServiceError("ERR", e.getMessage()));
        }
    }

}
