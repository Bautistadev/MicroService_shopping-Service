package com.Microservice.shoppingService;

import com.Microservice.shoppingService.Service.DetailsService;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;
import com.Microservice.shoppingService.model.SaleDTO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.Microservice.shoppingService")
public class MainApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

		DetailsService saleService = ctx.getBean(DetailsService.class);
		/*
		DetailsRequestDTO derail = new DetailsRequestDTO()
				.productId(1)
				.amount(500f)
				.quantity(1)
				.sale(new SaleDTO().id(1))
				.discount(5f);


		System.out.println(saleService.save(derail));*/

	}

}
