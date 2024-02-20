package com.Microservice.shoppingService;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.Repository.SaleRepository;
import com.Microservice.shoppingService.Service.SaleService;
import com.Microservice.shoppingService.model.SaleRequestDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.Microservice.shoppingService")
public class MainApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

		SaleService saleService = ctx.getBean(SaleService.class);


		System.out.println(saleService.findByClientId(1));

	}

}
