/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_table;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Lina Hazem
 */
public class Controllerchoose {
    @FXML
    private AnchorPane choose;
  
    public void DoctorAction(ActionEvent e) throws IOException{
        
                choose.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("Doctor_Table.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,852,667);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
    public void EngineerAction(ActionEvent e) throws IOException{
        
                choose.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("Engineer_Table.fxml"));
        Stage engineer = new Stage();
        Scene scene = new Scene(root,852,667);
        engineer.setScene(scene);
        engineer.setResizable(false);
        engineer.show();
    }
    public void LevelAction(ActionEvent e) throws IOException{
        
                choose.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("levels_table.fxml"));
        Stage engineer = new Stage();
        Scene scene = new Scene(root,636,494);
        engineer.setScene(scene);
        engineer.setResizable(false);
        engineer.show();
    }
    

}
