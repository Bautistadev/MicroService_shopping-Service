package com.Microservice.shoppingService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Sale")
public class SaleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clientId")
    private Integer clientId;

    @Column(name = "amount",nullable = true)
    private Float amount;

    @Column(name = "dateCreated")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "sale", fetch = FetchType.EAGER)
    private List<DetailsEntity> details;


    @Override
    public String toString() {
        return "SaleEntity{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", amount=" + amount +
                ", dateCreated=" + dateCreated +
                ", details=" + details +
                '}';
    }
}
