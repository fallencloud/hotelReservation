package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    private static ReservationService reservationInstance;
    private Set<Reservation> reservations = new HashSet<>();
    private Set<Room> rooms = new HashSet<>();


    private ReservationService() {}

    public static ReservationService getInstance() {
        if (reservationInstance == null) {
            reservationInstance = new ReservationService();
        }

        return reservationInstance;
    }

    public void addRoom(IRoom room) {
        rooms.add((Room) room);
    }

    public IRoom getARoom(String roomId) {
        rooms.forEach(room -> {
            if(room.getRoomNumber().equals(roomId)) {
                return room;
            }
        });
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        reservations.add(reservation);
        return reservation;
    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        List<Reservation> customerReservation = new ArrayList<>();

        reservations.forEach(reservation -> {
            if(reservation.getCustomer().equals(customer)) {
                customerReservation.add(reservation);
            }
        });

        return customerReservation;
    }

    public void printAllReservations() {
        reservations.forEach(reservation -> System.out.println(reservation);
    }
}
