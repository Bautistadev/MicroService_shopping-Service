package com.Microservice.shoppingService.Repository;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailsRepository extends JpaRepository<DetailsEntity,Integer> {
    public List<DetailsEntity> findBysaleId(Integer id);
}
