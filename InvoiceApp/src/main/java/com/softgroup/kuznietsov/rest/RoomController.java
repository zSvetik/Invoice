package com.softgroup.kuznietsov.rest;

import com.softgroup.kuznietsov.api.AddRoomRequest;
import com.softgroup.kuznietsov.api.GenericReply;
import com.softgroup.kuznietsov.api.RoomListReply;
import com.softgroup.kuznietsov.jpa.Room;
import com.softgroup.kuznietsov.services.RoomMapper;
import com.softgroup.kuznietsov.services.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by User on 08.03.2017.
 */
@RestController
public class RoomController {
    public static final Logger logger = LoggerFactory.getLogger(RoomController.class);

    @Autowired
    RoomService roomService;
    @Autowired
    RoomMapper roomMapper;

    @RequestMapping(path="/room/all",  method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RoomListReply getAllRooms(){
        RoomListReply roomListReply = new RoomListReply();
        for(Room room: roomService.getAllRooms()){
            roomListReply.roomInfoList.add(roomMapper.fromInternal(room));
        }
        return roomListReply;
    }
    @RequestMapping(path="/room/byid/{roomid}",  method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RoomListReply getRoomById(@PathVariable Long roomid ){
        RoomListReply roomListReply = new RoomListReply();
        roomListReply.roomInfoList.add(roomMapper.fromInternal(roomService.getRoomById(roomid)));
        return roomListReply;
    }

    @RequestMapping(path="/room/add",  method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RoomListReply addRoom( @RequestBody AddRoomRequest roomRequest){
        RoomListReply roomListReply = new RoomListReply();
        try{
            Room room;
            room = roomService.addRoom(roomMapper.toInternal(roomRequest.roomInfo));
            roomListReply.roomInfoList.add(roomMapper.fromInternal(room));
        }catch(Exception e){
            roomListReply.retcode = -1;
            roomListReply.error_message = e.getMessage();
            logger.error("Error adding roomInfo. Expetion: "+e.getMessage(),e);
        }
        return roomListReply;
    }

    @RequestMapping(path="/room/update",  method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RoomListReply updateRoom( @RequestBody AddRoomRequest roomRequest){
        RoomListReply roomListReply = new RoomListReply();
        try{
            Room room;
            room = roomService.updateRoom(roomMapper.toInternal(roomRequest.roomInfo));
            roomListReply.roomInfoList.add(roomMapper.fromInternal(room));
        }catch(Exception e){
            roomListReply.retcode = -1;
            roomListReply.error_message = e.getMessage();
            logger.error("Error adding roomInfo. Expetion: "+e.getMessage(),e);
        }
        return roomListReply;
    }

    @RequestMapping(path="/room/del/{roomid}",  method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GenericReply delRoom(@PathVariable Long roomid ){
        GenericReply genericReply = new GenericReply();
        try{
            roomService.delRoom(roomid);
        }catch(Exception e){
            genericReply.retcode = -1;
            genericReply.error_message = e.getMessage();
            logger.error("Error adding roomInfo. Expetion: "+e.getMessage(),e);
        }
        return genericReply;
    }
}
