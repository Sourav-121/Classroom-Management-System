/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author Sourav
 */
public class ChooseClassController implements Initializable {

    @FXML
    private Button backbtn;
    @FXML
    private TextField roomtxt;
    @FXML
    private TextField coursetxt;
    @FXML
    private DatePicker datetxt;
    @FXML
    private TextField starttxt;
    @FXML
    private TextField stoptxt;
    @FXML
    private Button bookbtn;
    @FXML
    private CheckBox examcheck;
    @FXML
    private Text usertxt;
    
    private String dstyle;
    @FXML
    private Button button101;
    @FXML
    private Button btn102;
    @FXML
    private Button btn103;
    @FXML
    private Button btn104;
    @FXML
    private Button btn105;
    @FXML
    private Button btn109;
    @FXML
    private Button btn110;
    @FXML
    private Button btn134;
    @FXML
    private Button btn135;
    @FXML
    private Button btn136;
    @FXML
    private Button btn137;
     @FXML
    private Button btn141;
      @FXML
    private Button btn142;
        @FXML
    private Button btn143;
    @FXML
    private Button btn201;
    @FXML
    private Button btn202;
    @FXML
    private Button btn203;
    @FXML
    private Button btn204;
    @FXML
    private Button btn205;
   
    @FXML
    private Button btn210;
    @FXML
    private Button btn234;
    @FXML
    private Button btn235;
    @FXML
    private Button btn236;
    @FXML
    private Button btn237;
     @FXML
    private Button btn241;
      @FXML
    private Button btn243;
    @FXML
    private Button btn301;
    @FXML
    private Button btn302;
    @FXML
    private Button btn303;
    @FXML
    private Button btn304;
    @FXML
    private Button btn305;
    @FXML
    private Button btn309;
    @FXML
    private Button btn310;
   
    @FXML
    private Button btn335;
    @FXML
    private Button btn336;
    @FXML
    private Button btn337;
     @FXML
    private Button btn341;
      @FXML
    private Button btn342;
       @FXML
    private Button btn343;
    @FXML
    private Button btn401;
    @FXML
    private Button btn402;
    @FXML
    private Button btn403;
    private Button btn404;
    @FXML
    private Button btn405;
    @FXML
    private Button btn409;
    @FXML
    private Button btn410;
    @FXML
    private Button btn434;
   
    @FXML
    private Button btn436;
    @FXML
    private Button btn437;
     @FXML
    private Button btn441;
      @FXML
    private Button btn442;
       @FXML
    private Button btn443;
    @FXML
    private Button btn501;
    @FXML
    private Button btn502;
    @FXML
    private Button btn503;
    @FXML
    private Button btn504;
    @FXML
    private Button btn505;
  
    @FXML
    private Button btn510;
    @FXML
    private Button btn534;
    @FXML
    private Button btn535;
    @FXML
    private Button bnt536;
    @FXML
    private Button btn537;
     @FXML
    private Button btn541;
     @FXML
     private Button btn542;
      @FXML
      private Button btn543;
    @FXML
    private Button refreshbtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
                  usertxt.setText(User.getUserName());

        
        dstyle=backbtn.getStyle();
        colorBooked();
        colorExam();
        // TODO
    }  
//    setting user
      void display(String username){
        usertxt.setText(username);
    }
      
      
//      Check date
      
      public boolean checkDate() {
      LocalDate ClassDate=datetxt.getValue(); 
      
   
      LocalDate today = LocalDate.now(); 
      if (ClassDate.isAfter(today.plusDays(1))) {
           Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Message");
                alert.setHeaderText("You can choose room only before one day!!!!");
                alert.showAndWait();
          return false;
      }
      else { 
          
             
          return true;
      }
              
    }
      
      
//  check time



    public boolean checkTime() {
        
                 
        String firstTimeString = starttxt.getText();
        String secondTimeString = stoptxt.getText();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        try {
            LocalTime firstTime = LocalTime.parse(firstTimeString, formatter);
            LocalTime secondTime = LocalTime.parse(secondTimeString, formatter);

            Duration duration = Duration.between(firstTime, secondTime);

          long minutesDifference = java.time.Duration.between(firstTime,secondTime).toMinutes(); 
          long absDifference =Math.abs(minutesDifference);
          System.out.println(absDifference);
          if (absDifference <=120){
              return true;
          }
         
        } catch (Exception e) {
           e.printStackTrace();
        }
        
                 Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Message");
            
                alert.setHeaderText("You can not occupy a room more than two hours!!!!");
                alert.showAndWait();
        return false;
   }


      
    
    
    
//    checking and setting color for booked
    public void colorBooked(){
      
        boolean result=false;
        try{
            
            Connection c=DBConnection.getConnection();
            String cmd="SELECT * FROM room WHERE status = 'booked'";
            PreparedStatement p=c.prepareStatement(cmd);
           
            ResultSet rst=p.executeQuery();
            
            while(rst.next()){
                int rn=rst.getInt("room_number");
                getButtonByNumber(rn).setStyle("-fx-background-color:#FFEE58");
               
  
                result=true;
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    
//    checking and setting button red for exam
    
     public void colorExam(){
      
        boolean result=false;
        try{
            
            Connection c=DBConnection.getConnection();
            String cmd="SELECT * FROM room WHERE status = 'exam'";
            PreparedStatement p=c.prepareStatement(cmd);
           
            ResultSet rst=p.executeQuery();
            
            while(rst.next()){
                int rn=rst.getInt("room_number");
                getButtonByNumber(rn).setStyle("-fx-background-color:#FF3E4D");
               
  
                result=true;
                
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
//check same cr
     public boolean checkCR(){
         int room=Integer.parseInt(roomtxt.getText());
         String cr=usertxt.getText();
        
       
         try{
             Connection con = DBConnection.getConnection();
             PreparedStatement pst=con.prepareStatement("select * from room where room_number= ? and cr = ?");
             
             pst.setInt(1, room);
             pst.setString(2, cr);
             
            ResultSet rs= pst.executeQuery();
           
  
            if(rs.next()){
                  Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Message");
            
                alert.setHeaderText("A room cannot be booked more than once!!!!");
                alert.showAndWait();
                return false;
            }
   
       }catch(Exception e){
           e.printStackTrace();
       }
         
       
         return true;
   }
    
//    booking classroom
    public boolean bookRoom(){
         int RoomNumber=Integer.parseInt(roomtxt.getText());
         String CourseCode=coursetxt.getText();
         
        
         
         LocalDate ClassDate=datetxt.getValue();
         java.sql.Date classDate=java.sql.Date.valueOf(ClassDate);
         
         String StartTime=starttxt.getText();
         String EndTime=stoptxt.getText();
         
         
         boolean isAdded=false;
         
         if(checkDate()){
             if(checkTime()){
                if(checkCR()){
                     try{
             Connection c=DBConnection.getConnection();
             String sql="insert into room ( room_number, course_code,date, start_time, end_time, cr, status) values(?,?,?,?,?,?,?)";
             
             PreparedStatement p=c.prepareStatement(sql);
            
            p.setInt(1, RoomNumber);
            p.setString(2, CourseCode);
            p.setDate(3, classDate);
            p.setString(4, StartTime);
            p.setString(5, EndTime);
            p.setString(6, usertxt.getText());
            if(examcheck.isSelected()){
                p.setString(7, "exam");
            }else{
                p.setString(7,"booked");
            }
             
             int count=p.executeUpdate();
             
             isAdded = count>0;
             
//             getButtonByNumber(RoomNumber).setStyle("-fx-background-color: ");
             
             
         }catch(Exception e){
             e.printStackTrace();
         }
                }
             }
         }
         
         return isAdded;
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
    private void bookbtnaction(ActionEvent event) {
        if(bookRoom()==true){
             Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Message");
                alert.setContentText("Class room booked successfully...");
                alert.setHeaderText("Booking Information");
                alert.showAndWait();
                 refreshFunction();
        }else{
            
             Alert alert=new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Message");
                alert.setContentText("Try again");
                alert.setHeaderText("Booking unsuccessful");
                alert.showAndWait();
            
        }
        
    }
    
    private Button getButtonByNumber(int number){
        switch(number){
            case 101: return button101;
            case 102: return btn102;
            case 103: return btn103;
            case 104: return btn104;
            case 105: return btn105;
            case 109: return btn109;
            case 110: return btn110;
            case 134: return btn134;
            case 135: return btn135;
            case 136: return btn136;
            case 137: return btn137;
            case 141: return btn141;
            case 142: return btn142;
            case 143: return btn143;
            
            case 201: return btn201;
            case 202: return btn202;
            case 203: return btn203;
            case 204: return btn204;
            case 205: return btn205;
            case 210: return btn210;
            case 234: return btn234;
            case 235: return btn235;
            case 236: return btn236;
            case 237: return btn237;
            case 241: return btn241;
            case 243: return btn243;
            
             
            case 301: return btn301;
            case 302: return btn302;
            case 303: return btn303;
            case 304: return btn304;
            case 305: return btn305;
            case 309: return btn309;
            case 310: return btn310;
            case 335: return btn335;
            case 336: return btn336;
            case 337: return btn337;
            case 341: return btn341;
            case 342: return btn342;
            case 343: return btn343;
            
             
            case 401: return btn401;
            case 402: return btn402;
            case 403: return btn403;
            case 404: return btn404;
            case 405: return btn405;
            case 409: return btn409;
            case 410: return btn410;
            case 434: return btn434;
            case 436: return btn436;
            case 437: return btn437;
            case 441: return btn441;
            case 442: return btn442;
            case 443: return btn443;
            
             
            case 501: return btn501;
            case 502: return btn502;
            case 503: return btn503;
            case 504: return btn504;
            case 505: return btn505;
            case 510: return btn510;
            case 534: return btn534;
            case 535: return btn535;
            case 536: return bnt536;
            case 537: return btn537;
            case 541: return btn541;
            case 542: return btn542;
            case 543: return btn543;
            
            default: return null;
        }
    }
    

    @FXML
    private void btn101action(ActionEvent event) {
        
//        button101.setStyle("-fx-background-color: #74B9FF");
        roomtxt.setText("101");
        
    }

    @FXML
    private void btn102action(ActionEvent event) {
        roomtxt.setText("102");
    }

    @FXML
    private void btn103action(ActionEvent event) {
        roomtxt.setText("103");
    }

    @FXML
    private void btn104action(ActionEvent event) {
        roomtxt.setText("104");
    }

    @FXML
    private void btn105action(ActionEvent event) {
        roomtxt.setText("105");
    }

    @FXML
    private void btn109action(ActionEvent event) {
        roomtxt.setText("109");
    }

    @FXML
    private void btn110action(ActionEvent event) {
        roomtxt.setText("110");
    }

    @FXML
    private void btn134action(ActionEvent event) {
        roomtxt.setText("134");
    }

    @FXML
    private void btn135action(ActionEvent event) {
        roomtxt.setText("135");
    }

    @FXML
    private void btn136action(ActionEvent event) {
        roomtxt.setText("136");
    }

    @FXML
    private void btn137action(ActionEvent event) {
        roomtxt.setText("137");
    }
 @FXML
    private void btn141aciton(ActionEvent event) {
        roomtxt.setText("141");
    }
 @FXML
    private void btn142aciton(ActionEvent event) {
        roomtxt.setText("142");
    }
    @FXML
    private void btn143aciton(ActionEvent event) {
        roomtxt.setText("143");
    }
    
    
    
    

    @FXML
    private void btn201action(ActionEvent event) {
        roomtxt.setText("201");
    }

    @FXML
    private void btn202action(ActionEvent event) {
        roomtxt.setText("202");
    }

    @FXML
    private void btn203action(ActionEvent event) {
        roomtxt.setText("203");
    }

    @FXML
    private void btn204action(ActionEvent event) {
        roomtxt.setText("204");
    }

    @FXML
    private void btn205action(ActionEvent event) {
        roomtxt.setText("205");
    }

 
    @FXML
    private void btn210action(ActionEvent event) {
        roomtxt.setText("210");
    }

    @FXML
    private void btn234aciton(ActionEvent event) {
        roomtxt.setText("234");
    }

    @FXML
    private void btn235action(ActionEvent event) {
        roomtxt.setText("235");
    }

    @FXML
    private void btn236action(ActionEvent event) {
        roomtxt.setText("236");
    }

    @FXML
    private void btn237action(ActionEvent event) {
       
        roomtxt.setText("237");
    }
 @FXML
    private void btn241aciton(ActionEvent event) {
        roomtxt.setText("241");
    }
 @FXML
    private void btn243action(ActionEvent event) {
        roomtxt.setText("243");
    }
    
    
    
    
    

    @FXML
    private void btn301aciton(ActionEvent event) {
        roomtxt.setText("301");
    }

    @FXML
    private void btn302aciton(ActionEvent event) {
    roomtxt.setText("302");
    }

    @FXML
    private void btn303action(ActionEvent event) {
        roomtxt.setText("303");
    }

    @FXML
    private void btn304action(ActionEvent event) {
        roomtxt.setText("304");
    }

    @FXML
    private void btn305action(ActionEvent event) {
        roomtxt.setText("305");
    }

    @FXML
    private void btn309action(ActionEvent event) {
        roomtxt.setText("309");
    }

    @FXML
    private void btn310action(ActionEvent event) {
        roomtxt.setText("310");
    }


    @FXML
    private void btn335action(ActionEvent event) {
        roomtxt.setText("335");
    }

    @FXML
    private void btn336action(ActionEvent event) {
        roomtxt.setText("336");
    }

    @FXML
    private void btn337action(ActionEvent event) {
        roomtxt.setText("337");
    }
 @FXML
    private void btn341action(ActionEvent event) {
        roomtxt.setText("341");
    }
 @FXML
    private void btn342action(ActionEvent event) {
        roomtxt.setText("342");
    }
     @FXML
 private void btn343action(ActionEvent event) {
        roomtxt.setText("343");
    }
 
 
 
 
    @FXML
    private void btn401aciton(ActionEvent event) {
        roomtxt.setText("401");
    }

    @FXML
    private void btn402action(ActionEvent event) {
        roomtxt.setText("402");
    }

    @FXML
    private void btn403action(ActionEvent event) {
        roomtxt.setText("403");
    }

    @FXML
    private void btn405action(ActionEvent event) {
        roomtxt.setText("405");
    }

    @FXML
    private void btn409action(ActionEvent event) {
        roomtxt.setText("409");
    }

    @FXML
    private void btn410action(ActionEvent event) {
        roomtxt.setText("410");
    }

    @FXML
    private void btn434action(ActionEvent event) {
        roomtxt.setText("434");
    }

    @FXML
    private void btn436aciton(ActionEvent event) {
        roomtxt.setText("436");
    }

    @FXML
    private void btn437action(ActionEvent event) {
        roomtxt.setText("437");
    }
@FXML
    private void btn441action(ActionEvent event) {
        roomtxt.setText("441");
    }
@FXML
    private void btn442action(ActionEvent event) {
        roomtxt.setText("442");
    }
    @FXML
    private void btn443action(ActionEvent event) {
        roomtxt.setText("443");
    }
    
    

    @FXML
    private void btn501action(ActionEvent event) {
        roomtxt.setText("501");
    }

    @FXML
    private void btn502action(ActionEvent event) {
    roomtxt.setText("502");
    }

    @FXML
    private void btn503action(ActionEvent event) {
        roomtxt.setText("503");
    }

    @FXML
    private void btn504action(ActionEvent event) {
    roomtxt.setText("504");
    }

    @FXML
    private void btn505action(ActionEvent event) {
    roomtxt.setText("505");
    }

    @FXML
    private void btn510aciton(ActionEvent event) {
    roomtxt.setText("510");
    }

    @FXML
    private void btn534action(ActionEvent event) {
    roomtxt.setText("534");
    }

    @FXML
    private void btn535action(ActionEvent event) {
    roomtxt.setText("535");
    }

    @FXML
    private void btn536action(ActionEvent event) {
    roomtxt.setText("536");
    }

    @FXML
    private void btn537action(ActionEvent event) {
    roomtxt.setText("537");
    }
  @FXML
    private void btn541action(ActionEvent event) {
    roomtxt.setText("541");
    }
  @FXML
    private void btn542action(ActionEvent event) {
    roomtxt.setText("542");
    }
     @FXML
    private void btn543action(ActionEvent event) {
    roomtxt.setText("543");
    }
    
    public void refreshFunction(){
            try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ChooseClass.fxml"));
            Scene scene=new Scene(loader.load());
              
            
            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
            e.printStackTrace();
}
    }

    @FXML
    private void refreshbtnaction(ActionEvent event) {
    refreshFunction();
    }

   
    
}
