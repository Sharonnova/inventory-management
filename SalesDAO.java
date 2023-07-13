/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryapp.dao;
import com.mycompany.inventoryapp.dto.SalesDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Sharon
 */
public class SalesDAO {
     private final Connection connection;

    public SalesDAO(Connection connection) {
        this.connection = connection;
    }

    // Method to add a new sales record
    public void addSalesRecord(SalesDTO salesDTO) {
        try {
            String query = "INSERT INTO sales (productcode, quantity, saleprice, saledate) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, salesDTO.getProductCode());
            preparedStatement.setInt(2, salesDTO.getQuantity());
            preparedStatement.setDouble(3, salesDTO.getSalePrice());
            preparedStatement.setDate(4, salesDTO.getSaleDate());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Sales record added successfully.");
        } catch (SQLException e) {
            System.out.println("Error adding sales record: " + e.getMessage());
        }
    }
    // Method to delete a sales record by ID
    public void deleteSalesDAO(int salesId) {
         try {
        String query = "DELETE FROM sales WHERE salesid = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, salesId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("Sales record deleted successfully.");
    } catch (SQLException e) {
        System.out.println("Error deleting sales record: " + e.getMessage());
    }
}

}
