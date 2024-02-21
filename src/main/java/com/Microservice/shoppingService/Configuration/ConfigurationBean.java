package com.Microservice.shoppingService.Configuration;

import com.Microservice.shoppingService.Repository.DetailsRepository;
import com.Microservice.shoppingService.Repository.SaleRepository;
import com.Microservice.shoppingService.Service.DetailsService;
import com.Microservice.shoppingService.Service.Mapper.DetailsMapper;
import com.Microservice.shoppingService.Service.Mapper.DetailsMapperImplements;
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
    public DetailsMapper detailsMapper(){
        return new DetailsMapperImplements();
    }
    @Bean
    public SaleService saleService(SaleRepository saleRepository,SaleMapper saleMapper){
        return new SaleService(saleRepository,saleMapper);
    }

    @Bean
    public DetailsService detailsService(DetailsRepository detailsRepository, DetailsMapper detailsMapper){
        return new DetailsService(detailsRepository,detailsMapper);
    }
}
