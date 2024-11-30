
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sourav
 */
public class Start extends Application {
    
    public static void main(String[]args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader=new FXMLLoader();
        Parent root=FXMLLoader.load(getClass().getResource("CRSignin.fxml"));
        Stage stage=new Stage();
        Scene scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        CurrentStage.setCurrentStage(stage);
       
                
    }
    
    
}
