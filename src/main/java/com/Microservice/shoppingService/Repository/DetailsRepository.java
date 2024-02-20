package com.Microservice.shoppingService.Repository;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailsRepository extends JpaRepository<DetailsEntity,Integer> {
}
