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
public class Controllerlevels {
    @FXML
    private AnchorPane levels;
     public void LEVEL1Action(ActionEvent e) throws IOException{
        
                levels.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 1.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,790,290);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
     public void LEVEL2Action(ActionEvent e) throws IOException{
        
                levels.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 2.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,635,383);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
     public void LEVEL3Action(ActionEvent e) throws IOException{
        
                levels.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("departments.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,636,494);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
     public void LEVEL4Action(ActionEvent e) throws IOException{
        
                levels.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("departments4.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,636,494);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
}
