package com.fluffy.sam.phonebook;

/**
 * Created by samrith on 1/1/18.
 */

public class RowItem {
    public int id;
    public String name;
    public String image;
    public String type;

    public RowItem(int id, String name, String image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    public RowItem(int id, String name, String image, String type) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
    }

    public RowItem() {

    }

    public RowItem(int id, String name) {
        this.id = id;
        this.name = name;
        this.image ="schedule";
    }

    public RowItem(String name, String image, String type) {
        this.name = name;
        this.image = image;
        this.type = type;
    }

    public RowItem(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
