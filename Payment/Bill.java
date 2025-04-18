package Payment;

import Booking.Booking;

public class Bill {

    int id;
    Booking booking;

    public Bill(int id, Booking booking) {
        this.id = id;
        this.booking = booking;
    }
}
