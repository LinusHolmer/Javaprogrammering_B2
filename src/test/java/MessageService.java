import Lektion4.ovning3Dependency.Messenger;

public class MessageService {
    private Messenger messenger;

    public MessageService(Messenger messenger) {
        this.messenger = messenger;
    }
    public void send(String recipient, String message) {
        messenger.sendMessage(recipient, message);
    }
}
