package com.Microservice.shoppingService.Service.Mapper;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.SaleDTO;
import com.Microservice.shoppingService.model.SaleRequestDTO;

import java.util.stream.Collectors;

public class SaleMapperImplements implements SaleMapper{

    @Override
    public SaleDTO map(SaleEntity sale) {

        SaleDTO saleDTO = new SaleDTO()
                .id(sale.getId())
                .clientId(sale.getClientId())
                .dateCreated(sale.getDateCreated())
                .amount(sale.getAmount());

        if(sale.getDetails() != null) {
            saleDTO.setDetails(sale.getDetails().stream().map(e -> {
                return new DetailsDTO()
                        .id(e.getId())
                        .amount(e.getAmount())
                        .quantity(e.getQuantity())
                        .discount(e.getDiscount())
                        .productId(e.getProductId());
            }).collect(Collectors.toList()));
        }

        return saleDTO;
    }

    @Override
    public SaleEntity map(SaleDTO saleDTO) {
        SaleEntity saleEntity = SaleEntity.builder()
                .id(saleDTO.getId())
                .clientId(saleDTO.getClientId())
                .amount(saleDTO.getAmount())
                .dateCreated(saleDTO.getDateCreated())
                .build();
        saleEntity.setDetails(saleDTO.getDetails().stream().map(e ->{
            return DetailsEntity.builder()
                    .id(e.getId())
                    .amount(e.getAmount())
                    .discount(e.getDiscount())
                    .quantity(e.getQuantity())
                    .productId(e.getProductId())
                    .build();

        }).collect(Collectors.toList()));

        return saleEntity;

    }

    @Override
    public SaleEntity map(SaleRequestDTO saleDTO) {
        SaleEntity saleEntity = SaleEntity.builder()
                .clientId(saleDTO.getClientId())
                .amount(saleDTO.getAmount())
                .dateCreated(saleDTO.getDateCreated())
                .build();

        return saleEntity;
    }
}
