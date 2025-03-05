package org.feodal.feodalshop.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.feodal.feodalshop.DB;
import org.feodal.feodalshop.HelloApplication;

public class AddArticleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea full_text_field;

    @FXML
    private TextArea intro_field;

    @FXML
    private TextField title_field;

    @FXML
    void addArticle(ActionEvent event) {

        String title= title_field.getCharacters().toString();
        String intro = intro_field.getText();
        String fullText = full_text_field.getText();

        title_field.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");
        intro_field.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");
        full_text_field.setStyle("-fx-border-color: #FAFAFA; -fx-prompt-text-fill: gray;");

        title_field.setPromptText("Enter title");
        intro_field.setPromptText("Enter teaser");
        full_text_field.setPromptText("Enter full text");

        if(title.length() < 5) {
            RegController.wrongData(title_field);
            title_field.setPromptText("Title is too short");
        }
        else if(intro.length() < 10) {
            RegController.wrongData(intro_field);
            intro_field.setPromptText("Teaser is too short");
        }
        else if(fullText.length() < 20) {
            RegController.wrongData(full_text_field);
            full_text_field.setPromptText("Full text is too short");
        }
        else {
            DB db = new DB();
            db.addArticle(title, intro, fullText);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("articles-panel.fxml", stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @FXML
    void initialize() {

    }

}
