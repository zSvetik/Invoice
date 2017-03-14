package com.softgroup.kuznietsov.services;

import com.softgroup.kuznietsov.api.RoomInfo;
import com.softgroup.kuznietsov.jpa.Invoice;
import com.softgroup.kuznietsov.jpa.Room;
import com.softgroup.kuznietsov.jpa.User;
import com.softgroup.kuznietsov.repository.RoomRepository;
import com.softgroup.kuznietsov.utils.EntityIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by User on 08.03.2017.
 */
@Component
public class RoomMapper {

    public static final Logger logger = LoggerFactory.getLogger(RoomMapper.class);

    public static final Long ROOM_ID = 1L;
    @Autowired
    RoomRepository roomRepository;

    /**
     * Maps internal JPA model to external REST model
     * @param room innternal room model
     * @return external REST room model
     */
    public RoomInfo fromInternal(Room room) {
        RoomInfo roomInfo = null;
        if (room != null) {
            roomInfo = new RoomInfo();
            roomInfo.id = room.getId();
            roomInfo.owner = room.getOwner();
            roomInfo.guests = room.getGuests();
            roomInfo.area = room.getArea();
        }
        return roomInfo;
    }
    /**
     * Creates new Room with good Id
     * @return newly created Room with required fields set
     */
    private Room newRoom() {
        //TODO: get logged userInfo from security context
        String createdBy = "REST";
        Room room = new Room();
        boolean idOK = false;
        Long id = 0L;
        while (!idOK) {
            id = EntityIdGenerator.random();
            idOK = !roomRepository.exists(id);
        }
        room.setId(id);
        room.setOwner("unknownOwner");
        room.setGuests(1);
        room.setArea(1);
        return room;
    }

    /**
     * Maps extrernal REST model to internal Room;
     * If room does not exists in DB then creates new. If room already exists
     * then fetches room from DB and sets all fields from external REST model
     * @param roomInfo REST model
     * @return internal Room with all required fields set
     */
    public Room toInternal(RoomInfo roomInfo) {
        Room room = null;
        //first, check if it exists
        if (roomInfo.id != null) {
            room = roomRepository.findOne(roomInfo.id);
        }
        if (room == null) { //not found, create new
            logger.debug("Creating new room");
            room = newRoom();
        }
        logger.debug("Updating existing room");
        room.setOwner(roomInfo.owner);
        room.setGuests(roomInfo.guests);
        room.setArea(room.getArea());
        return room;
    }
}
