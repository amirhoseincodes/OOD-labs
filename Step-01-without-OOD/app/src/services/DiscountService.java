package services;

import models.Customer;
import models.Room;

public class DiscountService {
    public void applyDiscount(Customer customer, Room room) {
        if ("Paris".equals(customer.getCity())) {
            System.out.println("Apply city discount for Paris!");
            room.setPrice(room.getPrice() * 0.9);
        }
        if ("Amirabad".equals(customer.getCity())) {
            System.out.println("Apply city discount for Amirabad!");
            room.setPrice(room.getPrice() * 0.5);
        }
    }
}