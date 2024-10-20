package Lektion4.ovning3Dependency;

public class Main {
    public static void main(String[] args) {
        Messenger EmailMessenger = new EmailMessenger();

        MessageService service = new MessageService(EmailMessenger);

        service.send("test@test.com","Hello friend");

    }
}
