package com.Microservice.shoppingService.Service.Mapper;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;

public interface DetailsMapper {
    public DetailsEntity map(DetailsRequestDTO detailsRequestDTO);
    public DetailsDTO map(DetailsEntity detailsEntity);
    public DetailsEntity map(DetailsDTO detailsDTO);
}
