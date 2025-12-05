package services;

public class InPersonPayment implements PaymentProcessor {
    public void pay(double amount) {
        System.out.println("Paid In Person: " + amount);
    }
}
