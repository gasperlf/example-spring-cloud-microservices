package lf.com.secutityservice.routing;

import lf.com.secutityservice.resources.dto.ResponseController;
import lf.com.secutityservice.services.AuthenticationService;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class AuthenticationHandler {

    private final AuthenticationService authenticationService;

    public AuthenticationHandler(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    public Mono<ServerResponse> getToken(ServerRequest serverRequest){
        String appName = serverRequest.queryParam("app").get();
        Mono<String> response = this.authenticationService.generateToken(appName);
        return response.map(ResponseController::new)
                       .flatMap(token->ServerResponse.ok()
                                                     .contentType(MediaType.APPLICATION_JSON_UTF8)
                                                     .body(BodyInserters.fromObject(token)));
    }

    public Mono<ServerResponse> validateToken(ServerRequest serverRequest){
        String app = serverRequest.queryParam("app").get();
        String token = serverRequest.headers().header("X-application-id").stream().findFirst().get();
        Mono<Boolean> response = this.authenticationService.validateToken(token,app);
        return response.map(ResponseController::new)
                       .flatMap(validate->ServerResponse.ok()
                                                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                                                        .body(BodyInserters.fromObject(validate)));
    }
}
