package com.Microservice.shoppingService.Repository;

import com.Microservice.shoppingService.Entity.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity,Integer> {

    @Query(value = "SELECT * FROM sale WHERE client_id = ?1" ,nativeQuery = true)
    public List<SaleEntity> findByClientId(Integer clientId);
}
