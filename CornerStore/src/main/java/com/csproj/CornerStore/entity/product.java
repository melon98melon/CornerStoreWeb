package com.csproj.CornerStore.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment id
    private Long id;

    private String name;
    private Float price;
    private String description;
    private Integer stock;
    private String image;

    @ManyToOne 
    @JoinColumn(name = "category_id", nullable = false)
    private categories category;

    // Constructors
    public product() {}

    public product(String name, Float price, String description, Integer stock, String image, categories category) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
        this.image = image;
        this.category = category;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Float getPrice() { return price; }
    public void setPrice(Float price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public categories getCategory() { return category; }
    public void setCategory(categories category) { this.category = category; }
}
