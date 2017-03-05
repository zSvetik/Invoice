package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.Invoice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {
    @Override
    List<Invoice> findAll();
}
