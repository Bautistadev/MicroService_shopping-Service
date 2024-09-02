package com.Microservice.shoppingService.Service.Mapper;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;
import com.Microservice.shoppingService.model.SaleDTO;

public class DetailsMapperImplements implements DetailsMapper{
    public DetailsMapperImplements() {
        super();
    }

    @Override
    public DetailsEntity map(DetailsRequestDTO detailsRequestDTO) {

        DetailsEntity details = DetailsEntity.builder()
                .quantity(detailsRequestDTO.getQuantity())
                .discount(detailsRequestDTO.getDiscount())
                .productId(detailsRequestDTO.getProductId())
                .sale(SaleEntity.
                        builder().
                        id(detailsRequestDTO.getSale().getId())
                        .build())
                .build();



        return details;
    }

    @Override
    public DetailsDTO map(DetailsEntity detailsEntity) {

        DetailsDTO detailsDTO = new DetailsDTO()
                .id(detailsEntity.getId())
                .productId(detailsEntity.getProductId())
                .quantity(detailsEntity.getQuantity())
                .amount(detailsEntity.getAmount())
                .discount(detailsEntity.getDiscount());

        SaleDTO saleDTO = new SaleDTO()
                .id(detailsEntity.getSale().getId());
        detailsDTO.sale(saleDTO);

        return detailsDTO;
    }

    @Override
    public DetailsEntity map(DetailsDTO detailsDTO) {

        DetailsEntity detailsEntity = DetailsEntity.builder()
                .id(detailsDTO.getId())
                .productId(detailsDTO.getProductId())
                .quantity(detailsDTO.getQuantity())
                .amount(detailsDTO.getAmount())
                .discount(detailsDTO.getDiscount())
                .build();

        SaleEntity saleEntity = SaleEntity.builder()
                .id(detailsEntity.getSale().getId())
                .build();
        detailsEntity.setSale(saleEntity);

        return detailsEntity;
    }
}
