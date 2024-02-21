package com.Microservice.shoppingService.Service;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import com.Microservice.shoppingService.Repository.DetailsRepository;
import com.Microservice.shoppingService.Service.Mapper.DetailsMapper;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailsService {

    private DetailsRepository detailsRepository;

    private DetailsMapper detailsMapper;

    public DetailsService(DetailsRepository detailsRepository, DetailsMapper detailsMapper) {
        this.detailsRepository = detailsRepository;
        this.detailsMapper = detailsMapper;
    }

    public List<DetailsDTO> retriveAll(){
        List<DetailsDTO> response =  this.detailsRepository.findAll().stream().map(e ->{
            return this.detailsMapper.map(e);
        }).collect(Collectors.toList());

        return response;
    }

    public DetailsDTO findById(Integer id){
        DetailsEntity details = this.detailsRepository.findById(id).get();

        return this.detailsMapper.map(details);
    }

    public DetailsDTO save(DetailsRequestDTO detailsRequestDTO){
        DetailsEntity details = this.detailsRepository.save(this.detailsMapper.map(detailsRequestDTO));
        return this.detailsMapper.map(details);
    }

    public DetailsDTO update(DetailsDTO detailsDTO){
        DetailsEntity details = this.detailsRepository.save(this.detailsMapper.map(detailsDTO));
        return this.detailsMapper.map(details);
    }

    public List<DetailsDTO> retriveBySaleId(Integer id){
        return this.detailsRepository.findBysaleId(id).stream().map(e ->{
            return this.detailsMapper.map(e);
        }).collect(Collectors.toList());
    }

    public Boolean removeDetail(Integer id){
        this.detailsRepository.deleteById(id);
        return true;
    }


}
