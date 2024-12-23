module com.example.dsahw3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.dsahw3 to javafx.fxml;
    exports com.example.dsahw3;
}