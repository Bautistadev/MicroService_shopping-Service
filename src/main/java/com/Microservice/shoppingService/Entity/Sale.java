package com.Microservice.shoppingService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Sale")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clientId")
    private Integer ClientId;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "dateCreated")
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "sale")
    private List<DetailsEntity> details;

    @Override
    public String toString() {
        return "Sale{" +
                "id=" + id +
                ", ClientId=" + ClientId +
                ", amount=" + amount +
                ", dateCreated=" + dateCreated +
                ", details=" + details +
                '}';
    }
}
