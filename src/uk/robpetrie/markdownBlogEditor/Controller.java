package uk.robpetrie.markdownBlogEditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class Controller {

    @FXML private WebView outputView;
    private WebEngine webEngine;

    @FXML private VBox tagsVbx, contentVbx;

    @FXML
    private void initialize() {
//        webEngine = outputView.getEngine();

    }

    private void newItem(String type) {
        ObservableList<String> items =
                FXCollections.observableArrayList(
                        "Heading",
                        "Paragraph"
                );
        final ComboBox itemTypeDrpdwn = new ComboBox(items);
        itemTypeDrpdwn.setValue(type);
        tagsVbx.getChildren().add(itemTypeDrpdwn);
    }

    @FXML
    private void newHeading() {

    }

}