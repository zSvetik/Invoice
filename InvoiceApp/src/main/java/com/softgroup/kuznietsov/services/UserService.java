package com.softgroup.kuznietsov.services;

import com.softgroup.kuznietsov.jpa.User;
import com.softgroup.kuznietsov.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by User on 27.02.2017.
 */
@Service
public class UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        User user = userRepository.findOne(id);
        return user;
    }
    
    public User addUser(User user) {
    	logger.debug("Adding users %s with id %s", user.getLogin(), user.getId());
    	user = userRepository.save(user);
    	return user;
    }
    
    public void delUser(Long id) {
    	User user = userRepository.findOne(id);
    	if (user != null) {
    		logger.debug("Deleting users %s with id %s", user.getLogin(), user.getId());
    		userRepository.delete(id);
    	}
    }
}
