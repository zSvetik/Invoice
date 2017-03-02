package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 02.03.2017.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    @Override
    public List<Role> findAll();
}
