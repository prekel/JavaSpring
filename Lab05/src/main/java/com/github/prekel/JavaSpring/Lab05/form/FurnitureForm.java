package com.github.prekel.JavaSpring.Lab05.form;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class FurnitureForm {
    @NotNull(message = "Поле не должно быть пустым")
    @PositiveOrZero(message = "Должно быть положительным")
    private int id;
    @NotBlank(message = "Поле не должно быть пустым")
    private String type;
    @NotBlank(message = "Поле не должно быть пустым")
    private String model;
    @NotBlank(message = "Поле не должно быть пустым")
    private String manufacturer;
    @NotNull(message = "Поле не должно быть пустым")
    @Positive(message = "Должно быть положительным")
    private BigDecimal cost;
    @NotNull(message = "Поле не должно быть пустым")
    @Min(value = 10, message = "Не должно быть менее 10")
    @Max(value = 1000, message = "Не должно быть более 1000")
    private double height;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
}
