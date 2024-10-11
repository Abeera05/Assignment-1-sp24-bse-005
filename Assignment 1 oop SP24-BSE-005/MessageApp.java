import java.time.LocalDateTime;
import java.util.Scanner;
public class MessageApp {
    private Message[] messages;
    private String[][] contacts;
    private int messageCount;
    private int contactCount;

    public MessageApp() {
        this.messages=new Message[100];
        this.contacts= new String[100][2];
        this.messageCount= 0;
        this.contactCount= 0;

        contacts[contactCount++]= new String[]{"Ali", "12345678901"};
        contacts[contactCount++]= new String[]{"Ahmad", "12345678902"};
        contacts[contactCount++]= new String[]{"Dua", "12345678903"};
        contacts[contactCount++]= new String[]{"John", "12345678904"};
        contacts[contactCount++]= new String[]{"SP24-bse-005", "12345678905"};
    }

    public void addContact() {
        System.out.println("--------------------Update Contacts List-------------------");
        Scanner sc1= new Scanner(System.in);
        System.out.print("Enter contact name: ");
        String name= sc1.nextLine();
        System.out.print("Enter contact number: ");
        String number= sc1.nextLine();
        if (number.length()< 11) {
            System.out.println("Invalid Contact Number");
            return;
        }
        contacts[contactCount][0] =name;
        contacts[contactCount][1]=number;
        contactCount++;
        System.out.println("Contact added: "+name+ " - "+ number);
    }


    public void sendMessage() {
        System.out.println("--------------------Send Message-------------------");
        Scanner sc2= new Scanner(System.in);
        System.out.print("Enter receiver's name: ");
        String receiver= sc2.nextLine();
        System.out.print("Enter message content: ");
        String content= sc2.nextLine();
        LocalDateTime timestamp= LocalDateTime.now();
        Message newMessage= new Message(receiver, content, timestamp);
        messages[messageCount]=newMessage;
        messageCount++;
        System.out.println("Message sent from "+newMessage.getSender()+" to " +receiver);
        System.out.println("Message ID: "+newMessage.getMessageID());
    }

    public void readMessages() {
        System.out.println("--------------------Message Status-------------------");
        Scanner sc5= new Scanner(System.in);
        System.out.print("Enter receiver name to check if the messages were read: ");
        String checkReceiver= sc5.nextLine();

        boolean messageread =false;
        for (int i = 0; i< messageCount; i++) {
            if (messages[i].getReceiver().equalsIgnoreCase(checkReceiver)&& messages[i].getStatus()== Message.MessageStatus.UNREAD) {
                System.out.println(messages[i]);
                System.out.println("-------------------------");

                messages[i].setStatus(Message.MessageStatus.READ);
                messageread= true;
            }
        }
        if (messageread) {
            System.out.println("All displayed messages are now marked as READ.");
        } else {
            System.out.println("No unread messages for "+checkReceiver);
        }
    }



    public boolean isMessageDelivered() {
        System.out.println("--------------------Message Delivery Status-------------------");
        Scanner sc5= new Scanner(System.in);
        System.out.print("Enter receiver name to check if the message was delivered: ");
        String checkReceiver= sc5.nextLine();

        for (int i =0; i <messageCount; i++) {
            if (messages[i].getReceiver().equalsIgnoreCase(checkReceiver)) {
                if (messages[i].getDeliverystatus()== Message.MessageStatus.SENT) {
                    System.out.println("Message delivery status: sent");
                    return true;
                }
            }
        }
        System.out.println("Message delivery status: Not Delivered");
        return false;
    }


    public void sortMessages() {
        for (int i=0; i< messageCount-1; i++) {
            for (int j=0; j<messageCount-i-1;j++) {
                if (messages[j].getTimestamp().isBefore(messages[j+1].getTimestamp())){
                    Message temp= messages[j];
                    messages[j]= messages[j+1];
                    messages[j+1] =temp;
                }
            }
        }
        System.out.println("Messages sorted by time:");
        for (int i= 0; i< messageCount; i++) {
            System.out.println(messages[i]);
            System.out.println("-------------------------");
        }
    }

    public void searchMessages() {
        System.out.println("--------------------Search Message Menu-------------------");
        Scanner sc6= new Scanner(System.in);
        System.out.print("Enter the receiver name to search for messages: ");
        String receiverName= sc6.nextLine();

        boolean messagefound= false;
        for (int i=0; i<messageCount; i++) {
            if (messages[i] != null&& messages[i].getReceiver().equalsIgnoreCase(receiverName)) {
                System.out.println("....Message found...");
                System.out.println(messages[i]);
                messagefound= true;
            }
        }
        if (!messagefound) {
            System.out.println("No messages found");
        }
    }


    public void displaySpecificMessage() {
        Scanner sc7 = new Scanner(System.in);
        System.out.println("-------------Display Specific Message--------------");
        System.out.println("Enter the receiver name: ");
        String receiverName=sc7.nextLine();
        System.out.println("Enter the Message ID: ");
        String id=sc7.nextLine();

        for(int i=0; i<messageCount; i++){
            if(messages[i]!= null && messages[i].getReceiver().equalsIgnoreCase(receiverName)&& messages[i].getMessageID().equals(id)){
                System.out.println("---Here's the message you searched for:");
                System.out.println(messages[i]);
                return;
            }
        }
        System.out.println("Message not found");
    }


    public void deleteMessage() {
        Scanner sc8 = new Scanner(System.in);
        System.out.println("--------------------Delete Message Menu-------------------");
        System.out.print("Enter receiver's name: ");
        String receiverName = sc8.nextLine();
        System.out.print("Enter the Message ID you want to delete: ");
        String messageID = sc8.nextLine();
        for (int i = 0; i < messageCount; i++) {
            if (messages[i]!= null &&messages[i].getReceiver().equalsIgnoreCase(receiverName)&& messages[i].getMessageID().equals(messageID)) {
                for (int j=i;j<messageCount-1; j++) {
                    messages[j] =messages[j+1];
                }
                messages[--messageCount]= null;
                System.out.println("Message with ID " + messageID + " has been deleted.");
                return;
            }
        }
        System.out.println("Message not found");
    }




    public void displayContacts() {
        System.out.println("--------------------Contacts List-------------------");
        for (int i=0; i <contactCount; i++) {
            System.out.println(contacts[i][0] +" - "+ contacts[i][1]);
        }
    }
}