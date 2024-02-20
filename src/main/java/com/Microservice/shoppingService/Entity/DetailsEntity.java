package com.Microservice.shoppingService.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="Details")
public class DetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "quantity", nullable = false)
    private Integer quantity;
    @Column(name = "productId", nullable = false)
    private Integer productId;
    @Column(name = "amount", nullable = false)
    private Float amount;
    @Column(name = "discount", nullable = true)
    private Float discount;

    @ManyToOne
    @JoinColumn(name = "saleId")
    private SaleEntity sale;


    public Float getTamount(){

        if(discount == null)
            return this.amount * this.quantity;
        else
            return (this.amount * this.quantity)*(this.quantity/100);
    }

    @Override
    public String toString() {
        return "DetailsEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", productId=" + productId +
                ", amount=" + amount +
                ", Tamount" + getTamount() +
                ", discount=" + discount +

                '}';
    }
}
