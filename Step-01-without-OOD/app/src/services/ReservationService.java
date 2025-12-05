package services;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {
    private PaymentProcessor paymentProcessor = new PaymentProcessor();
    private DiscountService discountService = new DiscountService();
    private InvoicePrinter invoicePrinter = new InvoicePrinter();
    private NotificationService notificationService = new NotificationService();

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier) {
        System.out.println("Processing reservation for " + res.customer.name);


        discountService.applyDiscount(res.customer, res.room);


        switch (paymentType) {
            case CARD:
                paymentProcessor.payByCard(res.totalPrice());
                break;
            case PAYPAL:
                paymentProcessor.payByPayPal(res.totalPrice());
                break;
            case CASH:
                paymentProcessor.payByCash(res.totalPrice());
                break;
            case INPERSON:
                paymentProcessor.payInPerson(res.totalPrice());
                break;
        }


        invoicePrinter.printInvoice(res);


        notificationService.sendNotification(notifier, res.customer);
    }
}