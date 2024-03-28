package lk.ijse.dep12.fx.table;

import javafx.scene.control.Button;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private String address;
    private List<String> contactList;

    public Customer(int id, String name, String address, List<String> contactList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactList = contactList;
    }

    public String getId(){
        return "C%03d".formatted(id);
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

//    public Button getName(){
//        return new Button("DELETE");
//    }
}
