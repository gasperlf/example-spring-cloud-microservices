package co.com.financialservice.resources;

import co.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import co.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import co.com.financialservice.services.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping(path = "/quotes/")
public class QuoteResource {

    @Autowired
    private QuoteService quoteService;

    @GetMapping(path = "v1/search")
    public Mono<ResponseEntity<RegistryMatches>> searchQuotes(@RequestParam (name = "value") String symbol){
      return quoteService.findSymbols(symbol).map(ResponseEntity::ok).subscribeOn(Schedulers.elastic());
    }

    @GetMapping(path = "v1/quote")
    public Mono<ResponseEntity<QuoteMatches>> searchQuote(@RequestParam (name = "value") String quote){
        return quoteService.findQuote(quote).map(ResponseEntity::ok).subscribeOn(Schedulers.elastic());
    }
}
