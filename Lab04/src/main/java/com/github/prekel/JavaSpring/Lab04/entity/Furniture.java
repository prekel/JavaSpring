package com.github.prekel.JavaSpring.Lab04.entity;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.StringJoiner;

public class Furniture {
    private int id;
    private String type;
    private String model;
    private String manufacturer;
    private BigDecimal cost;
    private double height;

    public Furniture(String type, String model, String manufacturer, BigDecimal cost, double height) {
        this.type = type;
        this.model = model;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Furniture.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("type='" + type + "'")
                .add("model='" + model + "'")
                .add("manufacturer='" + manufacturer + "'")
                .add("cost=" + cost)
                .add("height=" + height)
                .toString();
    }
}
