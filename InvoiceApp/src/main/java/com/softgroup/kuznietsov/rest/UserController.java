package com.softgroup.kuznietsov.rest;

import com.softgroup.kuznietsov.api.AddUserRequest;
import com.softgroup.kuznietsov.api.GenericReply;
import com.softgroup.kuznietsov.api.UserListReply;
import com.softgroup.kuznietsov.jpa.User;
import com.softgroup.kuznietsov.services.UserMapper;
import com.softgroup.kuznietsov.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by User on 02.03.2017.
 */
@RestController
public class UserController {
    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;

    @RequestMapping(path="/users/all",  method= RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserListReply getAllUsers(){
        UserListReply reply = new UserListReply();
        for(User user: userService.getAllUsers()){
            reply.userList.add(userMapper.fromInternal(user));
        }
        return reply;
    }
    @RequestMapping(path="/users/byid/{userid}",  method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserListReply getUserById(@PathVariable Long userid ){
        UserListReply reply = new UserListReply();
        reply.userList.add(userMapper.fromInternal(userService.getUserById(userid)));
        return reply;
    }

    @RequestMapping(path="/users/add",  method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public UserListReply addUser( @RequestBody AddUserRequest req){
        UserListReply rep = new UserListReply();
        try{
            User user;
            user = userService.addUser(userMapper.toInternal(req.user));
            rep.userList.add(userMapper.fromInternal(user));
        }catch(Exception e){
            rep.retcode = -1;
            rep.error_message = e.getMessage();
            logger.error("Error adding user. Expetion: "+e.getMessage(),e);
        }
        return rep;
    }

    @RequestMapping(path="/users/del/{userid}",  method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public GenericReply delUser(@PathVariable Long userid ){
        GenericReply rep = new GenericReply();
        try{
            userService.delUser(userid);
        }catch(Exception e){
            rep.retcode = -1;
            rep.error_message = e.getMessage();
            logger.error("Error adding user. Expetion: "+e.getMessage(),e);
        }
        return rep;
    }
}
