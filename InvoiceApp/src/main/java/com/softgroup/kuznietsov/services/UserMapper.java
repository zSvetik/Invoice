package com.softgroup.kuznietsov.services;

import com.softgroup.kuznietsov.api.InvUser;
import com.softgroup.kuznietsov.jpa.Role;
import com.softgroup.kuznietsov.jpa.User;
import com.softgroup.kuznietsov.repository.RoleRepository;
import com.softgroup.kuznietsov.repository.UserRepository;
import com.softgroup.kuznietsov.utils.EntityIdGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by User on 02.03.2017.
 */
@Component
public class UserMapper {
    private static final Logger logger = LoggerFactory.getLogger(UserMapper.class);

    public static final Long USER_ROLE_ID = 1L;

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

    /**
     * Maps internal JPA model to external REST model
     * @param user innternal user model
     * @return external REST user model
     */
    public InvUser fromInternal(User user) {
        InvUser invUser = null;
        if (user != null) {
            invUser = new InvUser();
            invUser.isAdmin = false;
            for (Role role : user.getRoleList()) {
                if (role.getId().equals(new Long (1))) {
                    invUser.isAdmin =  true;
                    break;
                }
            }
            invUser.login = user.getLogin();
            invUser.user_id = user.getId();
        }
        return invUser;
    }

    /**
     * Creates new User with good Id
     * @return newly created User with required fields set
     */
    private User newUser() {
        //TODO: get logged user from security context
        String createdBy = "REST";
        User user = new User();
        boolean idOK = false;
        Long id = 0L;
        while (!idOK) {
            id = EntityIdGenerator.random();
            idOK = !userRepository.exists(id);
        }
        //notNull
        user.setPassword("*");
        user.setId(id);
        user.setBalance(new Long(0));
        return user;
    }

    /**
     * Maps extrernal REST model to internal User;
     * If user does not exists in DB then creates new. If user already exists
     * then fetches user from DB and sets all fields from external REST model
     * @param invUser REST model
     * @return internal User with all required fields set
     */
    public User toInternal(InvUser invUser) {
        User user = null;
        //first, check if it exists
        if (invUser.user_id != null) {
            user = userRepository.findOne(invUser.user_id);
        }
        if (user == null) { //not found, create new
            logger.debug("Creating new user");
            user = newUser();
        }
        logger.debug("Updating existing user");
        user.setLogin(invUser.login);
        if (invUser.isAdmin) {
            Role role = roleRepository.findOne(USER_ROLE_ID);
            role.getUserList().add(user);
            user.getRoleList().add(role);
        }
        return user;
    }
}
