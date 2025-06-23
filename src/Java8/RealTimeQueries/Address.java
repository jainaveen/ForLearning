package Java8.RealTimeQueries;

public class Address {

    int pincode;
    String city;
    String state;

    public Address(int pincode, String city, String state) {
        this.pincode = pincode;
        this.city = city;
        this.state = state;
    }

    public int getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
