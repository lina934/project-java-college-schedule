
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
public class Controllerdepartment4 {
      @FXML
    private AnchorPane departments;
     public void LEVEL4csAction(ActionEvent e) throws IOException{
        
            //    departments.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 4 cs.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,726,199);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
     public void LEVEL4isAction(ActionEvent e) throws IOException{
        
              //  departments.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 4 is.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,693,189);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
     public void LEVEL4itAction(ActionEvent e) throws IOException{
        
                //departments.getScene().getWindow().hide();
    Parent root = FXMLLoader.load(getClass().getResource("level 4 it.fxml"));
        Stage doctor = new Stage();
        Scene scene = new Scene(root,752,220);
        doctor.setScene(scene);
        doctor.setResizable(false);
        doctor.show();
    
    }
}
