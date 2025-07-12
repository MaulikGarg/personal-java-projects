import java.util.ArrayList;
import java.util.Scanner;

public class ContactApp{

    private static ArrayList<Contact> contacts;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        contacts = new ArrayList<>();
        
        System.out.println("Welcome to the application");

        while(true){
            System.out.println("Select your action");
            System.out.println("1. Manage contacts \n 2. Manage messages \n 3. Quit application");
            switch (getInt(2)) {
                case 1:
                    contactManager();
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Thanks for using");
                    System.exit(0);
                    break;
                default:
                    System.out.println("An unexpected error has occured.");
                    System.exit(1);
                    break;
            }
        }
    }

    // returns an integer from [1, max]
    private static int getInt(int max){
        while(true){
            try{
                int input = scanner.nextInt();
                if(input < 1 || input > max){
                    System.out.println("Please enter a number from 1 to " + max);
                    continue;
                }
                return input;
            }
            catch(Exception e){
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static void contactManager(){
        while(true){
            System.out.println("Pick a contact manager action");
            System.out.println("1. Show All \n 2. Add a new contact \n 3. Search for a contact \n 4. Delete a contact \n 5. Go back to previous menu");
            switch (getInt(5)) {
                case 1:
                    for(Contact i : contacts){
                        System.out.println("\n");
                        i.print();
                    }
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    return;
                default:
                    System.out.println("An unexpected error has occured.");
                    System.exit(1);
                    break;    
            }
        }
    }

    private static void addContact(){
        System.out.println("Enter the name of the contact: ");
        String name = scanner.nextLine();
        System.out.println("Enter " + name + "'s number: ");
        String number = scanner.nextLine();
        System.out.println("Enter " + name + "'s email: ");
        String email = scanner.nextLine();
        contacts.add(new Contact(name, number, email));
        System.out.println("Contact has been added.");
    }
}
