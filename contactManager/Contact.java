import java.util.ArrayList;


public class Contact {
  private String name;
  private String number;
  private String email;
  private ArrayList<Message> messages;

  // Constructors
  public Contact(String name, String number, String email, ArrayList<Message> messages) {
    this.name = name;
    this.number = number;
    this.email = email;
    this.messages = messages;
  }

  public Contact(String name, String number, String email){
    this.name = name;
    this.number = number;
    this.email = email;
    this.messages = new ArrayList<Message>();
  }

  // print the contact
  public void print(){
    System.out.println("Name: " + name);
    System.out.println("Number: " + number);
    System.out.println("Email: " + email);
  }

  // Getter and Setter for name
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  // Getter and Setter for number
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  // Getter and Setter for email
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  // Getter and Setter for messages
  public ArrayList<Message> getMessages() {
    return messages;
  }

  public void setMessages(ArrayList<Message> messages) {
    this.messages = messages;
  }

}
