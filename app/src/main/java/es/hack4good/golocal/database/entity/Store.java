package es.hack4good.golocal.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

import es.hack4good.golocal.models.Location;

public class Store {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "location")
    private Location location;
    @ColumnInfo(name = "image")
    private String image;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "web")
    private String web;
    public Store(long id,String name, Location location, String image, String description, String phone, String email, String web) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.image = image;
        this.description = description;
        this.phone = phone;
        this.email = email;
        this.web = web;
    }

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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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


}
