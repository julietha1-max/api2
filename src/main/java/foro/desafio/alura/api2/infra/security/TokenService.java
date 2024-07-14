package foro.desafio.alura.api2.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import foro.desafio.alura.api2.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

@Value("${api.security.secret")
    private  String apiSecret;
    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
             return JWT.create()
                    .withIssuer("foro api")
                     .withSubject(usuario.getLogin())
                     .withClaim("id", usuario.getId())
                     .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
            // Invalid Signing configuration / Couldn't convert Claims.
        }


    }

    public String getSubject (String token) {
        if (token == null){
            throw  new RuntimeException();
        }

        DecodedJWT verifier = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            verifier = JWT.require(algorithm)
                    .withIssuer("Foro.api")
                    .build()
                    .verify(token);
           return verifier.getSubject();

        } catch (JWTVerificationException exception) {
            System.out.println((exception.toString()));

        }
        if(verifier.getSubject()==null){
            throw new RuntimeException("verifier invalido");
        }
        return verifier.getSubject();
    }



    private Instant generarFechaExpiracion(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-05:00"));
    }

}
