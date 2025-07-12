public class Message {
  private Contact recipient;
  private String content; 
  private int id;

  // Constructor
  public Message(Contact recipient, String content, int id) {
    this.recipient = recipient;
    this.content = content;
    this.id = id;
  }

  public void print(){
    System.out.println("Recipient: " + recipient.getName());
    System.out.println("Message ID: " + id);
    System.out.println("> " + content);
  }

  // Getter and Setter for recipient
  public Contact getRecipient() {
    return recipient;
  }

  public void setRecipient(Contact recipient) {
    this.recipient = recipient;
  }

  // Getter and Setter for content
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  // Getter and Setter for id
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
}
