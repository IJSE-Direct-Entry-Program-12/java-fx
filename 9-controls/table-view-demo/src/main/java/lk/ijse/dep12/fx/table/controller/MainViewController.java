package lk.ijse.dep12.fx.table.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.dep12.fx.table.Customer;

import java.util.List;

public class MainViewController {
    public TableView<Customer> tblCustomer;
    public Button btnDelete;

    public void initialize(){
        btnDelete.setDisable(true);
        ObservableList<Customer> customerList = tblCustomer.getItems();

        tblCustomer.getSelectionModel().selectedItemProperty()
                .addListener((observable, previous, current) -> {
            btnDelete.setDisable(current == null);
        });

        //System.out.println(tblCustomer.getColumns().get(0).getCellFactory());
        //System.out.println(tblCustomer.getColumns().get(0).getCellValueFactory());

        tblCustomer.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomer.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomer.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        customerList.add(new Customer(1, "Kasun", "Galle", List.of("077-1234567")));
        customerList.add(new Customer(2, "Nuwan", "Matara", null));
        customerList.add(new Customer(3, "Supun", "Panadura",
                List.of("077-1234567", "011-1234657", "078-1234567")));
        customerList.add(new Customer(4, "Ruwan", "Moratuwa", List.of("011-4567891")));
    }


    public void btnDeleteOnAction(ActionEvent actionEvent) {
        ObservableList<Customer> customerList = tblCustomer.getItems();

        customerList.remove(tblCustomer.getSelectionModel().getSelectedItem());
        tblCustomer.getSelectionModel().clearSelection();
    }
}
