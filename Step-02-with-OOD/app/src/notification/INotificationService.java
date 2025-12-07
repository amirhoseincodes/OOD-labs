package notification;

import constants.Notifier;
import reservation.Reservation;

public interface INotificationService {
    void sendNotification(Notifier notifier, Reservation res);
}