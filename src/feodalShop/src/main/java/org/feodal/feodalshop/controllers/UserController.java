package org.feodal.feodalshop.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.feodal.feodalshop.DB;

import static org.feodal.feodalshop.controllers.RegController.md5String;

public class UserController {

    private DB db = new DB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button change_btn;

    @FXML
    private TextField change_email;

    @FXML
    private TextField change_login;

    @FXML
    private PasswordField change_pass;

    private String loginDefault = "Admin";
    private String emailDefault = "admin@feodal.com";
    private String passDefault = "123456";


    @FXML
    void initialize() {
        if(!db.isExistsUser(loginDefault)) {
            db.regUser(loginDefault, emailDefault, md5String(passDefault));
        }
        change_login.setText(loginDefault);
        change_email.setText(db.getEmail(loginDefault));

        change_btn.setOnAction(e -> {
            changeUser();
        });
    }

    private void changeUser() {
        String login = change_login.getText();
        String email = change_email.getText();
        String pass = change_pass.getText();

        db.changeData(login, email, md5String(pass), loginDefault);
        change_login.setText("");
        change_email.setText("");
        change_pass.setText("");
        change_login.setText("Done");
    }
}
