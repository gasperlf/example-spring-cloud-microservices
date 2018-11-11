package co.com.financialservice.services.impl;

import co.com.financialservice.datasource.alphavantage.AlphaVantage;
import co.com.financialservice.datasource.BeanDataSourceFactory;
import co.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import co.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import co.com.financialservice.services.QuoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class QuoteServiceImp implements QuoteService {

    @Autowired
    private BeanDataSourceFactory beanDataSourceFactory;

    @Override
    public Mono<RegistryMatches> findSymbols(final String symbol){
        return beanDataSourceFactory.getBean(AlphaVantage.class).searchSymbols(symbol);
    }

    @Override
    public Mono<QuoteMatches> findQuote(final String quote){
        return beanDataSourceFactory.getBean(AlphaVantage.class).getQuote(quote);
    }
}
