package lf.com.financialservice.services;

import lf.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import lf.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import lf.com.financialservice.resources.dtos.CustomerQuoteDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface QuoteService {

    public Mono<RegistryMatches> findSymbols(final String symbol);

    public Mono<QuoteMatches> findQuote(final String quote);

    public Flux<QuoteMatches> findQuotesCustomer(Flux<CustomerQuoteDto> customerQuoteDtoFlux);
}
