/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */



import java.sql.Statement;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sourav
 */
public class CRHomePageController implements Initializable {

    @FXML
    private Pane card1;
    @FXML
    private Pane card2;
    @FXML
    private Pane card3;
    @FXML
    private Button crsearch;
    @FXML
    private Button chooseBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button releasebtn;
    @FXML
    private Button refreshbtn;
    @FXML
    private TableView<crroom> roomtable;
    @FXML
    private TableColumn<crroom, String> roomnumber;
    @FXML
    private TableColumn<crroom, String> statuscol;
    @FXML
    private TableColumn<crroom, String> starttime;
    @FXML
    private TableColumn<crroom, String> endtime;
    @FXML
    private TableColumn<crroom, String> datecol;
    @FXML
    private DatePicker datetxt;
    
    
    
    
    private List<Integer> v1 = new ArrayList<>(Arrays.asList(101, 102, 103, 104, 105, 109, 110,134,135,136,137,141,142, 143,
            201, 202, 203, 204, 205, 210,234,235,236,237,241,243,
            301, 302, 303, 304, 305, 309, 310,335,336,337,341,342, 343,
            401, 402, 403, 405, 409, 410,434,436,437,441,442, 443,
            501, 502, 503, 504, 505, 510,534,535,536,537,541,542, 543));
    private List<Integer> v2 = new ArrayList<>();

 ObservableList<crroom> RoomList=FXCollections.observableArrayList();

 
  private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
    @FXML
    private Text bookednum;
    @FXML
    private Text freetxt;
    @FXML
    private Text examtxt;
    @FXML
    private Text usertxt;
    @FXML
    private TableColumn<crroom, String> crColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         usertxt.setText(User.getUserName());
         deleteOldRoom();
        setCardNumbers();
        
                         roomnumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
        datecol.setCellValueFactory(new PropertyValueFactory<>("date"));
        starttime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        endtime.setCellValueFactory(new PropertyValueFactory<>("endTime"));
        statuscol.setCellValueFactory(new PropertyValueFactory<>("status"));
        crColumn.setCellValueFactory(new PropertyValueFactory<>("crColumn"));
                 
        
    }   
    
    
     public void setUser(String name){

        usertxt.setText(name);   
    }
    

    
     private void deleteOldRoom() {
  
        
        LocalDate todaysdate=LocalDate.now();
        
       try{
           Connection con=DBConnection.getConnection();
            String sql = "DELETE FROM room WHERE date<?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(todaysdate));
     
                
                int rowsDeleted = statement.executeUpdate();
                
       }catch(Exception e){
           e.printStackTrace();
       }
      
    }


    @FXML
    private void choosebtnaction(ActionEvent event) {
           
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ChooseClass.fxml"));
            Scene scene=new Scene(loader.load());
            
//            setting username
//            String username=usertxt.getText();
//            ChooseClassController s=loader.getController();
//            s.display(username);
            
            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
            e.printStackTrace();
}
    }

    @FXML
    private void releasebtnaction(ActionEvent event) {
         try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("History.fxml"));
            Scene scene=new Scene(loader.load());
            
            //            setting username
//            String username=usertxt.getText();
//            HistoryController s=loader.getController();
//            s.display(username);
            
            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
            e.printStackTrace();
}
        
    }

    @FXML
    private void refreshbtnaction(ActionEvent event) {
         try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("CRHomePage.fxml"));
            Scene scene=new Scene(loader.load());
            
            
            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
            e.printStackTrace();
}
    }

 

    @FXML
    private void logoutbtnaction(ActionEvent event) {
         try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("CRSignin.fxml"));
            Scene scene=new Scene(loader.load());
            
            
            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
            e.printStackTrace();
}
    }
    
     private void getroomdetails(){
         
         
         LocalDate ClassDate=datetxt.getValue();
         java.sql.Date classD=java.sql.Date.valueOf(ClassDate);
         
         
         
//         try{
             
             
         try{
             Connection c=DBConnection.getConnection();
             String sql="select * from room where date=?";
             
             PreparedStatement p=c.prepareStatement(sql);
             p.setDate(1, classD);
            ResultSet rs=p.executeQuery();
               RoomList.clear();
            while(rs.next()){
                  
//                Adding rooms in a list
                int room=rs.getInt("room_number");
              
                 if (v1.contains(room) && !v2.contains(room)) {
                v2.add(room);
     }
                 
               
                String Start=rs.getString("start_time");
                String End=rs.getString("end_time");
                
                LocalTime STime=LocalTime.parse(Start, formatter);
               LocalTime ETime=LocalTime.parse(End, formatter);
               
                    
                       RoomList.add(new crroom(rs.getInt("room_number"),rs.getDate("date"),
                        rs.getString("start_time"),rs.getString("end_time"),
                        rs.getString("status"),rs.getString("cr")));
                      roomtable.setItems(RoomList);
            }
         }
         catch(Exception e){
             e.printStackTrace();
         }
                   
                   
              
     }
     
     
     
     
     private void getFullAvailableRooms(){
         
        LocalDate ClassDate=datetxt.getValue();
         java.sql.Date classDate=java.sql.Date.valueOf(ClassDate);
         
         try{
             
             
//             if(v2.isEmpty()){
//              for (int roomNumber : v1) {
//   
//              RoomList.add(new crroom(roomNumber,classDate,"","","free"));
//     
//        }    
//             }else{
                  for (int roomNumber : v1) {
            if (!v2.contains(roomNumber)) {
              RoomList.add(new crroom(roomNumber,classDate,"","","free",""));
            }
        }
//             }
             
       
                           
        roomtable.setItems(RoomList);
                
                
         }catch(Exception e){
             e.printStackTrace();
         }
       
     }


    @FXML
    private void searchBtnaction(ActionEvent event) {
        
        if( datetxt.getValue().toString().equals("")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Message");
                alert.setContentText("Enter valid time and date");
                alert.setHeaderText("Wrong search!!!");
                alert.showAndWait();
                
        }
        else{

        getroomdetails();
       getFullAvailableRooms();
        }
    }
    
//    setcardNumbers
    
    public void setCardNumbers(){
        Statement s=null;
       ResultSet r=null;
        
        try{
      Connection con=DBConnection.getConnection();
        s=con.createStatement();
        r=s.executeQuery("select room_number from room where status='booked' GROUP BY room_number");
        int n=0;
        int count=0;
        while(r.next()){
            n++;
        }
        
        bookednum.setText(Integer.toString(n));
        
//       for exam card

         r=s.executeQuery("select room_number from room where status='exam' GROUP BY room_number");
        int m=0;
        
        while(r.next()){
            m++;
        }
        
        examtxt.setText(Integer.toString(m));
//        free classroom label

        count=n+m;
        int result=64-count;
        freetxt.setText(Integer.toString(result));
        
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
