package co.com.financialservice.services;

import co.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import co.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import reactor.core.publisher.Mono;

public interface QuoteService {

    Mono<RegistryMatches> findSymbols(final String symbol);

    public Mono<QuoteMatches> findQuote(final String quote);
}
