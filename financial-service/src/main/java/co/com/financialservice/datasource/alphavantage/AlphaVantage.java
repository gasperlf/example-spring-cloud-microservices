package co.com.financialservice.datasource.alphavantage;

import co.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import co.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import reactor.core.publisher.Mono;

public interface AlphaVantage {

    public Mono<RegistryMatches> searchSymbols(final String simbol);

    public Mono<QuoteMatches> getQuote(final String quote);
}
