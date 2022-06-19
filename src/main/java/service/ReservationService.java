package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReservationService {
    private static ReservationService reservationInstance;
    private Map<String, Reservation> reservations = new HashMap<>();
    private Map<String, IRoom> rooms = new HashMap<>();


    private ReservationService() {}

    public static ReservationService getInstance() {
        if (reservationInstance == null) {
            reservationInstance = new ReservationService();
        }

        return reservationInstance;
    }

    private boolean hasRoom(IRoom room) {
        return rooms.containsKey(room.getRoomNumber());
    }

    private boolean hasReservation(IRoom room) {
        return reservations.containsKey(room.getRoomNumber());
    }

    public void addRoom(IRoom room) {
        //check for room first
        if(!hasRoom(room)) {
            rooms.put(room.getRoomNumber(), room);
        } else {
            throw new IllegalArgumentException("Sorry, that room already exists");
        }
    }

    public IRoom getARoom(String roomId) {
        if(hasRoom(rooms.get(roomId))) {
            return rooms.get(roomId);
        } else {
            throw new IllegalArgumentException("Sorry, there is no room with that id");

        }
    }

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation reservation = new Reservation(customer, room, checkInDate, checkOutDate);
        if(!hasReservation(room)) {
            reservations.put(room.getRoomNumber(), reservation);
            return reservation;
        } else {
            throw new IllegalArgumentException("Sorry, that room is reserved.");
        }
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        //find reserved rooms
        Stream<Reservation> reservationStream = reservations.values().stream()
                .filter(r -> r.getCheckInDate().before(checkInDate) && r.getCheckOutDate().after(checkOutDate));
        Stream<IRoom> freeRooms = reservationStream
                .map(r -> r.getRoom());
        return freeRooms.collect(Collectors.toList());

    }

    public Collection<Reservation> getCustomersReservation(Customer customer) {
        Stream<Reservation> reservationStream = reservations.values().stream();
        Stream<Reservation> customerReservations = reservationStream
                .filter(r -> r.getCustomer().getEmail().equals(customer.getEmail()));

        return customerReservations.collect(Collectors.toList());
    }

    public void printAllReservations() {
        reservations.values()
                        .forEach(System.out::println);
    }
}
