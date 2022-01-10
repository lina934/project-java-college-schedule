/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_table;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import static my_table.Sql.connectDB;

/**
 *
 * @author Lina Hazem
 */
public class Sql {
    private static Connection connection = null;
    
public static Connection connectDB(){

    try{
     
      connection  = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-data","root","");
     JOptionPane.showMessageDialog(null, "ConnectionEstablished");
    
    }catch (Exception e){
    JOptionPane.showMessageDialog(null, e);
    
    }
    return connection;
    }

   public  static ObservableList<users> getDatadoctor() throws SQLException  {
    
        Connection conn = connectDB();
        ObservableList<users> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("SELECT doc_id , doctor_name , subjects , theater , senior_year , department , appointments  FROM datadoc");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new users(rs.getString("doc_id"), rs.getString("doctor_name"), rs.getString("subjects"),rs.getInt("theater"), rs.getInt("senior_year"), rs.getString("department"), rs.getString("appointments")));
           
        }
  
     return list;
   }
   public  static ObservableList<usereng> getDataengineer() throws SQLException  {
    
        Connection conn = connectDB();
        ObservableList<usereng> list = FXCollections.observableArrayList();
        PreparedStatement ps = conn.prepareStatement("SELECT Eng_id , Engineer_name , subjects , lab , senior_year , department , appointments  FROM dataeng");
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            list.add(new usereng(rs.getString("Eng_id"), rs.getString("Engineer_name"), rs.getString("subjects"),rs.getInt("lab"), rs.getInt("senior_year"), rs.getString("department"), rs.getString("appointments")));
           
        }
  
     return list;
   }
}

 

     
    
 
    
    
    ///////////////////////////
  
     
//    public static Connection connecteDB(){
//    try{
//     Class.forName("com.mysql.jdbc.Driver");
//     Connection conn  = DriverManager.getConnection("jdbc:mysql://localhost:3306/login-data","root","");
//     JOptionPane.showMessageDialog(null, "ConnectionEstablished");
//     return conn;
//    }catch (Exception e){
//    JOptionPane.showMessageDialog(null, e);
//    return null;
//    }
// 
//    }

    

    