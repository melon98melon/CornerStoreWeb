package com.csproj.CornerStore.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "customerorder")
public class customerOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "total_amount", nullable = false)
    private Float totalAmount;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private customer customer;

    // Constructors
    public customerOrder() {}

    public customerOrder(LocalDate orderDate, Float totalAmount, customer customer) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.customer = customer;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }

    public Float getTotalAmount() { return totalAmount; }
    public void setTotalAmount(Float totalAmount) { this.totalAmount = totalAmount; }

    public customer getCustomer() { return customer; }
    public void setCustomer(customer customer) { this.customer = customer; }
}
