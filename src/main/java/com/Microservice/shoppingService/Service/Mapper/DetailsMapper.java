package com.Microservice.shoppingService.Service.Mapper;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;

public interface DetailsMapper {

    /**
     * @Param: DetailsRequestDTO
     * @Return: DetailsEntity
     * */
    public DetailsEntity map(DetailsRequestDTO detailsRequestDTO);

    /**
     * @Param: DetailsEntity
     * @Return: DetailsDTO
     * */
    public DetailsDTO map(DetailsEntity detailsEntity);

    /**
     * @Param: DetailsDTO
     * @Return: DetailsEntity
     * */
    public DetailsEntity map(DetailsDTO detailsDTO);
}
