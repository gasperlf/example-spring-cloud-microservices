package lf.com.financialservice.resources;

import lf.com.financialservice.datasource.alphavantage.dtos.QuoteMatches;
import lf.com.financialservice.datasource.alphavantage.dtos.RegistryMatches;
import lf.com.financialservice.resources.dtos.CustomerQuoteDto;
import lf.com.financialservice.resources.dtos.ResponseController;
import lf.com.financialservice.services.QuoteService;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.List;

@Api(tags = "quotes")
@RestController
@RequestMapping(path = "/quotes/")
public class QuoteResource {

    private final QuoteService quoteService;

    public QuoteResource(QuoteService quoteService) {
        this.quoteService = quoteService;
    }

    @GetMapping(path = "v1/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<ResponseEntity<ResponseController<RegistryMatches>>> searchQuotes(@RequestParam(name = "value") String symbol) {
        return quoteService.findSymbols(symbol)
                .map(ResponseController::new)
                .map(ResponseEntity::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(path = "v1/quote", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<ResponseEntity<ResponseController<QuoteMatches>>> searchQuote(@RequestParam(name = "value") String quote) {
        return quoteService.findQuote(quote)
                .map(ResponseController::new)
                .map(ResponseEntity::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @PostMapping(path = "/v1/quotesCustomer", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE , produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<ResponseEntity<ResponseController<QuoteMatches>>> findQuotesCustomer(@RequestBody List<CustomerQuoteDto> customerQuoteDtoList) {
        return quoteService.findQuotesCustomer(Flux.fromIterable(customerQuoteDtoList))
                .map(ResponseController::new)
                .map(ResponseEntity::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
