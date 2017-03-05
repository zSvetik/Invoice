package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.PaymentAccount;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface PaymentAccountRepository extends CrudRepository<PaymentAccount, Long> {
    @Override
    List<PaymentAccount> findAll();
}
