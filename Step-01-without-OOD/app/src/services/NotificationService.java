package services;

import constants.Notifier;
import models.Customer;

public class NotificationService {
    public void sendNotification(Notifier notifier, Customer customer) {
        switch (notifier) {
            case EMAIL:
                new EmailSender().send(customer.email, "Your reservation confirmed!");
                break;
            case SMS:
                new SmsSender().send(customer.mobile, "Your reservation confirmed!");
                break;
            default:
                System.out.println("There is no Message Provider");
        }
    }
}