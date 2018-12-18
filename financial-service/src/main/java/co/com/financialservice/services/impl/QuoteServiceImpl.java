package co.com.financialservice.services.impl;

import co.com.financialservice.datasource.BeanDataSourceFactory;
import co.com.financialservice.datasource.alphavantage.AlphaVantage;
import co.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import co.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import co.com.financialservice.resources.dtos.CustomerQuoteDto;
import co.com.financialservice.services.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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