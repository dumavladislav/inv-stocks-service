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

    public TCSSearchByTickerResponseJson searchByTicker(String ticker) {

        try {
            ResponseEntity<TCSResponse<TCSSearchByTickerResponseJson>> response =
                    restTemplate.exchange(
                            baseUrl + "/market/search/by-ticker?ticker=" + ticker,
                            HttpMethod.GET, entity,
                            new ParameterizedTypeReference<TCSResponse<TCSSearchByTickerResponseJson>>() {
                            });
            logger.info("BODY" + response.getBody().toString());
            logger.info("PAYLOAD" + response.getBody().getPayload().toString());

            return response.getBody().getPayload();
        }
        catch (RestClientException e) {
            logger.error("Error Calling TCS");
        }
        return null;
    }

}
