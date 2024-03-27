package lk.ijse.dep12.fx.validation;

public class Employee {
    private String id;
    private String name;
    private String address;
    private String country;
    private String gender;

    public Employee(String id, String name, String address, String country, String gender) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.country = country;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getGender() {
        return gender;
    }
}
