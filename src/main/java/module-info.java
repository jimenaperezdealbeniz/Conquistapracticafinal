module com.example.conquistapracticafinal {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.conquistapracticafinal to javafx.fxml;
    exports com.example.conquistapracticafinal;
}