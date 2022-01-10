/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my_table;

/**
 *
 * @author Lina Hazem
 */
public class users {
    String  id;
    int theater,senior;
    String doctor_name , subject ,department,appointment;

    public users(String id, String doctor_name, String subject, int theater,int senior, String department, String appointment) {
        this.id = id;
        this.theater = theater;
        this.doctor_name = doctor_name;
        
        this.subject = subject;
        this.department = department;
        this.appointment = appointment;
           this.senior = senior;
          
    }
    public int getSenior() {
        return senior;
    }

    public void setSenior(int senior) {
        this.senior = senior;
    }

  
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public int getTheater() {
        return theater;
    }

    public void setTheater(int theater) {
        this.theater = theater;
    }

  

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

  

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAppointment() {
        return appointment;
    }

    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }
    
}
