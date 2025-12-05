package services;

class CardPayment implements PaymentProcessor {
    public void pay(double amount){
        System.out.println("Paid by card: " + amount);
    }
}