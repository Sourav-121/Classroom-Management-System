/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.sql.Connection;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sourav
 */
public class HistoryController implements Initializable {

    @FXML
    private Button backbtn;
    @FXML
    private TextField roomtxt;
    @FXML
    private Button searchbtn;
    @FXML
    private Button releasebtn;
    @FXML
    private TableView<roomdetails> roomtable;
    @FXML
    private TableColumn<roomdetails, String> roomnumber;
    @FXML
    private TableColumn<roomdetails, String> coursecode;
    @FXML
    private TableColumn<roomdetails, String> datecol;
    @FXML
    private TableColumn<roomdetails, String> starttime;
    @FXML
    private TableColumn<roomdetails, String> endtime;
    @FXML
    private TableColumn<roomdetails, String> statuscol;
    
   
   
    
//    roomdetails room=null;
    
    ObservableList<roomdetails> RoomList=FXCollections.observableArrayList();
    @FXML
    private Button refreshbtn;
    @FXML
    private Text usertxt;
  
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
//        setting username
                 usertxt.setText(User.getUserName());

         
         
          roomnumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        coursecode.setCellValueFactory(new PropertyValueFactory<>("courseCode"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        starttime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endtime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));
        getroomdetails();
        
        
         roomtable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                roomtxt.setText(String.valueOf(newValue.getRoomNumber()));
            }
        });
    }    

    @FXML
    private void backbtnaction(ActionEvent event) {
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("CRHomePage.fxml"));
            Scene scene=new Scene(loader.load());
            
//             String userName=usertxt.getText();
//            CRHomePageController s=loader.getController();
//            s.display(userName);
            
            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
        
    }
    }

    @FXML
    private void searchbtnaction(ActionEvent event) {
          String name=usertxt.getText();
         int rn=Integer.parseInt(roomtxt.getText());
         
         try{
             RoomList.clear();
             Connection c=DBConnection.getConnection();
             String sql="select * from room where room_number=? and cr=?";
             
             PreparedStatement p=c.prepareStatement(sql);
             p.setInt(1,rn );
             p.setString(2, name);
            ResultSet rs=p.executeQuery();
            
            while(rs.next()){
                RoomList.add(new roomdetails(rs.getInt("room_number"),
                        rs.getString("course_code"),rs.getDate("date"),
                        rs.getString("start_time"),rs.getString("end_time"),
                        rs.getString("status")));
                roomtable.setItems(RoomList);
            }
             
             
             
         }catch(Exception e){
             e.printStackTrace();
         }
       
     }


    @FXML
    private void releasebtnaction(ActionEvent event) {
        releaseRoom();
    }
    
//    delete room
    
     private void releaseRoom() {
        String roomn=roomtxt.getText();
        String name = usertxt.getText();
        
        if ( name.isEmpty() || roomn.isEmpty()) {
            Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Message");
                alert.setContentText("Please enter a valid room number");
                alert.setHeaderText("Try again!!!");
                alert.showAndWait();
            return;
        }
        int rn=Integer.parseInt(roomn);
        
       try{
           Connection con=DBConnection.getConnection();
            String sql = "DELETE FROM room WHERE room_number = ? AND cr = ?";
            PreparedStatement statement = con.prepareStatement(sql);
                statement.setInt(1,rn );
                statement.setString(2, name);
                
                int rowsDeleted = statement.executeUpdate();
                
                if (rowsDeleted > 0) {
                    
                    Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Message");
                alert.setContentText("Classroom released successfully");
                alert.setHeaderText("Released");
                alert.showAndWait();
                
                RefreshPage();
                
                } else {
                    Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Message");
                alert.setContentText("Classroom released is unsuccessful");
                alert.setHeaderText("Try again!!!");
                alert.showAndWait();
                }
       }catch(Exception e){
           e.printStackTrace();
       }
      
    }
    
      public void RefreshPage(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("History.fxml"));
            Scene scene=new Scene(loader.load());
            
             String userName=usertxt.getText();
            HistoryController s=loader.getController();
            s.display(userName);
            
            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
        
    }
      }
    
     private void getroomdetails(){
         String name=usertxt.getText();
         
         try{
             RoomList.clear();
             Connection c=DBConnection.getConnection();
             String sql="select * from room where cr=?";
             
             PreparedStatement p=c.prepareStatement(sql);
             p.setString(1, name);
            ResultSet rs=p.executeQuery();
            
            while(rs.next()){
                RoomList.add(new roomdetails(rs.getInt("room_number"),
                        rs.getString("course_code"),rs.getDate("date"),
                        rs.getString("start_time"),rs.getString("end_time"),
                        rs.getString("status")));
                roomtable.setItems(RoomList);
            }
             
             
             
         }catch(Exception e){
             e.printStackTrace();
         }
       
     }
     
     public void display(String username){
         usertxt.setText(username);
     }

    @FXML
    private void refreshbtnaction(ActionEvent event) {
        RefreshPage();
    }
    
}
