package services;

class CashPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid by cash: " + amount);
    }
}
