package Booking;

import Vehicle.Vehicle;
import common.Location;
import common.User;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Booking {

    int id;
    BookingStatus status;
    Vehicle vehicle;
    LocalDateTime bookingTime;
    User user;
    Location bookingLocation;
    LocalDateTime bookingStartTime;
    LocalDateTime bookingEndTime;

    public Booking(int id, Vehicle vehicle, User user, Location bookingLocation) {
        this.id = id;
        this.vehicle = vehicle;
        this.user = user;
        this.status = BookingStatus.BOOKED;
        this.bookingTime = LocalDateTime.now();
        this.bookingLocation = bookingLocation;
    }

    public int getId() {
        return id;
    }

    public void scheduleBooking(LocalDateTime startTime, LocalDateTime endTime) {
        this.bookingStartTime = startTime;
        this.bookingEndTime = endTime;
        this.status = BookingStatus.SCHEDULED;
    }

    public Location getBookingLocation() {
        return this.bookingLocation;
    }

    public LocalDate startDate() {
        return bookingStartTime.toLocalDate();
    }

    public LocalDate endDate() {
        return bookingEndTime.toLocalDate();
    }

}
