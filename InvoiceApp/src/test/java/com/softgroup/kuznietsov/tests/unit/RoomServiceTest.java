package com.softgroup.kuznietsov.tests.unit;

import com.softgroup.kuznietsov.jpa.Room;
import com.softgroup.kuznietsov.services.RoomService;
import com.softgroup.kuznietsov.utils.EntityIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by User on 08.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoomServiceTest {
    @Autowired
    private RoomService roomService;

    @Test
    public void findRoomTest() throws Exception {
        int count = roomService.getAllRooms().size();
        assert(count > 4);
    }

    @Test
    public void addRoomTest(){
        Long room_id = EntityIdGenerator.random();
        Room room = new Room();
        room.setId(room_id);
        room.setOwner("owner");
        room.setGuests(1);
        room.setArea(1);
        roomService.addRoom(room);
        Room roomForAssert = roomService.getRoomById(room_id);
        assertNotNull("New room not found!", roomForAssert);
        roomService.delRoom(room_id);
        roomForAssert = roomService.getRoomById(room_id);
        assertNull("Can not delete room!", roomForAssert);
    }
}
