package com.Microservice.shoppingService.Controller;

import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.SalesApiDelegate;
import com.Microservice.shoppingService.Service.SaleService;
import com.Microservice.shoppingService.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SaleController implements SalesApiDelegate {

    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @Override
    public ResponseEntity<SaleListDTO> retriveAllSales() {

        SaleListDTO saleListDTO = new SaleListDTO().items(this.saleService.retriveAll());

        return ResponseEntity.status(HttpStatus.OK).body(saleListDTO);
    }

    @Override
    public ResponseEntity<SaleDTO> createSale(SaleRequestDTO saleRequestDTO) {
        SaleDTO saleEntity = this.saleService.save(saleRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(saleEntity);
    }

    @Override
    public ResponseEntity<Void> removeSaleById(Integer id) {
        return SalesApiDelegate.super.removeSaleById(id);
    }

    @Override
    public ResponseEntity<SaleDTO> retriveSaleById(Integer id) {
        SaleDTO response = this.saleService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<SaleDTO> updateSale(SaleDTO saleDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.saleService.update(saleDTO));
    }

    @Override
    public ResponseEntity<SaleListDTO> retriveSaleByClientId(Integer id) {
        List<SaleDTO> saleDTO = this.saleService.findByClientId(id);
        SaleListDTO resonse =  new SaleListDTO().items(saleDTO);
        return ResponseEntity.status(HttpStatus.OK).body(resonse);
    }
}
