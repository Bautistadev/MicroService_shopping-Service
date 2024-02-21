package com.Microservice.shoppingService.Controller;

import com.Microservice.shoppingService.DetailsApiDelegate;
import com.Microservice.shoppingService.Service.DetailsService;
import com.Microservice.shoppingService.model.DetailsDTO;
import com.Microservice.shoppingService.model.DetailsListDTO;
import com.Microservice.shoppingService.model.DetailsRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class DetailsController implements DetailsApiDelegate {

    private DetailsService detailsService;

    public DetailsController(DetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @Override
    public ResponseEntity<DetailsDTO> createDetail(DetailsRequestDTO detailsRequestDTO) {

        DetailsDTO detailsDTO = this.detailsService.save(detailsRequestDTO);

        return ResponseEntity.status(HttpStatus.OK).body(detailsDTO);
    }

    @Override
    public ResponseEntity<Void> removeDetailById(Integer id) {

        if(this.detailsService.removeDetail(id))
            return ResponseEntity.status(HttpStatus.OK).build();
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @Override
    public ResponseEntity<DetailsListDTO> retriveAllDetails() {
        DetailsListDTO detailsListDTO = new DetailsListDTO().items(this.detailsService.retriveAll());

        System.out.println(this.detailsService.retriveAll());

        return ResponseEntity.status(HttpStatus.OK).body(detailsListDTO);
    }

    @Override
    public ResponseEntity<DetailsDTO> retriveDetailById(Integer id) {

        DetailsDTO response =  this.detailsService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    public ResponseEntity<DetailsListDTO> retriveDetailBySaleId(Integer id) {

        DetailsListDTO detailsListDTO = new DetailsListDTO().items(this.detailsService.retriveBySaleId(id));
        return ResponseEntity.status(HttpStatus.OK).body(detailsListDTO);
    }

    @Override
    public ResponseEntity<DetailsDTO> updateDetail(DetailsDTO detailsDTO) {
        return DetailsApiDelegate.super.updateDetail(detailsDTO);
    }
}
