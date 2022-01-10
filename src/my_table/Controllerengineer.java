/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_table;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Lina Hazem
 */
public class Controllerengineer implements Initializable{
    @FXML
    private TableColumn<usereng, String> coe_appointment;

    @FXML
    private TableColumn<usereng, String> coe_department;

    @FXML
    private TableColumn<usereng, String> coe_id;

    @FXML
    private TableColumn<usereng, Integer> coe_lab;

    @FXML
    private TableColumn<usereng, String> coe_name;

    @FXML
    private TableColumn<usereng, Integer> coe_senior;

    @FXML
    private TableColumn<usereng, String> coe_subject;

    @FXML
    private TableView<usereng> table_usere;
    @FXML
    private TextField txt_appointment;

    @FXML
    private TextField txt_department;

    @FXML
    private TextField txt_id;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_senior;

    @FXML
    private TextField txt_subject;

    @FXML
    private TextField txt_lab;
@FXML
    private TextField filterfield;


 ObservableList<usereng> listM = FXCollections.observableArrayList();
    
    ObservableList<usereng> datalist =FXCollections.observableArrayList();
    String query;



  int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         try {
              UpdateTable();
          } catch (SQLException ex) {
              Logger.getLogger(Controllerengineer.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              search();
          } catch (SQLException ex) {
              Logger.getLogger(Controllerengineer.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    public void addUser() {
            
         conn = Sql.connectDB();
        
         try{
         pst = conn.prepareStatement("INSERT INTO dataeng (Engineer_name, subjects, lab, senior_year, department, appointments) VALUES (?,?,?,?,?,?)");
         pst.setString(1,txt_name .getText());
         pst.setString(2,txt_subject.getText() );
         pst.setString(3,txt_lab.getText() );
         pst.setString(4,txt_senior.getText() );
         pst.setString(5,txt_department.getText() );
         pst.setString(6,txt_appointment.getText() );
         pst.execute();
         JOptionPane.showMessageDialog(null, "user add success");
         UpdateTable();
         }catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         }}
    
    public void getSelected(){
   index = table_usere.getSelectionModel().getSelectedIndex();
   if(index < -1){
       return;
   }
   txt_id.setText(coe_id.getCellData(index));
   txt_name.setText(coe_name.getCellData(index).toString());
   txt_subject.setText(coe_subject.getCellData(index).toString());
    txt_lab.setText(coe_lab.getCellData(index).toString());
   txt_senior.setText(coe_senior.getCellData(index).toString());
   txt_department.setText(coe_department.getCellData(index).toString());
   txt_appointment.setText(coe_appointment.getCellData(index).toString());
   
   }
   public void Edit(){
    try
    {

    String value1 = txt_id.getText();
    String value2 = txt_name.getText();
    String value3 = txt_subject.getText();
    String value4 = txt_lab.getText();
    String value5 = txt_senior.getText();
    String value6 = txt_department.getText();
    String value7 = txt_appointment.getText();
        conn = Sql.connectDB();
    
    String sql = "update dataeng set Eng_id ='"+value1+ "',Engineer_name=' "+value2+" ' ,subjects=' "+value3+"',lab='"+value4+ "',senior_year='"+value5+ "',department='"+value6+ "',appointments='"+value7
            + "'WHERE Eng_id = '" +value1+"' ";
    pst=conn.prepareStatement(sql);
    pst.execute();
    JOptionPane.showMessageDialog(null, "Updatde");
    UpdateTable();
    }catch(Exception e){
    
    }
   }
   @FXML
    private void refreshTable()  {
          try {
              listM.clear();
              query = "SELECT Eng_id , Engineer_name , subjects , lab , senior_year , department , appointments  FROM dataeng";
              pst = conn.prepareStatement(query);
              rs = pst.executeQuery();
              while (rs.next()) {
                  listM.add(new usereng(
                          rs.getString("Eng_id"),
                          rs.getString("Engineer_name"),
                          rs.getString("subjects"),
                          rs.getInt("lab"),
                          rs.getInt("senior_year"),
                          rs.getString("department"),
                          rs.getString("appointments")));
                  table_usere.setItems(listM);
                  
              }
          } catch (SQLException ex) {
              Logger.getLogger(Controllerengineer.class.getName()).log(Level.SEVERE, null, ex);
          }
       
    }
    
   public void UpdateTable() throws SQLException{
       conn = Sql.connectDB();
       refreshTable();
   
         coe_id.setCellValueFactory(new PropertyValueFactory<>("id"));
         coe_name.setCellValueFactory(new PropertyValueFactory<>("engineer_name"));
         coe_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
         coe_lab.setCellValueFactory(new PropertyValueFactory<>("lab"));
         coe_senior.setCellValueFactory(new PropertyValueFactory<>("senior"));
         coe_department.setCellValueFactory(new PropertyValueFactory<>("department"));
         coe_appointment.setCellValueFactory(new PropertyValueFactory<>("appointment"));
         table_usere.setItems(listM);
   }
    @FXML
    public void search() throws SQLException {

        coe_id.setCellValueFactory(new PropertyValueFactory<>("id"));
       coe_name.setCellValueFactory(new PropertyValueFactory<>("engineer_name"));
       coe_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
       coe_lab.setCellValueFactory(new PropertyValueFactory<>("lab"));
        coe_senior.setCellValueFactory(new PropertyValueFactory<>("senior"));
       coe_department.setCellValueFactory(new PropertyValueFactory<>("department"));
       coe_appointment.setCellValueFactory(new PropertyValueFactory<>("appointment"));
        datalist = Sql.getDataengineer();
       table_usere.setItems(datalist);

        FilteredList<usereng> filteredList = new FilteredList<>(datalist, b -> true);
        filterfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(person -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();

                if (person.getEngineer_name().toLowerCase().indexOf(searchKey) != -1) {
                    return true;
                } else if (person.getDepartment().toLowerCase().indexOf(searchKey) != -1) {
                    return true;
                } else if (person.getSubject().indexOf(searchKey) != -1) {
                    return true;
                } else if (person.getAppointment().toLowerCase().indexOf(searchKey) != -1) {
                    return true;
              
                } else {
                    return false;
                }
            });
        });
        SortedList<usereng> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(table_usere.comparatorProperty());

        table_usere.setItems(sortedList);

    }
    public void delete() throws SQLException {
        conn =Sql.connectDB();
        String sql = "delete from dataeng where Eng_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
           UpdateTable();
            search();
        } catch (SQLException ex) {
            Logger.getLogger(Controllerengineer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   
    
}
