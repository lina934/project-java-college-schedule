/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_table;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 *
 * @author Lina Hazem
 */
public class Controllerlogin  implements Initializable {
       @FXML
    private Label loginmessagelabel;
      @FXML
    private ProgressIndicator loading;
    @FXML
        private TextField usernametextfield;
    @FXML
        private PasswordField passwordfield; 
    @FXML
    private AnchorPane login;
       @Override
     public void initialize(URL location, ResourceBundle resources) {
       loading.setVisible(false);
    }
        public void loginAction(ActionEvent e) throws IOException, SQLException {
       loading.setVisible(true);
       String pass =  passwordfield.getText();
       String uname =  usernametextfield.getText();
     
       
     String Driver ="com.mysql.jdbc.Driver";
      String  USERNAME = "root";
      String URL ="jdbc:mysql://localhost:3306/login-data"; 
      Connection connection = null;
      try {
            connection = DriverManager.getConnection(URL, USERNAME, "");
                System.out.print("Database Connected !");
                Statement stmt = connection.createStatement();
                if (uname.isEmpty()== false &&pass.isEmpty()== false){
                    loginmessagelabel.setText("you try to login");
                    String SQL = "SELECT * FROM datalog WHERE name='" + uname + "' && Password='" + pass+ "'";
                    // String SQLadduser = "INSERT INTO `datalog` (`name`, `Password`) VALUES ('"+name_from_the_GUI+"', '"+password_from_the_code+"')";
                    //
             
                    ResultSet rs = stmt.executeQuery(SQL);
                    String databaseUsername = "";
                    String databasePassword = "";
                    while (rs.next()) {
                    databaseUsername = rs.getString("name");
                    databasePassword = rs.getString("Password");
                    break;
                    }
                   if (uname.equals(databaseUsername) && pass.equals(databasePassword)) {
                       System.out.println("Successful Login!\n----");
                       login.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("Choose_Table.fxml"));
                   Stage choose = new Stage();
                   Scene scene = new Scene(root,562,409);
                   choose.setScene(scene);
                   choose.setResizable(false);
                   choose.show();
                   } else {
                       System.out.println("Incorrect Password\n----"); 
                       loginmessagelabel.setText("please enter username and passsword");
                               }   
//        
        }}
      catch (SQLException ex) {
            Logger.getLogger(Controllerlogin.class.getName()).log(Level.SEVERE, null, ex);
              
              }}}

