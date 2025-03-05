module org.feodal.feodalshop {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;


    opens org.feodal.feodalshop to javafx.fxml;
    exports org.feodal.feodalshop;
    exports org.feodal.feodalshop.controllers;
    opens org.feodal.feodalshop.controllers to javafx.fxml;
}