package services;

import models.Customer;
import models.Room;

public class Reservation {
    private final Room room;
    private final Customer customer;
    private final int nights;

    public Reservation(Room room, Customer customer, int nights) {
        this.room = room;
        this.customer = customer;
        this.nights = nights;
    }


    public double getTotalPrice() {
        return room.getPrice() * nights;
    }


    public String getCustomerName() { return customer.getName(); }
    public String getCustomerCity() { return customer.getCity(); }
    public String getCustomerEmail() { return customer.getEmail(); }
    public String getCustomerMobile() { return customer.getMobile(); }

    public String getRoomNumber() { return room.getNumber(); }
    public String getRoomType() { return room.getType(); }
    public double getRoomPrice() { return room.getPrice(); }
    public void applyRoomPrice(double newPrice) { room.setPrice(newPrice); }
}