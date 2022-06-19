package api;

import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

public class HotelResource {
    private static HotelResource hotelInstance;
    private static ReservationService reservations = ReservationService.getInstance();
    private static CustomerService customers = CustomerService.getInstance();

    private HotelResource() {}

    public static HotelResource getInstance() {
        if (hotelInstance == null) {
            hotelInstance = new HotelResource();
        }

        return hotelInstance;
    }

    public Customer getCustomer(String email) {
        return customers.getCustomer(email);
    }

    public void createACustomer(String email, String firstName, String lastName) {
        customers.addCustomer(email, firstName, lastName);
    }

    public IRoom getRoom(String roomNumber) {
        return reservations.getARoom(roomNumber);
    }

    public Reservation bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate) {
        return reservations.reserveARoom(customers.getCustomer(customerEmail), room, checkInDate, checkOutDate);
    }

    public Collection<Reservation> getCustomerReservations(String customerEmail) {
        return reservations.getCustomersReservation(customers.getCustomer(customerEmail));
    }

}
