package ru.vladislavduma.invstocksservice.APIs.TinkoffInvest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class TCSSearchByTickerResponseJson {

//    @JsonProperty("instruments")
    List<TCSSearchByTickerResponseInstrumentJson> instruments;

    public List<TCSSearchByTickerResponseInstrumentJson> getInstruments() {
        return instruments;
    }

    public void setInstruments(List<TCSSearchByTickerResponseInstrumentJson> instruments) {
        this.instruments = instruments;
    }

    @Override
    public String toString() {
        return instruments.toString();
    }
}
