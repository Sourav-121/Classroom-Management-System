
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Sourav
 */
public class roomdetails {
    int roomNumber;
    String courseCode,startTime,endTime,status;
    Date date;

    public roomdetails(int roomNumber, String courseCode,  Date date,String startTime, String endTime, String status) {
        this.roomNumber = roomNumber;
        this.courseCode = courseCode;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getCourseCode() {
        return courseCode;
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

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(Date date) {
        this.date = date;
    }
   
    
    
}
