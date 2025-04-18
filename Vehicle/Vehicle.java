package Vehicle;

public class Vehicle {

    int id;
    String number;
    VehicleType type;
    VehicleStatus status;
    Boolean isBooked;

    public Vehicle(int id, String number, VehicleType type) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.status = VehicleStatus.ACTIVE;
        this.isBooked = false;
    }

    public VehicleType getType() {
        return type;
    }
    public void book() {
        this.isBooked = true;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public VehicleStatus getStatus() {
        return this.status;
    }

    public void setStatus(VehicleStatus status) {
        this.status = status;
    }

    public String getNumber() {
        return number;
    }
}
