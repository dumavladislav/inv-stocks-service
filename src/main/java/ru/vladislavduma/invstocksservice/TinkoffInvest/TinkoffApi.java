package ru.vladislavduma.invstocksservice.TinkoffInvest;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@PropertySource("classpath:application.properties")
public class TinkoffApi {

    HttpHeaders headers;
    HttpEntity<String> entity;

    @Autowired
    private Environment env;

    @Value("${tinkoff.baseUrl}")
    private String baseUrl;

    @Value("${tinkoff.apiKey}")
    private String api_key;

    public TinkoffApi() {
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+api_key);

        entity = new HttpEntity<String>(null,headers);
    }

    public SearchByTickerJson searchByTicker(String ticker) {
        System.out.println(baseUrl + "/market/search/by-ticker?ticker=" + ticker);
        System.out.println(api_key);

        RestTemplate restTemplate = new RestTemplate();
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(baseUrl + "/market/search/by-ticker?ticker=" + ticker, String.class);
        System.out.println(restTemplate.toString());
        ResponseEntity<String> response = restTemplate.exchange(
                baseUrl + "/market/search/by-ticker?ticker=" + ticker,
                HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody().toString());
        return new SearchByTickerJson();
    }





}
