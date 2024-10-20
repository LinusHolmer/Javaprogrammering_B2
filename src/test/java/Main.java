import Lektion4.ovning3Dependency.EmailMessenger;
import Lektion4.ovning3Dependency.MessageService;
import Lektion4.ovning3Dependency.Messenger;

public class Main {
    public static void main(String[] args) {
        Messenger EmailMessenger = new EmailMessenger();

        MessageService service = new MessageService(EmailMessenger);

        service.send("test@test.com","Hello friend");
    }
}
