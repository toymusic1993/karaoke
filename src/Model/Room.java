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
public class Room {
    private int id;
    private String name;
    private int type;
    private int price;
    private int status;

    public Room() {
    }

    public Room(String name, int type, int price, int status) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.status = status;
    }

    public Room(String name, int type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    

    

    
}
