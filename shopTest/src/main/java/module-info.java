module test.example.shoptest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires mysql.connector.java;

    opens test.example.shoptest to javafx.fxml;
    exports test.example.shoptest;
    exports test.example.shoptest.control;
    opens test.example.shoptest.control to javafx.fxml;
}