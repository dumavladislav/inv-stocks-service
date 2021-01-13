package ru.vladislavduma.invstocksservice.APIs.TinkoffInvest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import ru.vladislavduma.invstocksservice.APIs.JWTTemplate;

@Component
@PropertySource("classpath:application.properties")
public class TinkoffApi extends JWTTemplate {

    HttpHeaders headers;
    HttpEntity<String> entity;

    @Autowired
    private Environment env;

    @Value("${tinkoff.baseUrl}")
    private String baseUrl;

    public TinkoffApi(@Value("${tinkoff.apiKey}") String apiKey) {
        super(apiKey);
    }

    public SearchByTickerJson searchByTicker(String ticker) {
        System.out.println(baseUrl + "/market/search/by-ticker?ticker=" + ticker);

        ResponseEntity<String> response =
                restTemplate.exchange(
                        baseUrl + "/market/search/by-ticker?ticker=" + ticker,
                        HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
        return new SearchByTickerJson();
    }





}
