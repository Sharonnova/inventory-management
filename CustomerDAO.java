/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryapp.dao;
import com.mycompany.inventoryapp.dto.CustomerDTO;
import com.mycompany.inventoryapp.database.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Sharon
 */
public class CustomerDAO {
 Connection conn = null;
  
  PreparedStatement prepStatement = null;
  
  Statement statement = null;
  
  ResultSet resultSet = null;
  
  public CustomerDAO() {
    try {
      this.conn = (new ConnectionFactory()).getConn();
      this.statement = this.conn.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void addCustomerDAO(CustomerDTO customerDTO) {
    try {
      String query = "SELECT * FROM customers WHERE fullname='" + customerDTO.getFullName() + "' AND location='" + customerDTO.getLocation() + "' AND phone='" + customerDTO.getPhone() + "'";
      this.resultSet = this.statement.executeQuery(query);
      if (this.resultSet.next()) {
        JOptionPane.showMessageDialog(null, "Customer already exists.");
      } else {
        addFunction(customerDTO);
      } 
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void addFunction(CustomerDTO customerDTO) {
    try {
      String query = "INSERT INTO customers VALUES(null,?,?,?,?)";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, customerDTO.getCustCode());
      this.prepStatement.setString(2, customerDTO.getFullName());
      this.prepStatement.setString(3, customerDTO.getLocation());
      this.prepStatement.setString(4, customerDTO.getPhone());
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "New customer has been added.");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void editCustomerDAO(CustomerDTO customerDTO) {
    try {
      String query = "UPDATE customers SET fullname=?,location=?,phone=? WHERE customercode=?";
      this.prepStatement = this.conn.prepareStatement(query);
      this.prepStatement.setString(1, customerDTO.getFullName());
      this.prepStatement.setString(2, customerDTO.getLocation());
      this.prepStatement.setString(3, customerDTO.getPhone());
      this.prepStatement.setString(4, customerDTO.getCustCode());
      this.prepStatement.executeUpdate();
      JOptionPane.showMessageDialog(null, "Customer details have been updated.");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public void deleteCustomerDAO(String custCode) {
    try {
      String query = "DELETE FROM customers WHERE customercode='" + custCode + "'";
      this.statement.executeUpdate(query);
      JOptionPane.showMessageDialog(null, "Customer removed.");
    } catch (SQLException e) {
      e.printStackTrace();
    } 
  }
  
  public ResultSet getQueryResult() {
    try {
      String query = "SELECT customercode,fullname,location,phone FROM customers";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public ResultSet getCustomerSearch(String text) {
    try {
      String query = "SELECT customercode,fullname,location,phone FROM customers WHERE customercode LIKE '%" + text + "%' OR fullname LIKE '%" + text + "%' OR location LIKE '%" + text + "%' OR phone LIKE '%" + text + "%'";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public ResultSet getCustName(String custCode) {
    try {
      String query = "SELECT * FROM customers WHERE customercode='" + custCode + "'";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public ResultSet getProdName(String prodCode) {
    try {
      String query = "SELECT productname,currentstock.quantity FROM products INNER JOIN currentstock ON products.productcode=currentstock.productcode WHERE currentstock.productcode='" + prodCode + "'";
      this.resultSet = this.statement.executeQuery(query);
    } catch (SQLException e) {
      e.printStackTrace();
    } 
    return this.resultSet;
  }
  
  public DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
    ResultSetMetaData metaData = resultSet.getMetaData();
    Vector<String> columnNames = new Vector<>();
    int colCount = metaData.getColumnCount();
    for (int col = 1; col <= colCount; col++)
      columnNames.add(metaData.getColumnName(col).toUpperCase(Locale.ROOT)); 
    Vector<Vector<Object>> data = new Vector<>();
    while (resultSet.next()) {
      Vector<Object> vector = new Vector();
      for (int i = 1; i <= colCount; i++)
        vector.add(resultSet.getObject(i)); 
      data.add(vector);
    } 
    return new DefaultTableModel((Vector)data, columnNames);
  }    
}
