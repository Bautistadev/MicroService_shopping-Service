package com.Microservice.shoppingService.Service;

import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.MicroService.ClientRest;
import com.Microservice.shoppingService.MicroService.ProductRest;
import com.Microservice.shoppingService.Repository.SaleRepository;
import com.Microservice.shoppingService.Service.Mapper.SaleMapper;
import com.Microservice.shoppingService.model.SaleDTO;
import com.Microservice.shoppingService.model.SaleRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    private SaleRepository saleRepository;
    private SaleMapper saleMapper;

    /**
     * Rest API
     * */
    @Autowired
    private ClientRest clientRest;

    @Autowired
    private ProductRest productRest;


    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper ) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    /**
     * @Operation: Retrive all sale
     * @Return: SaleDTO List
     * */
    public List<SaleDTO> retrieveAll(String authorization){

        List<SaleDTO> response = this.saleRepository.findAll().stream().map(e ->{
            return this.findById(e.getId(),authorization);
        }).collect(Collectors.toList());


        return response;
    }
    /**
     * @Operation: SAVE
     * @Param: SaleRequestDTO
     * @Return SaleDTO
     * */
    public SaleDTO save(SaleRequestDTO sale){
        SaleEntity saleEntity = this.saleMapper.map(sale);

        SaleDTO saleDTO = this.saleMapper.map(this.saleRepository.save(saleEntity));

        return saleDTO;
    }

    /**
     * @Operation: FIND SALE BY ID
     * @Param: Integer
     * @Return SaleDTO
     * */
    public SaleDTO findById(Integer id,String authorization){
        SaleDTO response = this.saleMapper.map(this.saleRepository.findById(id).get());
        /**REST PETITION*/
        response.setClient(this.clientRest.retriveClientById(response.getClientId(),authorization).getBody());
        response.getDetails().stream().map(e ->{
             e.setProduct(this.productRest.retriveById(e.getProductId()).getBody());
             return e;
        }).collect(Collectors.toList());
        return response;

    }
    /**
     * @Operation: FIND SALE BY ClientID
     * @Param: Integer
     * @Return SaleDTO
     * */
    public List<SaleDTO> findByClientId(Integer id,String authorization){

        List<SaleDTO> response = this.saleRepository.findByClientId(id).stream().map(e ->{
            return this.findById(e.getId(),authorization);
        }).collect(Collectors.toList());

        return response;
    }
    /**
     * @Operation: Update
     * @Param: SaleDTO
     * @Return SaleDTO
     * */
    public SaleDTO update(SaleDTO saleDTO){
        SaleEntity saleEntity = this.saleMapper.map(saleDTO);
        return this.saleMapper.map(this.saleRepository.save(saleEntity));
    }

}
