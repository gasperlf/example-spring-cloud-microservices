package lf.com.financialservice.services.impl;

import lf.com.financialservice.datasource.BeanDataSourceFactory;
import lf.com.financialservice.datasource.alphavantage.AlphaVantage;
import lf.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import lf.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import lf.com.financialservice.resources.dtos.CustomerQuoteDto;
import lf.com.financialservice.services.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class QuoteServiceImpl implements QuoteService {

    private final BeanDataSourceFactory beanDataSourceFactory;

    QuoteServiceImpl(BeanDataSourceFactory beanDataSourceFactory){
        this.beanDataSourceFactory = beanDataSourceFactory;
    }

    @Override
    public Mono<RegistryMatches> findSymbols(final String symbol) {
        return beanDataSourceFactory.getBean(AlphaVantage.class).searchSymbols(symbol);
    }

    @Override
    public Mono<QuoteMatches> findQuote(final String quote) {
        return beanDataSourceFactory.getBean(AlphaVantage.class).getQuote(quote);
    }

    @Override
    public Flux<QuoteMatches> findQuotesCustomer(Flux<CustomerQuoteDto> customerQuoteDtoFlux) {

      Flux<QuoteMatches> quoteMatchesFlux=  customerQuoteDtoFlux
                .flatMap(customerQuoteDto -> {
                    Mono<QuoteMatches> quoteMatchesMono = beanDataSourceFactory.getBean(AlphaVantage.class).getQuote(customerQuoteDto.getCompany());
                    quoteMatchesMono.subscribe();
                    return quoteMatchesMono;
                })
              ;
      return quoteMatchesFlux;
    }
}