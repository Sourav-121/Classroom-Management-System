
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sourav
 */
public class crroom {
    int roomNumber;
    String startTime,endTime,status,crColumn;
    Date date;

    public crroom(int roomNumber,  Date date,String startTime, String endTime, String status,String crColumn ) {
        this.roomNumber = roomNumber;
        
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.crColumn= crColumn;
        
    }

    public String getCrColumn() {
        return crColumn;
    }
    
  

    public int getRoomNumber() {
        return roomNumber;
    }

    

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }


 
   
    
    
}
