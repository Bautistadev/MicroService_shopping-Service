package com.Microservice.shoppingService.MicroService;

import com.Microservice.shoppingService.model.ClientDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http .ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * Cliente feignt
 * */
@FeignClient(name = "client-Service",path="/api/v1/clients")
public interface ClientRest {

    @GetMapping(value = "/clients/{id}")
    /**Patron Circuit breaker*/
    @CircuitBreaker(name="retrieveClientById",fallbackMethod = "defaultClientById")
    public ResponseEntity<ClientDTO> retriveClientById(@PathVariable("id") Integer id, @RequestHeader("Authorization") String authorizationHeader);


    /**
     * Funcion que retorna por defecto en caso de fallo en la conexion al microservicio
     * */
    public default ResponseEntity<ClientDTO> defaultClientById(Integer id,String authorizationHeader,Exception ex) {
        ClientDTO clientDTO = new ClientDTO()
                .id(null)
                .address(null)
                .dni(null)
                .birth(null)
                .cuil(null)
                .email(null)
                .lastname(null)
                .name(null)
                .telephone(null);
        return ResponseEntity.ok(clientDTO);
    }
}
