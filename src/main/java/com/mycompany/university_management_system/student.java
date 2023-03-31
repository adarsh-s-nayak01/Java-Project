/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.university_management_system;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author mkvar
 */
public class student implements userInterface {
    String studentName;
    String studentId;
    String phoneNumber;
    String address;
    Boolean paidFee;
    Boolean admissionStat;
    String batch;
    @Override
    public String[] displayDetails(){
        String[] val={this.studentName,this.studentId};
        return val;
    }
    @Override
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    @Override
    public void setAddress(String address){
        this.address=address;
    }
    @Override
    public void updateUserData(Connection c){
        Statement stmt=null;
        try{
            stmt = c.createStatement();
            String sql = "UPDATE student set student_name='"+studentName+"',phone_num='"+phoneNumber+"',address='"+address+"' where student_id='"+studentId+"';";
            System.out.println(sql);
            stmt.executeUpdate(sql);
            stmt.close();
        }
        catch(Exception e){
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            System.exit(0);
        }
    }
    student(String studentName,String studentId,String phoneNumber,String address){
        this.studentName=studentName;
        this.studentId=studentId;
        this.phoneNumber=phoneNumber;
        this.address=address;
    }
}
