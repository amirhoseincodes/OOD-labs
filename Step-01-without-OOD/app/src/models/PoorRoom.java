package models;

public class PoorRoom extends Room {
    public PoorRoom(String number, double price){
        super(number, "poor", price);
    }
    public void addFreeRommate(){
        System.out.println("Free roommate added for poor room " + getNumber()); // از getter استفاده می کنیم. 
    }
}
