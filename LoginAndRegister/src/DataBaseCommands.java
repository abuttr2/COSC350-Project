
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alex2
 */
public class DataBaseCommands {
    private static final String USERNAME = "DBSquad457";
    private static final String PASSWORD= "databasesquad457";
    private static final String CONN_STRING= "jdbc:mysql://dbsquad457.cut5lvk5kkip.us-east-2.rds.amazonaws.com:3306/DatabaseSquad457";
    public static void main(String[] args) {


        
    }
    

    //
    
   public static void createOrder(int Num,int total, int cheeseBurger, int salad, int Cheesesteak, int pizza, int spaghetti, int vanillaMilk, int coke, int lemonade,
   int chocolateMilk, int beer){
        Connection conn = null;
        //int flag = 0;
       try{
            conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);

            System.out.println("Connected!");
            Statement stmt = (Statement) conn.createStatement();

            String insert = "INSERT INTO Transactions " + "Values ('" + Num + "','" + total + "','" + cheeseBurger  + "','" + salad  + "','" + Cheesesteak  + "','" + pizza  + "','" + spaghetti
             + "','" + vanillaMilk + "','" + coke + "','" + lemonade + "','" + chocolateMilk + "','" + beer + "')";
            //flag = 1;
            stmt.executeUpdate(insert);
            //return flag;
        }catch (SQLException e){
            System.err.println(e);
        }
       //return 0;
   }
}
