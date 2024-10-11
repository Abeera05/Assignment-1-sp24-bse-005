import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessageApp app= new MessageApp();
        Scanner scanner= new Scanner(System.in);

        while (true) {
            System.out.println("---------------MAIN MENU----------------");
            System.out.println("\n1. Add a new contact");
            System.out.println("2. Send a message");
            System.out.println("3. Read messages of a contact");
            System.out.println("4. Check if message was delivered");
            System.out.println("5. Display all messages sorted by time");
            System.out.println("6. Search Messages");
            System.out.println("7. Delete message by contacts");
            System.out.println("8. Display all contacts");
            System.out.println("9. Display specific messages");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            int choice=scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    app.addContact();
                    break;

                case 2:
                    app.sendMessage();
                    break;

                case 3:
                    app.readMessages();
                    break;

                case 4:
                    app.isMessageDelivered();
                    break;

                case 5:
                    app.sortMessages();
                    break;

                case 6:
                    app.searchMessages();
                    break;

                case 7:
                    app.deleteMessage();
                    break;

                case 8:
                    app.displayContacts();
                    break;

                case 9:
                    app.displaySpecificMessage();
                    break;

                case 0:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
