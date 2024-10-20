import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessageServiceTest {

    @Test
    public void testSend() {
        TestMessenger testMessenger = new TestMessenger();

        MessageService service = new MessageService(testMessenger);

        service.send("test@test.com","test message");

        assertEquals("test@test.com", testMessenger.getLastRecipient());
        assertEquals("test message", testMessenger.getLastMessage());
    }
}
