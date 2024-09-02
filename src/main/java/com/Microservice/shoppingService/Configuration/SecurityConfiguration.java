package com.Microservice.shoppingService.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/*import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;*/

@Configuration
//@EnableWebFluxSecurity
public class SecurityConfiguration {

    /**
     * Definimos un beans que intercepte todos los api consumer hacia el api gateway
     * */
    /*@Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
        /**Que sea autenticado por oauth2 por defecto */
      /*  http.authorizeExchange(e -> e.pathMatchers("/eureka/**","/api/v1/authentication/**","/actuator/**")
                        .permitAll()
                        .anyExchange().authenticated())
                .oauth2ResourceServer(o -> o.jwt(Customizer.withDefaults()));
        /** DESHABILITAMOS CSRF*/
        /*http.csrf(e -> e.disable());

        return http.build();
    }*/
}