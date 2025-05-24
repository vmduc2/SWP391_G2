package model;

import java.time.LocalDateTime;

public class Product {
    private Integer productId;
    private String name;
    private double price;
    private String description;
    private int stockQuantity;
    private Integer categoryId;
    private String purpose;
    private String imageUrl;
    private int shelfLifeDays;
    private LocalDateTime createdAt;
    private ProductStatus status;

    public enum ProductStatus {
        New,
        Building,
        Done,
        Approved,
        Re_Assign,
        Expired
    }

 
    public Product() {
        this.createdAt = LocalDateTime.now();
        this.status    = ProductStatus.New;
    }

    public Product(Integer productId, String name, double price, String description,
                   int stockQuantity, Integer categoryId, String purpose, String imageUrl,
                   int shelfLifeDays, LocalDateTime createdAt, ProductStatus status) {
        this.productId     = productId;
        this.name          = name;
        this.price         = price;
        this.description   = description;
        this.stockQuantity = stockQuantity;
        this.categoryId    = categoryId;
        this.purpose       = purpose;
        this.imageUrl      = imageUrl;
        this.shelfLifeDays = shelfLifeDays;
        this.createdAt     = createdAt;
        this.status        = status;
    }
    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }

    public String getPurpose() { return purpose; }
    public void setPurpose(String purpose) { this.purpose = purpose; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public int getShelfLifeDays() { return shelfLifeDays; }
    public void setShelfLifeDays(int shelfLifeDays) { this.shelfLifeDays = shelfLifeDays; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public ProductStatus getStatus() { return status; }
    public void setStatus(ProductStatus status) { this.status = status; }
    public LocalDateTime getExpirationDate() {
        return createdAt.plusDays(shelfLifeDays);
    }

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(getExpirationDate());
    }

    @Override
    public String toString() {
        return "Product{" +
               "productId=" + productId +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", description='" + description + '\'' +
               ", stockQuantity=" + stockQuantity +
               ", categoryId=" + categoryId +
               ", purpose='" + purpose + '\'' +
               ", imageUrl='" + imageUrl + '\'' +
               ", shelfLifeDays=" + shelfLifeDays +
               ", createdAt=" + createdAt +
               ", status=" + status +
               '}';
    }
}
