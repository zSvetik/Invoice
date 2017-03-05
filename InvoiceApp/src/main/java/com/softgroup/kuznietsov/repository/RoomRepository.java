package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface RoomRepository extends CrudRepository<Room, Long> {
    @Override
    List<Room> findAll();
}
