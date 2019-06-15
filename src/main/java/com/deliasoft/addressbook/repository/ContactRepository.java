package com.deliasoft.addressbook.repository;

import com.deliasoft.addressbook.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContactRepository extends CrudRepository<Contact,Long> {

    @Override
    List<Contact> findAll();

    Contact findByName(@Param("name") String name);

}
