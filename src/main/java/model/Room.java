package model;

public class Room implements IRoom{
    private String roomNumber;
    private double price;
    private RoomType roomType;
    private boolean isFree;


    public Room(String roomNumber, double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
        isFree = false;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber='" + roomNumber + '\'' +
                ", price=" + price +
                ", roomType=" + roomType +
                '}';
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return isFree;
    }

    public boolean isFree(boolean isFree) {
        this.isFree = isFree;
        return isFree;
    }
}
