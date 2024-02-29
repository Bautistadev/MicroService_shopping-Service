package com.Microservice.shoppingService.Service.Mapper;

import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.model.SaleDTO;
import com.Microservice.shoppingService.model.SaleRequestDTO;

public interface SaleMapper {

    /**
     * @Param: SaleEntity
     * @Return: SaleDTO
     * */
    public SaleDTO map(SaleEntity sale);

    /**
     * @Param: SaleDTO
     * @Return: SaleEntity
     * */
    public SaleEntity map(SaleDTO saleDTO);

    /**
     * @Param: SaleRequestDTO
     * @Return: SaleEntity
     * */
    public SaleEntity map(SaleRequestDTO saleRequestDTO);
}
