package com.kpi.models.entity;

import java.io.Serializable;

public class HomeAppliance implements Serializable {


    private int number;
    private String type;
    private String model;
    private String name;
    private String firm;
    private int quantity;
    private double price;
    private int productionDate;

    public HomeAppliance() {}

    public HomeAppliance(
            int number,
            String type,
            String model,
            String name,
            String firm,
            int quantity,
            double price,
            int productionDate
            ) {
        this.number = number;
        this.type = type;
        this.model = model;
        this.name = name;
        this.firm = firm;
        this.quantity = quantity;
        this.price = price;
        this.productionDate = productionDate;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(int productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public String toString() {
        return String.format("|\tItem #%3d\t|\ttype: %15s\t|\tmodel: %15s\t|\tname: %35s\t|\tfirm: %12s\t|\tquantity: %5d\t|\tprice: %.2f\t|\tdate of production: %4d\t|",
                this.number, this.type, this.model, this.name, this.firm, this.quantity, this.price, this.productionDate);
    }
}
