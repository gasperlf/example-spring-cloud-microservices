package co.com.financialservice.datasource.alphavantage.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"bestMatches"})
public class RegistryMatches {

    @JsonProperty("bestMatches")
    private List<Registry> bestMatches;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
