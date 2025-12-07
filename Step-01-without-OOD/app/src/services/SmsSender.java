package services;

class SmsSender implements MessageSender {
    public void send(String to, String message) {
        System.out.println("Sending SMS to " + to + ": " + message);
    }
}