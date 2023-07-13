/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryapp.ui;
import com.mycompany.inventoryapp.dto.UserDTO;
import com.mycompany.inventoryapp.database.ConnectionFactory;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Sharon
 */
public class LoginPage extends JFrame {
    UserDTO userDTO;
  
  LocalDateTime inTime;
  
  String userType;
  
  private JButton clearButton;
  
  private JComboBox<String> jComboBox1;
  
  private JLabel jLabel1;
  
  private JLabel jLabel2;
  
  private JLabel jLabel3;
  
  private JButton loginButton;
  
  private JPasswordField passText;
  
  private JTextField userText;
  
  public LoginPage() {
    initComponents();
    this.userDTO = new UserDTO();
  }
  
  private void initComponents() {
    this.jLabel1 = new JLabel();
    this.jLabel2 = new JLabel();
    this.userText = new JTextField();
    this.passText = new JPasswordField();
    this.jLabel3 = new JLabel();
    this.jComboBox1 = new JComboBox<>();
    this.loginButton = new JButton();
    this.clearButton = new JButton();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("Login");
    getContentPane().setBackground(Color.WHITE);
    setBounds(new Rectangle(500, 100, 0, 0));
    setName("loginFrame");
    this.jLabel1.setFont(new Font("Segoe UI", 0, 14));
    this.jLabel1.setText("Username:");
    this.jLabel2.setFont(new Font("Segoe UI", 0, 14));
    this.jLabel2.setText("Password:");
    this.jLabel3.setFont(new Font("Poor Richard", 1, 24));
    this.jLabel3.setHorizontalAlignment(0);
    this.jLabel3.setText("ELECTRATECH EXPRESS INVENTORY");
    this.jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "ADMINISTRATOR", "EMPLOYEE" }));
    this.loginButton.setText("LOGIN");
    this.loginButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.loginButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            loginButtonActionPerformed(evt);
          }
        });
    this.clearButton.setText("CLEAR");
    this.clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    this.clearButton.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent evt) {
            clearButtonActionPerformed(evt);
          }
        });
    GroupLayout layout = new GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(47, 47, 47)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addGroup(layout.createSequentialGroup()
              .addGap(42, 42, 42)
              .addComponent(loginButton, -2, 100, -2)
              .addGap(18, 18, 18)
              .addComponent(clearButton, -2, 100, -2))
            .addGroup(layout.createSequentialGroup()
              .addComponent(jLabel1, -2, 74, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(userText))
            .addGroup(layout.createSequentialGroup()
              .addComponent(jLabel2, -2, 74, -2)
              .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
              .addComponent(passText))
            .addComponent(jComboBox1, 0, -1, 32767)
            .addComponent(jLabel3, -1, 284, 32767))
          .addContainerGap(52, 32767)));
    layout.setVerticalGroup(layout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(layout.createSequentialGroup()
          .addGap(44, 44, 44)
          .addComponent(jLabel3, -2, 44, -2)
          .addGap(57, 57, 57)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
            .addComponent(userText, -1, 31, 32767)
            .addComponent(jLabel1, -1, -1, 32767))
          .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
            .addComponent(passText, -2, 32, -2)
            .addGroup(layout.createSequentialGroup()
              .addComponent(jLabel2, -2, 33, -2)
              .addGap(1, 1, 1)))
          .addGap(18, 18, 18)
          .addComponent(jComboBox1, -1, 28, 32767)
          .addGap(46, 46, 46)
          .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(loginButton, -2, 37, -2)
            .addComponent(clearButton, -2, 37, -2))
          .addGap(80, 80, 80)));
    pack();
  }
  
  private String encryptPass(String pass) {
    String encPass = null;
    if (pass == null)
      return null; 
    try {
      MessageDigest mDigest = MessageDigest.getInstance("MD5");
      mDigest.update(pass.getBytes(), 0, pass.length());
      encPass = (new BigInteger(1, mDigest.digest())).toString(16);
    } catch (Exception ex) {
      ex.printStackTrace();
    } 
    return encPass;
  }
  
  private void loginButtonActionPerformed(ActionEvent evt) {
    String username = userText.get.Text();
    String password = passText.get.Text();
    userType = (String) jComboBox1.getSelectedItem();
    if ((new ConnectionFactory()).checkLogin(username, password, this.userType)) {
      inTime = LocalDateTime.now();
      userDTO.setInTime(String.valueOf(inTime));
      dispose();
      new Dashboard(username, userType, userDTO).setVisible(true);
    } else {
      JOptionPane.showMessageDialog(null, "Invalid username or password.");
    }
  }
  
  private void clearButtonActionPerformed(ActionEvent evt) {
    userText.setText("");
    passText.setText("");
  }
  
  public static void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
      Logger.getLogger(LoginPage.class.getName()).log(Level.SEVERE, null, ex);
    }
    EventQueue.invokeLater(new Runnable() {
          @Override
          public void run() {
            new LoginPage().setVisible(true);
          }
        });
  }
}
