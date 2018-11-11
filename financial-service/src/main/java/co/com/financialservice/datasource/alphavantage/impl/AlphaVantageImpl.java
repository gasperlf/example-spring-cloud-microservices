package co.com.financialservice.datasource.alphavantage.impl;

import co.com.financialservice.datasource.DataSource;
import co.com.financialservice.datasource.alphavantage.AlphaVantage;
import co.com.financialservice.datasource.alphavantage.AlphaVantegaExtend;
import co.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import co.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;

@Service
public class AlphaVantageImpl extends AlphaVantegaExtend implements DataSource {

    @Override
    public Mono<RegistryMatches> searchSymbols(final String simbol){
        MultiValueMap<String,String> parameters = new LinkedMultiValueMap<>();
        parameters.add("function","SYMBOL_SEARCH");
        parameters.add("keywords",simbol);
        parameters.add("apikey","6VSMIKNAZ97L1O4W");
        return (Mono<RegistryMatches>) get("query",parameters,RegistryMatches.class);
    }

    @Override
    public Mono<QuoteMatches> getQuote(final String quote){
        MultiValueMap<String,String> parameters = new LinkedMultiValueMap<>();
        parameters.add("function","GLOBAL_QUOTE");
        parameters.add("symbol",quote.toUpperCase());
        parameters.add("apikey","6VSMIKNAZ97L1O4W");
        return (Mono<QuoteMatches>) get("query",parameters,QuoteMatches.class);
    }
}
