/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Dark Slayer
 */
public class Booking {
    private int id;
    private int roomId;
    private int clientId;
    private Date timeStart;
    private Date timeEnd;
    private Date day;

    public Booking() {
    }

    public Booking(int roomId, int clientId) {
        this.roomId = roomId;
        this.clientId = clientId;
    }
    
    public Booking(int id, int clientId, int roomId,  Date timeStart, Date timeEnd, Date day) {
        this.id = id;
        this.roomId = roomId;
        this.clientId = clientId;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.day = day;
    }

    

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    
    
    
}
