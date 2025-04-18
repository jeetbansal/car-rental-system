package common;

import Booking.Booking;
import Vehicle.Vehicle;
import Vehicle.VehicleType;
import Vehicle.VehicleStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Store {

    int id;
    Location location;
    List<Booking> bookings;
    List<Vehicle> vehicles;

    public Store(int id, Location location) {
        this.id = id;
        this.location = location;
        bookings = new ArrayList<>();
        vehicles = new ArrayList<>();
    }

    public Location getLocation() {
        return this.location;
    }

    public Vehicle checkAvailabilityOfVehicle(VehicleType vehicleType) {
        Optional<Vehicle> v = vehicles.stream().filter(vehicle -> vehicle.getType().equals(vehicleType) && vehicle.getStatus().equals(VehicleStatus.ACTIVE) && (!vehicle.isBooked())).findFirst();
        if (v.isPresent()) {
            return v.get();
        }
        return null;
    }
    public void addBooking(Booking booking) {
        bookings.add(booking);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

}
