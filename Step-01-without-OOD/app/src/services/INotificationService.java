package services;

import constants.Notifier;
import models.Customer;

public interface INotificationService {
    void sendNotification(Notifier notifier, Customer customer);
}