package com.deliasoft.addressbook.service;

import com.deliasoft.addressbook.model.Contact;
import com.deliasoft.addressbook.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ContactService {

    @Autowired
    public ContactRepository contactRepository;

    public List<Contact> getContactList(){
        return contactRepository.findAll();
    }

    public Contact saveContact(Contact contact){
        if(isValidContact(contact)){
            contact = contactRepository.save(contact);
            return  contact;
        } else{
            return null;
        }
    }

    public void deleteContact(Long id){
        Contact contact = contactRepository.findById(id).get();
        contactRepository.delete(contact);
    }

    public boolean isValidContact(Contact contact){
        if(contact.getName().equals("") || contact.getSurname().equals("") || contact.getPhoneNumber().equals("")) {
            return false;
        } else {
            return true;
        }
    }
}
