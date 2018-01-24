package com.fluffy.sam.phonebook;

/**
 * Created by samrith on 24/1/18.
 */

public class Contact {

    public String engname;
    public String khname;
    public String phone;
    public String type;
    public String photo;
    public String image;

    public Contact(String engname, String khname, String phone, String photo, String image) {
        this.engname = engname;
        this.khname = khname;
        this.phone = phone;
        this.photo = photo;
        this.image = image;
    }
}
