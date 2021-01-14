package ru.vladislavduma.invstocksservice;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.vladislavduma.invstocksservice.ErrorHandling.StockServiceError;

import java.util.List;

@Component
@Scope("prototype")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StockServiceResponseJson {

    private String msgId;
    private String status;
    private List<InstrumentData> payload;

    private StockServiceError error;

    public StockServiceResponseJson() {}

    public StockServiceResponseJson(String msgId, String status, List<InstrumentData> payload) {
        this.msgId = msgId;
        this.status = status;
        this.payload = payload;
    }

    public StockServiceResponseJson(String msgId, String status, StockServiceError error) {
        this.msgId = msgId;
        this.status = status;
        this.error = error;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<InstrumentData> getPayload() {
        return payload;
    }

    public void setPayload(List<InstrumentData> payload) {
        this.payload = payload;
    }

    public StockServiceError getError() {
        return error;
    }

    public void setError(StockServiceError error) {
        this.error = error;
    }
}
