package co.com.customerservice.resources;

import co.com.customerservice.resources.dtos.ResponseController;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Api(tags = "ping")
@RestController
@RequestMapping(path = "/v1/pings")
public class PingResource {

    @GetMapping(path = "/ping")
    public Mono<ResponseEntity<ResponseController<String>>> ping(){
        return Mono.just("Application is running.....")
                .map(ResponseController::new)
                .map(ResponseEntity::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
