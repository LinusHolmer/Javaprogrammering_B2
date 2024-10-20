import Lektion4.ovning3Dependency.Messenger;

public class TestMessenger implements Messenger {
    private String lastRecipient;
    private String lastMessage;

    @Override
    public void sendMessage(String recipient, String message) {
        this.lastRecipient = recipient;
        this.lastMessage = message;
    }

    public String getLastRecipient() {
        return lastRecipient;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
