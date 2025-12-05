import constants.PaymentMethods;
import models.Customer;
import models.LuxuryRoom;
import models.PoorRoom;
import constants.Notifier;
import services.Reservation;
import models.Room;
import services.ReservationService;

public class Main {
    public static void main(String[] args){
        Customer customer = new Customer("Ali", "ali@example.com","09124483765", "Paris");
        Room room = new LuxuryRoom("203", 150);
        Reservation res = new Reservation(room, customer, 2);

        ReservationService service = new ReservationService();
        service.makeReservation(res, PaymentMethods.PAYPAL, Notifier.EMAIL);

        System.out.println(); 
        

        Customer customer2 = new Customer("Amir", "amir@amirabad.com","09102031510","Amirabad");
        Room room2 = new PoorRoom("108",80);
        Reservation res2 = new Reservation(room2,customer2,1);
        

        service.makeReservation(res2, PaymentMethods.INPERSON, Notifier.SMS);
    }
}