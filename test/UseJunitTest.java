/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Controller.Connect;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Controller.RoomDAO;
import Model.Room;
import junit.framework.Assert;

/**
 *
 * @author Dark Slayer
 */
public class UseJunitTest {
    
    public UseJunitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetRoomById() {
        RoomDAO roomDAO = new RoomDAO();
        Room room = roomDAO.get_information_room_by_id(1);
        Assert.assertNotNull(room);
    }
    @Test
    public void testAddRoom() {
        try {
            Connect.getConnect().setAutoCommit(false);
        } catch (Exception e) {
        } finally {
            try {
                Connect.getConnect().rollback();
                Connect.getConnect().setAutoCommit(true);
            } catch (Exception e) {
            }   
        }
        RoomDAO roomDAO = new RoomDAO();
        Room room = new Room("Phòng 504", 1, 4000);
        roomDAO.addRoom(room);
        Room getRoom = roomDAO.get_information_room_by_id(room.getId());
        Assert.assertNotNull(getRoom);
        Assert.assertTrue(getRoom.getId() > 4);
        Assert.assertEquals(room, getRoom);
    }
}
