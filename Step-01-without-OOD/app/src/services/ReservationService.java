package services;

import constants.Notifier;
import constants.PaymentMethods;
import services.PaymentStrategy;

public class ReservationService {

    private final DiscountService discountService = new DiscountService();
    private final InvoicePrinter invoicePrinter = new InvoicePrinter();
    private final NotificationService notificationService = new NotificationService();

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier) {
        System.out.println("Processing reservation for " + res.customer.getName());


        discountService.applyDiscount(res.customer, res.room);


        PaymentStrategy paymentStrategy = switch (paymentType) {
            case CARD     -> new CardPayment();
            case PAYPAL   -> new PayPalPayment();
            case CASH     -> new CashPayment();
            case INPERSON -> new InPersonPayment();
        };
        paymentStrategy.pay(res.totalPrice());


        invoicePrinter.printInvoice(res);


        notificationService.sendNotification(notifier, res.customer);
    }
}