package services;

public class DiscountService implements IDiscountService {
    @Override
    public void applyDiscount(Reservation res) {
        String city = res.getCustomerCity();

        if ("Paris".equals(city)) {
            System.out.println("Apply city discount for Paris!");
            res.applyRoomPrice(res.getRoomPrice() * 0.9);
        }
        if ("Amirabad".equals(city)) {
            System.out.println("Apply city discount for Amirabad!");
            res.applyRoomPrice(res.getRoomPrice() * 0.5);
        }
    }
}