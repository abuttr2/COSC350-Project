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
    
    //Does user exist
    //Get password for user
    //
    
   public static int createAccount(String social,String firstName, String lastName, String username, String password, String address){
        Connection conn = null;
        int flag = 0;
       try{
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            System.out.println("Connected!");
            Statement stmt = (Statement) conn.createStatement();

            String insert = "INSERT INTO User " + "Values ('" + social + "','" + firstName + "','" + lastName  + "','" + username  + "','" + password  + "','" + address + "')";
            flag = 1;
            stmt.executeUpdate(insert);
            return flag;
        }catch (SQLException e){
            System.err.println(e);
        }
       return 0;
   }
   
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
           
           //Statement stmt = (Statement) conn.createStatement();
           
           
           
           
        } catch (SQLException e){
            System.err.println(e);
        }
       return 0;
   }
   
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
           
           //Statement stmt = (Statement) conn.createStatement();
           
           
           
           
        } catch (SQLException e){
            System.err.println(e);
        }
       return 0;
   }
}