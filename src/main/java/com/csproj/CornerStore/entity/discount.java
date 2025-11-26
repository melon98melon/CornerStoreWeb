package com.csproj.CornerStore.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "discount")
public class discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "new_price", nullable = false)
    private Double newPrice;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product;

    // Constructors
    public discount() {}

    public discount(LocalDate startDate, LocalDate endDate, Double newPrice, product product) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.newPrice = newPrice;
        this.product = product;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public Double getNewPrice() { return newPrice; }
    public void setNewPrice(Double newPrice) { this.newPrice = newPrice; }

    public product getProduct() { return product; }
    public void setProduct(product product) { this.product = product; }
}
