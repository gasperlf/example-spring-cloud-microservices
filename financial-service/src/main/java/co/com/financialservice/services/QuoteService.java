package co.com.financialservice.services;

import co.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import co.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import co.com.financialservice.resources.dtos.CustomerQuoteDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuoteService {

    public Mono<RegistryMatches> findSymbols(final String symbol);

    public Mono<QuoteMatches> findQuote(final String quote);

    public Flux<QuoteMatches> findQuotesCustomer(Flux<CustomerQuoteDto> customerQuoteDtoFlux);
}
