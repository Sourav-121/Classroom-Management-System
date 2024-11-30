

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sourav
 */
public class CRSigninController implements Initializable {

    @FXML
    private Pane loginPane;
    @FXML
    private Button loginbtn;
    @FXML
    private TextField usertext;
    @FXML
    private PasswordField passtext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void nextPage(){
        try{
            FXMLLoader loader=new FXMLLoader(getClass().getResource("CRHomePage.fxml"));
            Scene scene=new Scene(loader.load());
            
         String username=usertext.getText();
        
//        CRHomePageController s=loader.getController();
//        s.display(username);

             CRHomePageController c=loader.getController();
        
            c.setUser(username);
            User.setUserName(username);

            Stage cs=CurrentStage.getCurrentStage();
            cs.setScene(scene);
            cs.show();
        }catch(Exception e){
        
    }
    
}

    @FXML
    private void signInbtn(ActionEvent event) {
       String name=usertext.getText();
       String password=passtext.getText();
       
       CRAuthentication c=new CRAuthentication();
       if(c.validLogin(name, password)){
           nextPage();
       }
    }
    }
