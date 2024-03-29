package lk.ijse.dep12.fx.table;

import java.util.List;

public class Employee {
    private String id;
    private String nic;
    private String fullName;
    private String address;
    private String gender;
    private List<String> contactList;
    private String contactStatus;

    public Employee(String id, String nic, String fullName, String address, String gender, List<String> contactList) {
        this.id = id;
        this.nic = nic;
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
        this.contactList = contactList;
    }

    public String getContactStatus(){
        return contactList.isEmpty() ? "NOT AVAILABLE" : "AVAILABLE";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getContactList() {
        return contactList;
    }

    public void setContactList(List<String> contactList) {
        this.contactList = contactList;
    }
}
