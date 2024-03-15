package es.hack4good.golocal.entities;

import java.util.HashMap;

public class Store {
    private String name;
    private Location location;
    public HashMap<Long, Product> products;
    private String image;
    private String description;
    private String phone;
    private String email;
    private String web;
    public Store(String name, Location location, String image, String description, String phone, String email, String web) {
        this.name = name;
        this.location = location;
        this.image = image;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.web = web;
        this.products = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public HashMap<Long, Product> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Long, Product> products) {
        this.products = products;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    private boolean addProduct(Product product) {
        if(products.containsKey(product.getId())) {
            return false;
        }
        products.put(product.getId(), product);
        return true;
    }

    private boolean removeProduct(Product product) {
        if(products.containsKey(product.getId())) {
            products.remove(product.getId());
            return true;
        }
        return false;
    }

    private boolean updateProduct(Product product) {
        if(products.containsKey(product.getId())) {
            products.put(product.getId(), product);
            return true;
        }
        return false;
    }
}
