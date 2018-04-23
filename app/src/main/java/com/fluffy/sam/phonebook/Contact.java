package com.fluffy.sam.phonebook;

/**
 * Created by samrith on 24/1/18.
 */

public class Contact{

    private int id;
    private String engname;
    private String khname;
    private String phone;
    private String image;
    private String type;

    public Contact(int id, String engname, String khname, String phone, String image) {
        this.id = id;
        this.engname = engname;
        this.khname = khname;
        this.phone = phone;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEngname() {
        return engname;
    }

    public void setEngname(String engname) {
        this.engname = engname;
    }

    public String getKhname() {
        return khname;
    }

    public void setKhname(String khname) {
        this.khname = khname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
