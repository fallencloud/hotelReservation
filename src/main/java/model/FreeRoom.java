package model;

public class FreeRoom extends Room {
    public FreeRoom(String roomNumber, double price, RoomType roomType) {
        super(roomNumber, 0.0, roomType);

    }



    @Override
    public String toString() {
        return "FreeRoom{" +
                "roomNumber: " + super.getRoomNumber() + "\n" +
                "price: " + super.getRoomPrice() + "\n" +
                "roomType: " + super.getRoomType() + "\n" +
                '}';
    }
}
