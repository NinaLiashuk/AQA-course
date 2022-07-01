package by.it.academy.Md_AT1.hw4_XML.service;

import by.it.academy.Md_AT1.hw4_XML.dto.Contacts;

public class CreateContacts {

    public static Contacts createContacts(){
        Contacts contacts = new Contacts();
        contacts.setAddress("Minsk");
        contacts.setTel("8-3232-121212");
        contacts.setEmail("j@j.com");
        contacts.setUrl("www.j.com");
        return contacts;
    }
}
