module com.mycompany.steamproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.mycompany.steamproject to javafx.fxml;
    exports com.mycompany.steamproject;
}
