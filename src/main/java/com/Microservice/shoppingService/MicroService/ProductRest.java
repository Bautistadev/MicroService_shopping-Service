package com.Microservice.shoppingService.MicroService;

import com.Microservice.shoppingService.model.ProductDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="product-Service",path="/api/v1/products")
public interface ProductRest {

    @GetMapping(value= "/products/{productId}")
    /**Patron Circuit breaker*/
    @CircuitBreaker(name="retriveById", fallbackMethod = "defaultById")
    public ResponseEntity<ProductDTO> retriveById(@PathVariable("productId") Integer productId, @RequestHeader("Authorization") String authorizationHeader);

    /**
     * Funcion que retorna por defecto en caso de fallo en la conexion al microservicio
     * */
    public default  ResponseEntity<ProductDTO> defaultById(Integer productId,String authorizationHeader, Exception e){
        ProductDTO productDTO = new ProductDTO()
                .id(null)
                .brand(null)
                .name(null)
                .status(null)
                .price(null)
                .dateCreated(null);
        return ResponseEntity.status(HttpStatus.OK).body(productDTO);
    }
}
