package common;

public class Location {

    int id;
    String name;
    String city;
    String state;
    String pinCode;

    public Location(int id, String name, String city, String state, String pinCode) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getName() {
        return name;
    }
}
