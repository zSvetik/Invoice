package com.softgroup.kuznietsov.tests.unit;

import com.softgroup.kuznietsov.jpa.User;
import com.softgroup.kuznietsov.services.UserService;
import com.softgroup.kuznietsov.utils.EntityIdGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by User on 02.03.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    private UserService userServie;

    @Test
    public void findUserTest() throws Exception {
        int count = userServie.getAllUsers().size();
        assert(count>=1);
    }

    @Test
    public void findByIdTest(){
        //List<Appuser> ul = userServie.findUserByName("Ivan", "Ivanov");
        User ul = userServie.getUserById(new Long(1));
        boolean count = (ul != null);
        assertEquals("Can not find pre-defined user",true, count);
    }

    @Test
    public void addUserTest(){
        Long user_id = EntityIdGenerator.random();
        User au = new User(user_id);
        au.setLogin("test_username");
        au.setPassword("ttt@test.com");
        userServie.addUser(au);
        User u = userServie.getUserById(user_id);
        assertNotNull("New user not found!", u);
        userServie.delUser(user_id);
        u = userServie.getUserById(user_id);
        assertNull("Can not delete user!", u);

    }
}
