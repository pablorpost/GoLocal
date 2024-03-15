package es.hack4good.golocal.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import es.hack4good.golocal.models.Location;

@Entity(tableName = "user")
public class User {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "email")
    private String email;
    @ColumnInfo(name = "password")
    private int hashedPassword;
    @ColumnInfo(name = "phone")
    private String phone;
    @ColumnInfo(name = "address")
    private Location address;
    @ColumnInfo(name = "image")
    private String image;
    public User(int id, String name, String email, String password, String phone, Location address, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.hashedPassword = password.hashCode();
        this.phone = phone;
        this.address = address;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getHashedPassword(){
        return hashedPassword;
    }

    public void setPassword(String password) {
        this.hashedPassword = password.hashCode();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Location getAddress() {
        return address;
    }

    public void setAddress(Location address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
