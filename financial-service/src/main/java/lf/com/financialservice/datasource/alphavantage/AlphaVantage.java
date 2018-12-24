package lf.com.financialservice.datasource.alphavantage;

import lf.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import lf.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import reactor.core.publisher.Mono;

public interface AlphaVantage {

    public Mono<RegistryMatches> searchSymbols(final String simbol);

    public Mono<QuoteMatches> getQuote(final String quote);
}
