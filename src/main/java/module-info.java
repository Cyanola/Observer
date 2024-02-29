module com.example.observer_ {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.observer_ to javafx.fxml;
    exports com.example.observer_;
}