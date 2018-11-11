package co.com.financialservice.datasource.alphavantage.dtos;

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
        "1. symbol",
        "2. name",
        "3. type",
        "4. region",
        "5. marketOpen",
        "6. marketClose",
        "7. timezone",
        "8. currency",
        "9. matchScore"
})
public class Registry {

    @JsonProperty("1. symbol")
    private String symbol;
    @JsonProperty("2. name")
    private String name;
    @JsonProperty("3. type")
    private String type;
    @JsonProperty("4. region")
    private String region;
    @JsonProperty("5. marketOpen")
    private String marketOpen;
    @JsonProperty("6. marketClose")
    private String marketClose;
    @JsonProperty("7. timezone")
    private String timezone;
    @JsonProperty("8. currency")
    private String currency;
    @JsonProperty("9. matchScore")
    private String matchScore;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

}
