package com.csproj.CornerStore.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "orderitem")
public class orderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private customerOrder order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private product product;

    @Column(nullable = false)
    private Integer quantity;

    // Constructors
    public orderItem() {}

    public orderItem(customerOrder order, product product, Integer quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public customerOrder getOrder() { return order; }
    public void setOrder(customerOrder order) { this.order = order; }

    public product getProduct() { return product; }
    public void setProduct(product product) { this.product = product; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}

