package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 27.02.2017.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    @Override
    public List<User> findAll();
}
