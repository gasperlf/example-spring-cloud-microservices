package lf.com.secutityservice.routing;

import lf.com.secutityservice.services.AuthenticationService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@Log4j2
@Configuration
public class AuthenticationRoute {

    private final AuthenticationService authenticationService;
    private AuthenticationHandler authenticationHandler;

    public AuthenticationRoute(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
        this.authenticationHandler = new AuthenticationHandler(this.authenticationService);
    }

    @Bean
    public RouterFunction<?> route() {
        log.info("invocacion del metodo route");
        return nest(path("/v1/tokens"),
                RouterFunctions.route(POST("/generate").and(accept(APPLICATION_JSON_UTF8).and(contentType(APPLICATION_JSON_UTF8))), authenticationHandler::getToken)
                .andOther(RouterFunctions.route(POST("/validate").and(accept(APPLICATION_JSON_UTF8).and(contentType(APPLICATION_JSON_UTF8))),authenticationHandler::validateToken)));

    }
}
