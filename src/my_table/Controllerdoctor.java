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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author Lina Hazem
 */
public class Controllerdoctor implements Initializable {
      @FXML
    private TableColumn<users, String> cod_appointment;

    @FXML
    private TableColumn<users, String> cod_department;

    @FXML
    private TableColumn<users,String> cod_id;

    @FXML
    private TableColumn<users, String> cod_name;

    @FXML
    private TableColumn<users, Integer> cod_senior;

    @FXML
    private TableColumn<users, String> cod_subject;

    @FXML
    private TableColumn<users, Integer> cod_theater;

    @FXML
    private TableView<users> table_userd;
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
    private TextField txt_theater;
  @FXML
        private Label loginmessagelabel;
    @FXML
        private TextField usernametextfield;
    @FXML
        private PasswordField passwordfield; 
    @FXML
    private TextField filterfield;
   
    ObservableList<users> listM = FXCollections.observableArrayList();
    
    ObservableList<users> datalist =FXCollections.observableArrayList();
    String query;
    
    int index = -1;
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
     @Override
    public void initialize(URL url, ResourceBundle rb) {
       
          try {
              UpdateTable();
          } catch (SQLException ex) {
              Logger.getLogger(Controllerdoctor.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              search();
          } catch (SQLException ex) {
              Logger.getLogger(Controllerdoctor.class.getName()).log(Level.SEVERE, null, ex);
          }
        
         
    }  
    
     public void addUser() {
            
         conn = Sql.connectDB();
        
         try{
         pst = conn.prepareStatement("INSERT INTO datadoc (doctor_name, subjects, theater, senior_year, department, appointments) VALUES (?,?,?,?,?,?)");
         pst.setString(1,txt_name .getText());
         pst.setString(2,txt_subject.getText() );
         pst.setString(3,txt_theater.getText() );
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
   index = table_userd.getSelectionModel().getSelectedIndex();
   if(index < -1){
       return;
   }
   txt_id.setText(cod_id.getCellData(index));
   txt_name.setText(cod_name.getCellData(index).toString());
   txt_subject.setText(cod_subject.getCellData(index).toString());
   txt_senior.setText(cod_senior.getCellData(index).toString());
   txt_theater.setText(cod_theater.getCellData(index).toString());
   txt_department.setText(cod_department.getCellData(index).toString());
   txt_appointment.setText(cod_appointment.getCellData(index).toString());
   
   }
    
   public void Edit(){
    try
    {

    String value1 = txt_id.getText();
    String value2 = txt_name.getText();
    String value3 = txt_subject.getText();
    String value4 = txt_theater.getText();
    String value5 = txt_senior.getText();
    String value6 = txt_department.getText();
    String value7 = txt_appointment.getText();
        conn = Sql.connectDB();
    
    String sql = "update datadoc set doc_id ='"+value1+ "',doctor_name=' "+value2+" ' ,subjects=' "+value3+"',theater='"+value4+ "',senior_year='"+value5+ "',department='"+value6+ "',appointments='"+value7
            + "'WHERE doc_id = '" +value1+"' ";
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
              query = "SELECT doc_id , doctor_name , subjects , theater , senior_year , department , appointments  FROM datadoc";
              pst = conn.prepareStatement(query);
              rs = pst.executeQuery();
              while (rs.next()) {
                  listM.add(new users(
                          rs.getString("doc_id"),
                          rs.getString("doctor_name"),
                          rs.getString("subjects"),
                          rs.getInt("theater"),
                          rs.getInt("senior_year"),
                          rs.getString("department"),
                          rs.getString("appointments")));
                  table_userd.setItems(listM);
                  
              }
          } catch (SQLException ex) {
              Logger.getLogger(Controllerdoctor.class.getName()).log(Level.SEVERE, null, ex);
          }
       
    }
   public void UpdateTable() throws SQLException{
       conn = Sql.connectDB();
       refreshTable();
   
   cod_id.setCellValueFactory(new PropertyValueFactory<>("id"));
       cod_name.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));
       cod_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
       cod_theater.setCellValueFactory(new PropertyValueFactory<>("theater"));
        cod_senior.setCellValueFactory(new PropertyValueFactory<>("senior"));
       cod_department.setCellValueFactory(new PropertyValueFactory<>("department"));
       cod_appointment.setCellValueFactory(new PropertyValueFactory<>("appointment"));
       table_userd.setItems(listM);
   }
   
@FXML
    public void search() throws SQLException {

        cod_id.setCellValueFactory(new PropertyValueFactory<>("id"));
       cod_name.setCellValueFactory(new PropertyValueFactory<>("doctor_name"));
       cod_subject.setCellValueFactory(new PropertyValueFactory<>("subject"));
       cod_theater.setCellValueFactory(new PropertyValueFactory<>("theater"));
        cod_senior.setCellValueFactory(new PropertyValueFactory<>("senior"));
       cod_department.setCellValueFactory(new PropertyValueFactory<>("department"));
       cod_appointment.setCellValueFactory(new PropertyValueFactory<>("appointment"));

        datalist = Sql.getDatadoctor();
       table_userd.setItems(datalist);

        FilteredList<users> filteredList = new FilteredList<>(datalist, b -> true);
        filterfield.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(person -> {
                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }
                String searchKey = newValue.toLowerCase();

                if (person.getDoctor_name().toLowerCase().indexOf(searchKey) != -1) {
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
        SortedList<users> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(table_userd.comparatorProperty());

        table_userd.setItems(sortedList);

    }
   public void delete() throws SQLException {
        conn =Sql.connectDB();
        String sql = "delete from datadoc where doc_id = ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, txt_id.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Deleted");
           UpdateTable();
            search();
        } catch (SQLException ex) {
            Logger.getLogger(Controllerdoctor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
   

          
}
