package es.hack4good.golocal.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import es.hack4good.golocal.models.ProductType;

@Entity(tableName = "product")
public class Product {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "type")
    private ProductType type;
    @ColumnInfo(name = "store_id")
    private long storeId;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "stock")
    private int stock;

    public Product(long id, String name, String description, double price, ProductType type, long storeId, String image, int stock) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
        this.storeId = storeId;
        this.image = image;
        this.stock = stock;
    }

    public Product(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public long getStoreId() {
        return storeId;
    }

    public void setStore(long storeId) {
        this.storeId = storeId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void addStock(int stock) {
        this.stock += stock;
    }

    public void removeStock(int stock) {
        this.stock -= stock;
    }

    public boolean hasStock(int stock) {
        return this.stock >= stock;
    }

    public boolean isType(ProductType type) {
        return this.type.equals(type);
    }

    public void setStoreId(long storeId) {
        this.storeId = storeId;
    }
}

