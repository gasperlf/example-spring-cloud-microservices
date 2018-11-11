package lf.com.secutityservice.services.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lf.com.secutityservice.services.AuthenticationService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Service
public class AuthenticationServiceImpl  implements AuthenticationService {

    public Mono<String> generateToken(String app){

        Algorithm algorithm = Algorithm.HMAC512("secret");
        String token = JWT.create()
                .withExpiresAt(Date.from(LocalDateTime.now().plusMinutes(5L).atZone(ZoneId.systemDefault()).toInstant()))
                .withIssuer(app)
                .sign(algorithm);
        return Mono.justOrEmpty(token);
    }

    public Mono<Boolean> validateToken(String token,String app){

        Algorithm algorithm = Algorithm.HMAC512("secret");
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(app)
                .build(); //Reusable verifier instance
        try {
            DecodedJWT jwt = verifier.verify(token);
            return Mono.justOrEmpty(true);
        }catch (JWTVerificationException e) {
            return Mono.justOrEmpty(false);
        }
    }
}
