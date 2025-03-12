package org.feodal.feodalshop.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.feodal.feodalshop.DB;
import org.feodal.feodalshop.HelloApplication;

public class FullArticleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button back_btn;

    @FXML
    private Label intro;

    @FXML
    private Label title;

    @FXML
    void initialize() throws SQLException {
        DB db = new DB();
        ResultSet resultSet = db.getOneArticle(ArticlesPanelController.idArticle);
        String titleValue = "";
        String introValue = "";
        while(resultSet.next()) {
            titleValue = resultSet.getString("title");
            introValue= resultSet.getString("text");
        }

        title.setText(titleValue);
        intro.setText(introValue);

        back_btn.setOnAction(event -> {
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            try {
                HelloApplication.setScene("articles-panel.fxml", stage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

}
