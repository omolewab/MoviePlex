package com.example.finalproject;

public class DataModel {
    private String title;
    private int imageResource;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public DataModel(String title, int imageResource) {
        this.title = title;
        this.imageResource = imageResource;
    }
}
