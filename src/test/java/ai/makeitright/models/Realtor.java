package ai.makeitright.models;

public class Realtor {
    private String Name;
    private String PhoneNumber;
    private String City;
    private String State;

    public Realtor(String name, String phoneNumber, String city, String state) {
        this.Name = name;
        this.PhoneNumber = phoneNumber;
        this.City = city;
        this.State = state;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    @Override
    public String toString() {
        return "Realtor{" +
                "Name='" + Name + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                '}';
    }
}
