package api;

import service.CustomerService;
import service.ReservationService;

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

}
