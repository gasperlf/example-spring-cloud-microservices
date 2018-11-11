package co.com.financialservice.datasource.alphavantage.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"Global Quote"})
public class QuoteMatches {
    @JsonProperty("Global Quote")
    private Quote quote;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();
}
