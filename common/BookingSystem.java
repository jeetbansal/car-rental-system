package common;

import Booking.Booking;
import Vehicle.Vehicle;
import Vehicle.VehicleType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    List<Store> stores;
    List<User> users;

    public BookingSystem() {
        stores = new ArrayList<>();
        users = new ArrayList<>();
    }

    public List<Store> getStores() {
        return stores;
    }

    public List<User> getUsers() {
        return users;
    }

    public void addStore(Store store) {
        stores.add(store);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Booking createBooking(int id, VehicleType type, Location location, User user) {
        Store targetStore = stores.stream().filter(store -> store.getLocation().equals(location)).findFirst().get();
        Vehicle vehicle = targetStore.checkAvailabilityOfVehicle(type);
        if (vehicle != null) {
            Booking booking = new Booking(id, vehicle, user, location);
            targetStore.addBooking(booking);
            System.out.println("Created booking for " + user.getName() + " at " + location.getName() + " location");
            System.out.println("Vehicle number: " + vehicle.getNumber());
            return booking;
        }
        else {
            System.out.println("Vehicle of type " + type + " not available at " + location.getName() + " location. Try some other location or vehicle");
        }
        return null;
    }

    public void scheduleBooking(Booking booking) {
        Store targetStore = stores.stream().filter(store -> store.getLocation().equals(booking.getBookingLocation())).findFirst().get();
        targetStore.removeBooking(booking);
        booking.scheduleBooking(LocalDateTime.now().plusDays(2), LocalDateTime.now().plusDays(5));
        targetStore.addBooking(booking);
        System.out.println("Scheduled booking with id: " + booking.getId() + " from " + booking.startDate().toString() + " to " + booking.endDate().toString());
    }

}
