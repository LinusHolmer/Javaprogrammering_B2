package Lektion4.ovning3Dependency;

public class EmailMessenger implements Messenger{
    @Override
    public void sendMessage(String recipient, String message) {
        System.out.println("Sending email to"+ recipient + ": " + message);
    }
}
