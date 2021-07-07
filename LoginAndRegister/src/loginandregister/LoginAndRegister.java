/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginandregister;
import java.sql.*;
import javax.swing.*;


/**
 *
 * @author alex2
 */
public class LoginAndRegister {
    private static final String USERNAME = "DBSquad457";
    private static final String PASSWORD= "databasesquad457";
    private static final String CONN_STRING= "jdbc:mysql://dbsquad457.cut5lvk5kkip.us-east-2.rds.amazonaws.com:3306/DatabaseSquad457";
    public static void main(String[] args) {


        
    }
    
   //Method to create user account 
   public static int createAccount(String social,String firstName, String lastName, String username, String password, String position, String address){
        Connection conn = null;
        int flag = 0;
       try{
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            System.out.println("Connected!");
            Statement stmt = (Statement) conn.createStatement();

            String insert = "INSERT INTO User " + "Values ('" + social + "','" + firstName + "','" + lastName  + "','" + username  + "','" + password  + "','" + address  + "','" + position + "')";
            flag = 1;
            stmt.executeUpdate(insert);
            return flag;
        }catch (SQLException e){
            System.err.println(e);
        }
       return 0;
   }
   //Method to create admin account
   public static int createAdminAccount(String social,String firstName, String lastName, String username, String password, String address){
       Connection conn = null;
       int flag = 0;
       try{
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            System.out.println("Connected!");
            Statement stmt = (Statement) conn.createStatement();

            String insert = "INSERT INTO admin " + "Values ('" + social + "','" + firstName + "','" + lastName  + "','" + username  + "','" + password  + "','" + address + "')";
            flag = 1;
            stmt.executeUpdate(insert);
            return flag;
        }catch (SQLException e){
            System.err.println(e);
        }
       return 0;
   }
   //Method for user login
   public static int login(String username, String password){
       Connection conn = null;
       PreparedStatement pst=null;
       ResultSet rs=null;
       int flag;
       
        try{
           conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
           String Sql = "Select * from User where username = '" + username + "' AND password = '" + password + "'";
           
           
           System.out.println("Connected!");
           pst = conn.prepareStatement(Sql);

           rs=pst.executeQuery();
           if(rs.next()){
               System.out.println("User has logged in successfully.");
               flag = 1;
               return flag;
           }
           else{
               JOptionPane.showMessageDialog(null, "Invalid Username or Password","Access Denied",JOptionPane.ERROR_MESSAGE);              
           }
   
        } catch (SQLException e){
            System.err.println(e);
        }
       return 0;
   }
   
      //Method for admin to login
      public static int adminLogin(String username, String password){
       Connection conn = null;
       PreparedStatement pst=null;
       ResultSet rs=null;
       int flag;
       
        try{
           conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
           String Sql = "Select * from admin where username = '" + username + "' AND password = '" + password + "'";
           
           
           System.out.println("Connected!");
           pst = conn.prepareStatement(Sql);

           rs=pst.executeQuery();
           if(rs.next()){
               System.out.println("User has logged in successfully.");
               flag = 1;
               return flag;
           }
           else{
               JOptionPane.showMessageDialog(null, "Invalid Username or Password","Access Denied",JOptionPane.ERROR_MESSAGE);  
           }
           
        } catch (SQLException e){
            System.err.println(e);
        }
       return 0;
   }
   
      //method for admin to delete account
   public static void deleteAccount(String SSN, String username){
       Connection conn = null;
       PreparedStatement pst=null;
       ResultSet rs=null;
       
       try{
           conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
           
           Statement stmt = (Statement) conn.createStatement();
           String insert = "Delete FROM User Where SSN = '" + SSN + "' AND username = '" + username + "';";
           stmt.executeUpdate(insert);
   
      } catch (SQLException e){
            System.err.println(e);
        }
       
   }
   
   public static void returnBill(String billNum){
      Connection conn = null;
      PreparedStatement pst=null;
      ResultSet rs=null;
       
      try{
          conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
          Statement stmt = (Statement) conn.createStatement();

          rs = stmt.executeQuery("Select * from Transactions where BillNum = '" + billNum + "';");
          System.out.println(rs); //gets the first column's rows.

          
   
      } catch (SQLException e){
            System.err.println(e);
        }
       
   }
   
}