import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactManagerTest {
    private ContactManager contactManager;

    @BeforeEach
    void setUp() {
        contactManager = new ContactManager();
    }

    @Test
    void testAddNewContact() {
        Contact contact = new Contact("Michael Johnson", "m.johnson@gmail.com");
        contactManager.addNewContact(contact);

        assertEquals(1, contactManager.getContactCount(), "Contact count should be 1 after adding a contact.");
    }

    @Test
    void testFindExistingContact() {
        Contact contact = new Contact("Emily Davis", "emily.davis@outlook.com");
        contactManager.addNewContact(contact);

        Contact foundContact = contactManager.findContact("emily.davis@outlook.com");
        assertNotNull(foundContact, "The contact should be found.");
        assertEquals("Emily Davis", foundContact.getName(), "The contact name should match.");
    }

    @Test
    void testFindNonExistingContact() {
        Contact contact = new Contact("Sarah Lee", "sarah.lee@yahoo.com");
        contactManager.addNewContact(contact);

        Contact foundContact = contactManager.findContact("unknown@example.com");
        assertNull(foundContact, "The contact should not be found.");
    }

    @Test
    void testClearContacts() {
        contactManager.addNewContact(new Contact("David Brown", "david.brown@company.com"));
        contactManager.addNewContact(new Contact("Lisa White", "lisa.white@hotmail.com"));

        assertEquals(2, contactManager.getContactCount(), "Contact count should be 2 before clearing.");

        contactManager.clearContacts();
        assertEquals(0, contactManager.getContactCount(), "Contact count should be 0 after clearing.");
    }

    @Test
    void testAddMultipleContactsAndExpandArray() {
        // Adding more than the initial array size of 5 to trigger expansion
        contactManager.addNewContact(new Contact("Person 1", "person1@example.com"));
        contactManager.addNewContact(new Contact("Person 2", "person2@example.com"));
        contactManager.addNewContact(new Contact("Person 3", "person3@example.com"));
        contactManager.addNewContact(new Contact("Person 4", "person4@example.com"));
        contactManager.addNewContact(new Contact("Person 5", "person5@example.com"));
        contactManager.addNewContact(new Contact("Person 6", "person6@example.com"));

        assertEquals(6, contactManager.getContactCount(), "Contact count should be 6 after adding multiple contacts.");
    }
}
