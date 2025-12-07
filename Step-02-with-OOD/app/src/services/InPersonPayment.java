package services;

public class InPersonPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paid In Person: " + amount);
    }
}
