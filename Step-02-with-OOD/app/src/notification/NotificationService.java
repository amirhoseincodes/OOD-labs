package notification;

import constants.Notifier;
import reservation.Reservation;

public class NotificationService implements INotificationService {
    private MessageSender getSender(Notifier notifier) {
        return switch (notifier) {
            case EMAIL -> new EmailSender();
            case SMS -> new SmsSender();
        };
    }

    @Override
    public void sendNotification(Notifier notifier, Reservation res) {
        MessageSender sender = getSender(notifier);
        String to = (notifier == Notifier.EMAIL)
                ? res.getCustomerEmail()
                : res.getCustomerMobile();
        sender.send(to, "Your reservation confirmed!");
    }
}