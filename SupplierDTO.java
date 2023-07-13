/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryapp.dto;

/**
 *
 * @author Sharon
 */
public class SupplierDTO {
 
  private int suppID;
  
  private double debit;
  
  private double credit;
  
  private double balance;
  
  private String suppCode;
  
  private String fullName;
  
  private String location;
  
  private String phone;
  
  public int getSuppID() {
    return this.suppID;
  }
  
  public void setSuppID(int suppID) {
    this.suppID = suppID;
  }
  
  public double getDebit() {
    return this.debit;
  }
  
  public void setDebit(double debit) {
    this.debit = debit;
  }
  
  public double getCredit() {
    return this.credit;
  }
  
  public void setCredit(double credit) {
    this.credit = credit;
  }
  
  public double getBalance() {
    return this.balance;
  }
  
  public void setBalance(double balance) {
    this.balance = balance;
  }
  
  public String getSuppCode() {
    return this.suppCode;
  }
  
  public void setSuppCode(String suppCode) {
    this.suppCode = suppCode;
  }
  
  public String getFullName() {
    return this.fullName;
  }
  
  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  
  public String getLocation() {
    return this.location;
  }
  
  public void setLocation(String location) {
    this.location = location;
  }
  
  public String getPhone() {
    return this.phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }   
}
