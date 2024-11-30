
import javafx.stage.Stage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sourav
 */
public class CurrentStage {
    private static Stage currentStage;
    
    public static void setCurrentStage(Stage stage){
        currentStage=stage;
    }
    
    public static Stage getCurrentStage(){
        return currentStage;
    }
    
}
