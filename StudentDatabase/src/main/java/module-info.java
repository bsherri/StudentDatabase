module com.example.studentdatabase {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.studentdatabase to javafx.fxml;
    exports com.example.studentdatabase;
}