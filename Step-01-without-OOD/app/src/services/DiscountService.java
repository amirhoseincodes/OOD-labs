package services;

import models.Customer;
import models.Room;

public class DiscountService {
    public void applyDiscount(Customer customer, Room room) {
        if (customer.city.equals("Paris")) {
            System.out.println("Apply city discount for Paris!");
            room.price *= 0.9;
        }
        if (customer.city.equals("Amirabad")) {
            System.out.println("Apply city discount for Amirabad!");
            room.price *= 0.5;
        }
    }
}