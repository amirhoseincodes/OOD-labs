package services;

import constants.Notifier;

public interface INotificationService {
    void sendNotification(Notifier notifier, Reservation res);
}