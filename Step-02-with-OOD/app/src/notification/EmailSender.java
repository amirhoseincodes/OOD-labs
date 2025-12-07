package notification;

class EmailSender implements MessageSender {
    public void send(String to, String message) {
        System.out.println("Sending email to " + to + ": " + message);
    }
}