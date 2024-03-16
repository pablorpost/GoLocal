package es.hack4good.golocal.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import es.hack4good.golocal.models.OrderStatus;

@Entity(tableName = "orders")
public class Order {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "user_id")
    private long userId;
    @ColumnInfo(name = "product_id")
    private long productId;
    @ColumnInfo(name = "price")
    private double price;
    @ColumnInfo(name = "quantity")
    private int quantity;
    @ColumnInfo(name = "date")
    private String date;
    @ColumnInfo(name = "location")
    private String location;
    @ColumnInfo(name = "paid")
    private boolean paid;
    @ColumnInfo(name = "status")
    private OrderStatus status;

    public Order(long userId, long productId, double price, int quantity, String date, String location, boolean paid, OrderStatus status) {
        this.userId = userId;
        this.productId = productId;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.location = location;
        this.paid = false;
        this.status = OrderStatus.PENDING;
    }

    public Order(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
