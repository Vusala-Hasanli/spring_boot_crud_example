package com.deliasoft.addressbook;

import com.deliasoft.addressbook.model.Contact;
import com.deliasoft.addressbook.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)

public class ContactRepositoryTests {

    @Autowired
    public ContactRepository contactRepository;

    @Test
    public void testSaveContact() {
        Contact contact1 = new Contact("Vusala","Hasanli","1234567890");
        contactRepository.save(contact1);
        Contact contact2 = contactRepository.findByName("Vusala");

        assertNotNull(contact1);
        assertEquals(contact2.getName(), contact1.getName());
        assertEquals(contact2.getSurname(), contact1.getSurname());
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("Vusala","Hasanli","1234567890");
        contactRepository.save(contact);
        contactRepository.delete(contact);
    }
}
