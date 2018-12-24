package lf.com.financialservice.datasource.alphavantage.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "01. symbol",
        "02. open",
        "03. high",
        "04. low",
        "05. price",
        "06. volume",
        "07. latest trading day",
        "08. previous close",
        "09. change",
        "10. change percent"
})
public class Quote {

    @JsonProperty("01. symbol")
    private String symbol;
    @JsonProperty("02. open")
    private String open;
    @JsonProperty("03. high")
    private String high;
    @JsonProperty("04. low")
    private String low;
    @JsonProperty("05. price")
    private String price;
    @JsonProperty("06. volume")
    private String volume;
    @JsonProperty("07. latest trading day")
    private String latestTradingDay;
    @JsonProperty("08. previous close")
    private String previousClose;
    @JsonProperty("09. change")
    private String change;
    @JsonProperty("10. change percent")
    private String changePercent;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
