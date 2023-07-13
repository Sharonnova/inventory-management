/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryapp.dto;
import java.sql.Date;

/**
 *
 * @author Sharon
 */
public class SalesDTO {
private String productCode;
    private int quantity;
    private int SalesID;
    private double salePrice;
    private Date saleDate;

    public SalesDTO(String productCode, int SalesID, int quantity, double salePrice, Date saleDate) {
        this.productCode = productCode;
        this.quantity = quantity;
        this.salePrice = salePrice;
        this.saleDate = saleDate;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }    
}
