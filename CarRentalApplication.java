import Booking.Booking;
import Vehicle.Vehicle;
import common.BookingSystem;
import common.Location;
import common.Store;
import common.User;
import Vehicle.VehicleType;

public class CarRentalApplication {

    public static void main(String[] args) {
        User aman = new User(1, "AMAN");
        User jeet = new User(2, "JEET");

        Location hauzKhas = new Location(1, "Hauz Khas", "Delhi", "Delhi", "110016");
        Location bandra = new Location(2, "Bandra", "Mumbai", "Maharashtra", "111111");

        Store store1 = new Store(1, hauzKhas);
        Store store2 = new Store(2, bandra);

        Vehicle sonet = new Vehicle(1, "DL111", VehicleType.CAR);
        Vehicle venue = new Vehicle(2, "MH111", VehicleType.CAR);
        Vehicle pulsar = new Vehicle(3, "MH222", VehicleType.BIKE);

        store1.addVehicle(sonet);
        store2.addVehicle(venue);
        store2.addVehicle(pulsar);

        BookingSystem bookingSystem = new BookingSystem();

        bookingSystem.addUser(aman);
        bookingSystem.addUser(jeet);

        bookingSystem.addStore(store1);
        bookingSystem.addStore(store2);

        Booking b1 = bookingSystem.createBooking(1, VehicleType.CAR, bandra, jeet);
        Booking b2 = bookingSystem.createBooking(2, VehicleType.BIKE, hauzKhas, aman);
        bookingSystem.scheduleBooking(b1);
    }
}
