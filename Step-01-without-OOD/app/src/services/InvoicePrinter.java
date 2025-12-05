package services;

import services.Reservation;

public class InvoicePrinter {
    public void printInvoice(Reservation res) {
        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.customer.getName());
        System.out.println("hotel.Room: " + res.room.getNumber() + " (" + res.room.getType() + ")");
        System.out.println("Total: " + res.totalPrice());
        System.out.println("-------------------");
    }
}