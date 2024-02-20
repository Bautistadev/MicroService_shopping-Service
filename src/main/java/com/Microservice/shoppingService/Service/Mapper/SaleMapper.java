package com.Microservice.shoppingService.Service.Mapper;

import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.model.SaleDTO;
import com.Microservice.shoppingService.model.SaleRequestDTO;

public interface SaleMapper {
    public SaleDTO map(SaleEntity sale);
    public SaleEntity map(SaleDTO saleDTO);
    public SaleEntity map(SaleRequestDTO saleRequestDTO);
}
