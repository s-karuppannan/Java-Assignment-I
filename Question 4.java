import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Contact class with attributes, constructor, and getter/setter methods
class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

   void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
    }
}
class AddressBook {
    List<Contact> contacts;

   AddressBook() {
        contacts = new ArrayList<>();
    }

    void addContact(Contact contact) {
        contacts.add(contact);
    }

    void viewAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    void searchContact(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                System.out.println(contact);
                return;
            }
        }
        System.out.println("Contact not found.");
    }
}

 class AddressBookApp {
    static Scanner scanner = new Scanner(System.in);
    static AddressBook addressBook = new AddressBook();

     public static void main(String[] args) {
        while (true) {
            System.out.println("\nAddress Book Menu:");
            System.out.println("1. Add a new contact");
            System.out.println("2. View all contacts");
            System.out.println("3. Search for a contact by name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    addressBook.viewAllContacts();
                    break;
                case 3:
                    searchContactByName();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

   void addNewContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Enter email address: ");
        String email = scanner.nextLine();
        Contact contact = new Contact(name, phoneNumber, email);
        addressBook.addContact(contact);
        System.out.println("Contact added.");
    }

    void searchContactByName() {
        System.out.print("Enter the name to search: ");
        String name = scanner.nextLine();
        addressBook.searchContact(name);
    }
}
