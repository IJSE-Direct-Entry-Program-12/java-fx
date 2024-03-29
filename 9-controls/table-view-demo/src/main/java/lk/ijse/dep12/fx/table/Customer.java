package lk.ijse.dep12.fx.table;

import java.util.List;

public class Customer {
    private final int id;
    private final String name;
    private final String address;
    private final List<String> contactList;

    public Customer(int id, String name, String address, List<String> contactList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactList = contactList;
    }

    public String getId() {
        return "C%03d".formatted(id);
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

//    public Button getName(){
//        return new Button("DELETE");
//    }
}
