/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Dark Slayer
 */
public class UserServices {
    private int id;
    private int price;
    private int number;
    private int bookingId;
    private int servicesId;

    public UserServices() {
    }

    public UserServices(int id, int price, int number, int bookingId, int servicesId) {
        this.id = id;
        this.price = price;
        this.number = number;
        this.bookingId = bookingId;
        this.servicesId = servicesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getServicesId() {
        return servicesId;
    }

    public void setServicesId(int servicesId) {
        this.servicesId = servicesId;
    }
    
    
}
