package services;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {
    private Notifier notifier = Notifier.EMAIL; //default Notifier
    private PaymentProcessor paymentProcessor ; // در نسخه جدید چون اینترفیس هست new نداریم. 
    // private PaymentProcessor paymentProcessor = new PaymentProcessor();

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier){
        this.notifier = notifier;
        System.out.println("Processing reservation for " + res.customer.name);

        if(res.customer.city.equals("Paris")){
            System.out.println("Apply city discount for Paris!");
           res.room.setPrice(res.room.getPrice() * 0.9);
        }
        if(res.customer.city.equals("Amirabad")){
            System.out.println("Apply city discount for Amirabad!");
            res.room.setPrice(res.room.getPrice()* 0.5);
        }

        switch (paymentType){
            case CARD:
                paymentProcessor = new CardPayment();
                paymentProcessor.pay(res.totalPrice());
                // paymentProcessor.payByCard(res.totalPrice());
                break;
            case PAYPAL:
                paymentProcessor = new PayPalPayment();
                paymentProcessor.pay(res.totalPrice());
                // paymentProcessor.payByPayPal(res.totalPrice());
                break;
            case CASH:
                paymentProcessor = new CashPayment();
                paymentProcessor.pay(res.totalPrice());
                // paymentProcessor.payByCash(res.totalPrice());
                break;
            case INPERSON:
                paymentProcessor = new InPersonPayment();
                paymentProcessor.pay(res.totalPrice());
                // paymentProcessor.payInPerson(res.totalPrice());
                break;
        }

        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.customer.name);
        System.out.println("hotel.Room: " + res.room.getNumber() + " (" + res.room.getType() + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");

       switch (this.notifier){
           case EMAIL :
           EmailSender emailSender = new EmailSender();
           emailSender.send(res.customer.email, "Your reservation confirmed!");
           break;
           case SMS :
           SmsSender smsSender = new SmsSender();
           smsSender.send(res.customer.mobile, "Your reservation confirmed!");
           break;
           default:
               System.out.println("There is no Message Provider");
       }
    }
}