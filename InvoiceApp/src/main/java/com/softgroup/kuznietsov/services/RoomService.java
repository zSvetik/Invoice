package com.softgroup.kuznietsov.services;

import com.softgroup.kuznietsov.jpa.Invoice;
import com.softgroup.kuznietsov.jpa.Room;
import com.softgroup.kuznietsov.jpa.User;
import com.softgroup.kuznietsov.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 08.03.2017.
 */
@Service
public class RoomService {

    public static final Logger logger = LoggerFactory.getLogger(RoomService.class);

    @Autowired
    RoomRepository roomRepository;

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Room getRoomById(Long id) {
        return roomRepository.findOne(id);
    }

    public Room addRoom(Room room) {
        logger.debug("Adding room with id %s", room.getId());
        return roomRepository.save(room);
    }

    public void delRoom(Long id){
        Room room = roomRepository.findOne(id);
        if(room != null){
            logger.debug("Deleting room with id %s", room.getId());/*
            List<Invoice> invoiceList = room.getInvoiceList();
                invoiceList.clear();
            List<User> userList = room.getUserList();
                userList.clear();*/
            roomRepository.delete(id);
        }
    }

    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }
}
