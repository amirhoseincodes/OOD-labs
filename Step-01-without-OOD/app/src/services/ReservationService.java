package services;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {
    private final IDiscountService discountService;
    private final IInvoicePrinter invoicePrinter;
    private final INotificationService notificationService;

    public ReservationService(IDiscountService discountService,
                              IInvoicePrinter invoicePrinter,
                              INotificationService notificationService) {
        this.discountService = discountService;
        this.invoicePrinter = invoicePrinter;
        this.notificationService = notificationService;
    }

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier) {
        System.out.println("Processing reservation for " + res.getCustomerName());

        discountService.applyDiscount(res);

        PaymentStrategy paymentStrategy = switch (paymentType) {
            case CARD     -> new CardPayment();
            case PAYPAL   -> new PayPalPayment();
            case CASH     -> new CashPayment();
            case INPERSON -> new InPersonPayment();
        };
        paymentStrategy.pay(res.getTotalPrice());

        invoicePrinter.printInvoice(res);

        notificationService.sendNotification(notifier, res);
    }
}