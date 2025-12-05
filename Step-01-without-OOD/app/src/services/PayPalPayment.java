package services;

class PayPalPayment implements PaymentProcessor {
    public void pay(double amount){
        System.out.println("Paid by PayPal: " + amount);
    }
}