
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.scene.control.Alert;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sourav
 */
public class CRAuthentication {
    
     public boolean validLogin(String name, String pwd){
   
         
         try{
             Connection con = DBConnection.getConnection();
             PreparedStatement pst=con.prepareStatement("select * from crs where name= ? and password = ?");
             
             pst.setString(1, name);
             pst.setString(2, pwd);
             
            ResultSet rs= pst.executeQuery();
  
            if(rs.next()){
                Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Message");
                alert.setContentText("Sign In Successful");
                alert.setHeaderText("Hello "+name);
                alert.showAndWait();
                return true;
            }
            else{
                Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Message");
                alert.setContentText("!!! Incorrect username or password !!!");
                alert.setHeaderText("Error");
                alert.showAndWait();
                return false;
            }
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return false;
    
      }
   
    
}


