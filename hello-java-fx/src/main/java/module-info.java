module lk.ijse.dep12.hellojavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens lk.ijse.dep12.hellojavafx to javafx.fxml;
    exports lk.ijse.dep12.hellojavafx;
}