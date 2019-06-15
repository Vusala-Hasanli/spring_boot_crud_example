package com.deliasoft.addressbook.controller;

import com.deliasoft.addressbook.model.Contact;
import com.deliasoft.addressbook.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ContactController {

    @Autowired
    public ContactService contactService;

    @GetMapping(value = "api/contacts")
    public List<Contact> getContactList(){
        return contactService.getContactList();
    }

    @PostMapping(value = "api/contacts")
    public Contact saveContact(@RequestBody Contact contact){
        return contactService.saveContact(contact);
    }

    @PostMapping(value = "api/contacts/delete")
    public void deleteContact(@RequestBody Contact contact){
        contactService.deleteContact(contact.getId());
    }

}
