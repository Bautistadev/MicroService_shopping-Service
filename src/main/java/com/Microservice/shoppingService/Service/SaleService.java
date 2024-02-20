package com.Microservice.shoppingService.Service;

import com.Microservice.shoppingService.Entity.SaleEntity;
import com.Microservice.shoppingService.Repository.SaleRepository;
import com.Microservice.shoppingService.Service.Mapper.SaleMapper;
import com.Microservice.shoppingService.model.SaleDTO;
import com.Microservice.shoppingService.model.SaleRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    private SaleRepository saleRepository;
    private SaleMapper saleMapper;

    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
    }

    public List<SaleDTO> retriveAll(){

        List<SaleDTO> response = this.saleRepository.findAll().stream().map(e ->{
            return this.saleMapper.map(e);
        }).collect(Collectors.toList());

        return response;
    }

    public SaleDTO save(SaleRequestDTO sale){
        SaleEntity saleEntity = this.saleMapper.map(sale);

        SaleDTO saleDTO = this.saleMapper.map(this.saleRepository.save(saleEntity));

        return saleDTO;
    }

    public SaleDTO findById(Integer id){
        return this.saleMapper.map(this.saleRepository.findById(id).get());
    }

    public List<SaleDTO> findByClientId(Integer id){

        List<SaleDTO> response = this.saleRepository.findByClientId(id).stream().map(e ->{
            return this.saleMapper.map(e);
        }).collect(Collectors.toList());
        return response;
    }

    public SaleDTO update(SaleDTO saleDTO){
        SaleEntity saleEntity = this.saleMapper.map(saleDTO);
        return this.saleMapper.map(this.saleRepository.save(saleEntity));
    }

}
