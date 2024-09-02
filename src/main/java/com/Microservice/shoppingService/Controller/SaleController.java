package com.Microservice.shoppingService.Controller;

import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.SalesApiDelegate;
import com.Microservice.shoppingService.Service.SaleService;
import com.Microservice.shoppingService.model.*;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shopping/")
public class SaleController implements SalesApiDelegate {

    private SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<SaleListDTO> retrieveAllSales(String authorization) {
        SaleListDTO saleListDTO = new SaleListDTO().items(this.saleService.retrieveAll(authorization));
        return ResponseEntity.status(HttpStatus.OK).body(saleListDTO);
    }

    /**
     * POST
     * */
    @Override
    public ResponseEntity<SaleDTO> createSale(SaleRequestDTO saleRequestDTO) {
        SaleDTO saleEntity = this.saleService.save(saleRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(saleEntity);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<Void> removeSaleById(Integer id) {
        return SalesApiDelegate.super.removeSaleById(id);
    }

    /**
    * GET
    * */
    @Override
    public ResponseEntity<SaleDTO> retrieveSaleById(Integer id,String authorization) {
        SaleDTO response = this.saleService.findById(id,authorization);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * POST
     * */
    @Override
    public ResponseEntity<SaleDTO> updateSale(SaleDTO saleDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(this.saleService.update(saleDTO));
    }

    /**
     * GET
     * */
    /*public ResponseEntity<SaleListDTO> retrieveSaleByClientId(Integer id,String authorization) {
        List<SaleDTO> saleDTO = this.saleService.findByClientId(id,authorization);
        SaleListDTO resonse =  new SaleListDTO().items(saleDTO);
        return ResponseEntity.status(HttpStatus.OK).body(resonse);
    }*/

    @Override
    public ResponseEntity<SaleListDTO> retrieveSaleByClientId(Integer id, String authorization) {
        List<SaleDTO> saleDTO = this.saleService.findByClientId(id,authorization);
        SaleListDTO resonse =  new SaleListDTO().items(saleDTO);
        System.out.println(authorization);
        return ResponseEntity.status(HttpStatus.OK).body(resonse);
    }
}
