package services;

public class InvoicePrinter implements IInvoicePrinter {
    @Override
    public void printInvoice(Reservation res) {
        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.getCustomerName());
        System.out.println("hotel.Room: " + res.getRoomNumber() + " (" + res.getRoomType() + ")");
        System.out.println("Total: " + res.getTotalPrice());
        System.out.println("-------------------");
    }
}