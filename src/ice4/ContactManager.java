/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ice4;

/**
 *
 * @author Haroleon
 *

import java.util.Arrays;

public class ContactManager {
    private Contact[] contactList;
    private int count; 

    public ContactManager() {
        contactList = new Contact[5]; 
        count = 0;
    }

    public void addNewContact(Contact contact) {
        if (count == contactList.length) {
            contactList = Arrays.copyOf(contactList, contactList.length * 2);
        }
        contactList[count] = contact;
        count++;
    }

    public Contact findContact(String emailAddress) {
        if (emailAddress == null || emailAddress.isEmpty()) {
            return null;
        }
        for (int i = 0; i < count; i++) {
            if (emailAddress.equalsIgnoreCase(contactList[i].getEmailAddress())) {
                return contactList[i];
            }
        }
        return null; // Contact not found
    }

    public void clearContacts() {
        Arrays.fill(contactList, 0, count, null);
        count = 0;
    }

    public int getContactCount() {
        return count;
    }
}


