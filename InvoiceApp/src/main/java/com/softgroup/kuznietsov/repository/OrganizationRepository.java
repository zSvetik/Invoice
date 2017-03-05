package com.softgroup.kuznietsov.repository;

import com.softgroup.kuznietsov.jpa.Organization;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by User on 05.03.2017.
 */
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {
    @Override
    List<Organization> findAll();
}
