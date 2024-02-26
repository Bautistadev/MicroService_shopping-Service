package com.Microservice.shoppingService;

import com.Microservice.shoppingService.MicroService.ClientRest;
import com.Microservice.shoppingService.MicroService.ProductRest;
import com.Microservice.shoppingService.Service.DetailsService;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;
import com.Microservice.shoppingService.model.SaleDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.Microservice.shoppingService")
@EnableFeignClients
@RefreshScope
public class MainApplication implements CommandLineRunner {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(MainApplication.class, args);

		ProductRest clientRest = ctx.getBean(ProductRest.class);

		System.out.println(clientRest.retriveById(1).getBody().toString());


	}

	@Override
	public void run(String... args) throws Exception {

	}
}
