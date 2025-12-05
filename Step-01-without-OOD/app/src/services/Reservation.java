package services;

import models.Customer;
import models.Room;

public class Reservation {
    public final Room room;
    public final Customer customer;
    public final int nights;

    public Reservation(Room r, Customer c, int nights) {
        this.room = r;
        this.customer = c;
        this.nights = nights;
    }

    public double totalPrice() {
        return room.getPrice() * nights;
    }
}