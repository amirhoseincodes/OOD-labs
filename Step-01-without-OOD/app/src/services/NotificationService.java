package services;

import constants.Notifier;
import models.Customer;

public class NotificationService implements INotificationService {
    private MessageSender getSender(Notifier notifier) {
        switch (notifier) {
            case EMAIL: return new EmailSender();
            case SMS: return new SmsSender();
            default: throw new IllegalArgumentException("Unsupported notifier: " + notifier);
        }
    }

    public void sendNotification(Notifier notifier, Customer customer) {
        MessageSender sender = getSender(notifier);
        String to = notifier == Notifier.EMAIL ? customer.getEmail() : customer.getMobile();
        sender.send(to, "Your reservation confirmed!");
    }
}