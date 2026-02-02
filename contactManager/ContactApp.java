import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp {

    private static ArrayList<Contact> contacts;
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 0;

    public static void main(String[] args) {
        contacts = new ArrayList<>();

        System.out.println("Welcome to the application");

        while (true) {
            System.out.println("Select your action");
            System.out.println("1. Manage contacts\n2. Manage messages\n3. Quit application");
            switch (getInt(2)) {
                case 1:
                    contactManager();
                    break;
                case 2:
                    messageManager();
                    break;
                case 3:
                    System.out.println("Thanks for using");
                    System.exit(0);
                    break;
                default:
                    switchError();
                    break;
            }
        }
    }

    // returns an integer from [1, max]
    private static int getInt(int max) {
        while (true) {
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                if (input < 1 || input > max) {
                    System.out.println("Please enter a number from 1 to " + max);
                    continue;
                }
                return input;
            } catch (Exception e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static void contactManager() {
        while (true) {
            System.out.println("Pick a contact manager action");
            System.out.println(
                    "1. Show All \n 2. Add a new contact \n 3. Search for a contact \n 4. Delete a contact \n 5. Go back to previous menu");
            switch (getInt(5)) {
                case 1:
                    for (Contact i : contacts) {
                        System.out.println("\n");
                        i.print();
                    }
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    searchContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    return;
                default:
                    switchError();
                    break;
            }
        }
    }

    private static void switchError() {
        System.out.println("An unexpected error has occured.");
        System.exit(1);
    }

    private static void addContact() {
        System.out.println("Enter the name of the contact: ");
        String name = scanner.nextLine();
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                System.out.println("Contact " + name + " already exists.");
                return;
            }
        }
        System.out.println("Enter " + name + "'s number: ");
        String number = scanner.nextLine();
        System.out.println("Enter " + name + "'s email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, number, email));
        System.out.println("Contact has been added.");
    }

    private static void searchContact() {
        System.out.println("Enter the name of the contact: ");
        String name = scanner.nextLine();
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                c.print();
                return;
            }
        }
        System.out.println("Failed to find a contact by name: " + name);
    }

    private static void deleteContact() {
        System.out.println("Enter the name of the contact to delete: ");
        String name = scanner.nextLine();
        Contact toRemove = null;
        for (Contact c : contacts) {
            if (c.getName().equals(name)) {
                toRemove = c;
                break;
            }
        }
        if (toRemove != null) {
            contacts.remove(toRemove);
        } else {
            System.out.println("Failed to find a contact by name: " + name);
        }
    }

    private static void messageManager() {
        System.out.println("Pick a contact manager action");
        System.out.println("1. Show all messages \n 2. Send a new message \n 3. Go back to previous menu");
        switch (getInt(3)) {
            case 1:
                showAllMessages();
                break;
            case 2:
                sendMessage();
                break;
            case 3:
                return;

            default:
                switchError();
                break;
        }
    }

    private static void showAllMessages() {
        ArrayList<Message> allMessages = new ArrayList<>();
        for (Contact c : contacts) {
            allMessages.addAll(c.getMessages());
        }

        if (allMessages.size() == 0) {
            System.out.println("No text messages found in system.");
            return;
        }

        for (Message m : allMessages) {
            System.out.println("\n");
            m.print();
        }
    }

    private static void sendMessage() {

        if (contacts.size() == 0) {
            System.out.println("No contacts found. cannot send messages.");
            return;
        }

        String name;
        Contact recipient = null;
        while (true) {
            System.out.println("Enter the name of the recipient: ");
            name = scanner.nextLine();
            for (Contact c : contacts) {
                if (c.getName().equals(name)) {
                    recipient = c;
                    break;
                }
            }
            if (recipient == null) {
                System.out.println("Failed to find contact " + name);
                System.out.println("Enter 1 to retry, 2 to exit");
                switch (getInt(2)) {
                    case 1:
                        continue;
                    case 2:
                        return;
                    default:
                        switchError();
                }
            }
            else {
                break;
            }
        }

        System.out.println("Enter the content of your message: ");
        String text = scanner.nextLine();
        Message message = new Message(recipient, text, ++idCounter);
        recipient.addMessage(message);

    }
}
