package com.example.myapplication.listview;

public class Technology {
    private int img;
    private String name, sub, desc;
    public Technology(int img, String name, String sub, String desc) {
        this.img = img;
        this.name = name;
        this.sub = sub;
        this.desc = desc;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
