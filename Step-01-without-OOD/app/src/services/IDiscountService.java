package services;

import models.Customer;
import models.Room;

public interface IDiscountService {
    void applyDiscount(Customer customer, Room room);
}