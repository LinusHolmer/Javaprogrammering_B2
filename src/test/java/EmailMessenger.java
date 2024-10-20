import Lektion4.ovning3Dependency.Messenger;

public class EmailMessenger implements Messenger {
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending email to"+ recipient + ": " + message);
    }
}
