package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.Bank;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface BankRepository extends CrudRepository<Bank, Integer> {
    @Override
    List<Bank> findAll();
}
