package services;

import constants.Notifier;
import models.Customer;

public class NotificationService {
    private MessageSender getSender(Notifier notifier) {
        return switch (notifier) {
            case EMAIL -> new EmailSender();
            case SMS -> new SmsSender();
        };
    }

    public void sendNotification(Notifier notifier, Customer customer) {
        MessageSender sender = getSender(notifier);
        String to = notifier == Notifier.EMAIL ? customer.getEmail() : customer.getMobile();
        sender.send(to, "Your reservation confirmed!");
    }
}