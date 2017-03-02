package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 27.02.2017.
 */
public interface UsersRepository extends CrudRepository<Users, Long> {
    @Override
    public List<Users> findAll();
}
