module com.example.tinhtong {
    requires javafx.controls;
    requires javafx.fxml;
  requires java.desktop;


  opens com.example.tinhtong to javafx.fxml;
    exports com.example.tinhtong;
}