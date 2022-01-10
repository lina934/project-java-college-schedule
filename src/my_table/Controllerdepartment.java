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
public class Controllerdepartment {
    @FXML
    private AnchorPane department;
     public void LEVEL3csAction(ActionEvent e) throws IOException{
        
//                department.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 3 cs.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,690,305);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
     public void LEVEL3isAction(ActionEvent e) throws IOException{
        
              //  department.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 3 is.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,636,226);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
     public void LEVEL3itAction(ActionEvent e) throws IOException{
        
             //   department.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 3 it.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,600,297);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
}
