package ru.vladislavduma.invstocksservice.APIs.TinkoffInvest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TCSSearchByTickerResponseJson {

    Integer total;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<TCSSearchByTickerResponseInstrumentJson> instruments;

    public List<TCSSearchByTickerResponseInstrumentJson> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<TCSSearchByTickerResponseInstrumentJson> instruments) {
        this.instruments = instruments;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return instruments.toString();
    }
}
