package com.Microservice.shoppingService.Configuration;

import com.Microservice.shoppingService.Repository.SaleRepository;
import com.Microservice.shoppingService.Service.Mapper.SaleMapper;
import com.Microservice.shoppingService.Service.Mapper.SaleMapperImplements;
import com.Microservice.shoppingService.Service.SaleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationBean {

    @Bean
    public SaleMapper saleMapper(){
        return new SaleMapperImplements();
    }

    @Bean
    public SaleService saleService(SaleRepository saleRepository,SaleMapper saleMapper){
        return new SaleService(saleRepository,saleMapper);
    }
}
