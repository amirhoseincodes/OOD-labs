package payment;

// import models.Customer;
// import models.Room;
import reservation.Reservation;
public interface IDiscountService {
    void applyDiscount(Reservation res);
}