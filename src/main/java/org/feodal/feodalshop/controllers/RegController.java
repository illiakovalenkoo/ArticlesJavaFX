package org.feodal.feodalshop.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.feodal.feodalshop.DB;
import org.feodal.feodalshop.HelloApplication;
import org.feodal.feodalshop.models.User;

public class RegController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button auth_btn;

    @FXML
    private TextField auth_login;

    @FXML
    private PasswordField auth_pass;

    @FXML
    private Button reg_btn;

    @FXML
    private TextField reg_email;

    @FXML
    private TextField reg_login;

    @FXML
    private PasswordField reg_pass;

    @FXML
    private CheckBox reg_rights;

    private DB db = new DB();

    @FXML
    void initialize() {
       reg_btn.setOnAction(event -> {
          registrationUser();
       });

        auth_btn.setOnAction(event -> {
            try {
                authUser(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        
    }

    private void authUser(ActionEvent event) throws IOException {
        String login = auth_login.getCharacters().toString();
        String pass = auth_pass.getCharacters().toString();

        auth_login.setPromptText("Enter login");
        auth_login.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");
        auth_pass.setPromptText("Enter password");
        auth_pass.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");

        if(!db.authUser(login, md5String(pass))) {
            auth_btn.setText("No such user");
            wrongData(auth_login);
            wrongData(auth_pass);
            auth_login.setPromptText("Wrong login OR");
            auth_pass.setPromptText("Wrong password");
        }
        else {
            auth_login.setText("");
            auth_pass.setText("");
            auth_btn.setText("Все готово :)");

            FileOutputStream fos = new FileOutputStream("user.settings");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new User(login));
            oos.close();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            HelloApplication.setScene("articles-panel.fxml", stage);
        }
    }

    private void registrationUser() {
        String login = reg_login.getCharacters().toString();
        String email = reg_email.getCharacters().toString();
        String pass = reg_pass.getCharacters().toString();

        reg_login.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");
        reg_email.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");
        reg_pass.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");
        reg_login.setPromptText("Enter login");
        reg_email.setPromptText("Enter email");
        reg_pass.setPromptText("Enter password");

        if(login.length() < 5) {
            reg_login.setPromptText("Login is too short");
            wrongData(reg_login);
        }
        else if(email.length() < 5) {
            reg_email.setPromptText("Email is too short");
            wrongData(reg_email);

        } else if(!email.contains("@")) {
            reg_email.setPromptText("Email doesn't contain @");
            wrongData(reg_email);

        } else if(!email.contains(".")) {
            reg_email.setPromptText("Email doesn't contain .");
            wrongData(reg_email);

        }
        else if(pass.length() < 8) {
            reg_pass.setPromptText("Password is too short");
            wrongData(reg_pass);
        }
        else if(!reg_rights.isSelected())
            reg_btn.setText("Please confirm");
        else if(db.isExistsUser(login)) {
            reg_login.setText("Please enter another login");
            wrongData(reg_login);
        }
        else {
            db.regUser(login, email, md5String(pass));
            reg_login.setText("");
            reg_email.setText("");
            reg_pass.setText("");
            reg_btn.setText("Done");
        }
    }

    public static String md5String(String pass) {
        MessageDigest messageDigest = null;
        byte[] digest = new byte[0];

        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(pass.getBytes());
            digest = messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        BigInteger bigInteger = new BigInteger(1, digest);
        String md5Hex = bigInteger.toString(16);

        while (md5Hex.length() < 32) {
            md5Hex = "0" + md5Hex;
        }
        return md5Hex;
    }

    public static void wrongData(TextField tf) {
        tf.clear();
        tf.setStyle("-fx-border-color: #E06249; -fx-prompt-text-fill: #E06249;");
    }

    public static void wrongData(TextArea ta) {
        ta.clear();
        ta.setStyle("-fx-border-color: #E06249; -fx-prompt-text-fill: #E06249;");
    }
}
