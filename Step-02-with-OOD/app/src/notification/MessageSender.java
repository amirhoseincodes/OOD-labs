package notification;

public interface MessageSender {
    void send(String to, String message);
}