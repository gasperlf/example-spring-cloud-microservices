package lf.com.secutityservice.services;

import reactor.core.publisher.Mono;

public interface AuthenticationService {

    public Mono<String> generateToken(String app);

    public Mono<Boolean> validateToken(String token,String app);
}
