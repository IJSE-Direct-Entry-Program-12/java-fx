package lk.ijse.dep12.fx.controls.controller;

import javafx.collections.ObservableList;
import javafx.scene.control.*;
import lk.ijse.dep12.fx.controls.Customer;

public class Demo2ViewController {
    public ListView<Customer> lstView1;
    public ListView<CheckBox> lstView2;
    public ComboBox<Customer> cmb1;
    public ComboBox<Button> cmb2;

    public void initialize() {
        ObservableList<Customer> customerList1 = lstView1.getItems();
        ObservableList<Customer> customerList2 = cmb1.getItems();

        customerList1.add(new Customer(1, "Kasun", "Galle"));
        customerList1.add(new Customer(2, "Nuwan", "Panadura"));
        customerList1.add(new Customer(3, "Ruwan", "Matara"));
        customerList1.add(new Customer(4, "Supun", "Moratuwa"));
        customerList2.addAll(customerList1);

        ObservableList<CheckBox> checkBoxList = lstView2.getItems();
        checkBoxList.add(new CheckBox("My Check Box 1"));
        checkBoxList.add(new CheckBox("My Check Box 2"));
        checkBoxList.add(new CheckBox("My Check Box 2"));

        ObservableList<Button> buttonList = cmb2.getItems();
        buttonList.add(new Button("Button 1"));
        buttonList.add(new Button("Button 2"));
        buttonList.add(new Button("Button 3"));
    }

}
