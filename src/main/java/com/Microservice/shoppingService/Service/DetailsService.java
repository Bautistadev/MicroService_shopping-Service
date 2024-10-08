package com.Microservice.shoppingService.Service;

import com.Microservice.shoppingService.Entity.DetailsEntity;
import com.Microservice.shoppingService.MicroService.ProductRest;
import com.Microservice.shoppingService.Repository.DetailsRepository;
import com.Microservice.shoppingService.Service.Mapper.DetailsMapper;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;
import com.Microservice.shoppingService.model.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetailsService {

    private DetailsRepository detailsRepository;

    private DetailsMapper detailsMapper;


    @Autowired
    private ProductRest productRest;


    public DetailsService(DetailsRepository detailsRepository, DetailsMapper detailsMapper) {
        this.detailsRepository = detailsRepository;
        this.detailsMapper = detailsMapper;

    }

    /**
     * @Operation: Retrive all Details
     * @Return: DetailsDTO List
     * */
    public List<DetailsDTO> retriveAll(String authorization){
        List<DetailsDTO> response =  this.detailsRepository.findAll().stream().map(e ->{
            DetailsDTO res = this.detailsMapper.map(e);
            res.setProduct(this.productRest.retriveById(e.getProductId(),authorization).getBody());
            return res;
        }).collect(Collectors.toList());

        return response;
    }

    /**
     * @Operation: Retrive Detail by id
     * @Param: Integer
     * @Return: DetailsDTO
     * */
    public DetailsDTO findById(Integer id,String authorization){
        DetailsEntity details = this.detailsRepository.findById(id).get();
        DetailsDTO response = this.detailsMapper.map(details);
        response.setProduct(this.productRest.retriveById(response.getProductId(),authorization).getBody());
        return response;
    }

    /**
     * @Operation: Save detail
     * @Param: DetailsRequestDTO
     * @Return: DetailsDTO
     * */
    public DetailsDTO save(DetailsRequestDTO detailsRequestDTO,String authorization){

        DetailsEntity details = this.detailsMapper.map(detailsRequestDTO);

        ProductDTO productDTO = this.productRest.retriveById(details.getProductId(),authorization).getBody();

        details.setAmount(calculateMount(productDTO.getPrice(),details.getQuantity(),details.getDiscount()));

        return this.detailsMapper.map(this.detailsRepository.save(details));
    }

    private Float calculateMount(BigDecimal price, Integer quantity, Float discount){

        Float amount =  price.floatValue() * quantity;

        if(discount != null || discount != 0)
            return amount - amount*(discount/100);

        return amount;
    }

    /**
     * @Operation: Update detail
     * @Param: DetailsDTO
     * @Return: DetailsDTO
     * */
    public DetailsDTO update(DetailsDTO detailsDTO){
        DetailsEntity details = this.detailsRepository.save(this.detailsMapper.map(detailsDTO));
        return this.detailsMapper.map(details);
    }

    /**
     * @Operation: retrive by sale id
     * @Param: Integer
     * @Return: DetailsDTO List
     * */
    public List<DetailsDTO> retrieveBySaleId(Integer id){
        return this.detailsRepository.findBysaleId(id).stream().map(e ->{
            return this.detailsMapper.map(e);
        }).collect(Collectors.toList());
    }

    /**
     * @Operation: remove details by id
     * @Param: Integer
     * @Return: Boolean
     * */
    public Boolean removeDetail(Integer id){
        this.detailsRepository.deleteById(id);
        return true;
    }


}
