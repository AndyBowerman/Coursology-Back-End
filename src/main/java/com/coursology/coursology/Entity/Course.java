package com.coursology.coursology.Entity;

import jakarta.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String img;
    private String name;
    private String description;
    private int duration; // months
    private int price;
    private boolean shortCourse;

    public Course() {
    }

    public Course(int id, String img, String name, String description, int duration, int price, boolean shortCourse) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.price = price;
        this.shortCourse = shortCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isShortCourse() {
        return shortCourse;
    }

    public void setShortCourse(boolean shortCourse) {
        this.shortCourse = shortCourse;
    }
}
