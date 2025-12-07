import constants.PaymentMethods;
import constants.Notifier;
import models.Customer;
import models.LuxuryRoom;
import models.PoorRoom;
import reservation.Reservation;
import reservation.ReservationService;

import payment.DiscountService;
import reservation.InvoicePrinter;
import notification.NotificationService;
public class Main {
    public static void main(String[] args) {
        Customer c1 = new Customer("Ali", "ali@example.com", "09124483765", "Paris");
        LuxuryRoom r1 = new LuxuryRoom("203", 150);
        Reservation res1 = new Reservation(r1, c1, 2);

        Customer c2 = new Customer("Amir", "amir@amirabad.com", "09102031510", "Amirabad");
        PoorRoom r2 = new PoorRoom("108", 80);
        Reservation res2 = new Reservation(r2, c2, 1);

        ReservationService service = new ReservationService(
                new DiscountService(),
                new InvoicePrinter(),
                new NotificationService()
        );

        service.makeReservation(res1, PaymentMethods.PAYPAL, Notifier.EMAIL);
        System.out.println();
        service.makeReservation(res2, PaymentMethods.INPERSON, Notifier.EMAIL);
    }
}