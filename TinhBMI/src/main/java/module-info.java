module com.example.tinhbmi {
  requires javafx.controls;
  requires javafx.fxml;
  requires java.desktop;


  opens com.example.tinhbmi to javafx.fxml;
  exports com.example.tinhbmi;
}