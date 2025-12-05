package models;

public class Room {
    private final String number;  // تغییرناپذیر
    private final String type;    // تعیین در سازنده، تغییر ندارد
    private double price;         // قابل تغییر فقط با قواعد مشخص

    public Room(String number, String type, double price){
        this.number = number;
        this.type = type;
        this.price = price;
    }

    public String getNumber() { return number; }
    public String getType() { return type; }
    public double getPrice() { return price; }

    // فقط اگر لازم باشد قیمت تغییر کند 
    public void setPrice(double price) {
        if(price > 0) this.price = price;
    }
}

// package models;

// public class Room {
//     public String number;
//     public String type; // "standard" or "luxury"
//     public double price;

//     public Room(String number, String type, double price){
//         this.number = number;
//         this.type = type;
//         this.price = price;
//     }
// }
