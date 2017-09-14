package uk.robpetrie.markdownBlogEditor;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Controller {

    @FXML private WebView outputView;
    private WebEngine webEngine;

    @FXML private VBox tagsVbx, contentVbx;

    @FXML
    private void initialize() {
//        webEngine = outputView.getEngine();

        String testMkDwn = "# This is a test\n";
        String output = "";

        output = checkChars(testMkDwn);

        System.out.println(output);

    }

    private String checkChars(String strToCheck) {
        
        Deque<String> tagStack = new ArrayDeque<String>();
        String result = "";
        
        for (int i = 0; i < strToCheck.length(); i++) {

            if ( i < strToCheck.length()-1 && ((Character.toString(strToCheck.charAt(i)) + Character.toString(strToCheck.charAt(i+1))).equals("# ")) ) {
            tagStack.push("</h1>");
            result += "<h1>";
        } else if (strToCheck.charAt(i) == '\n') {
            result += tagStack.pop();
        } else if(tagStack.isEmpty()) {
            tagStack.push("</p>");
            result += "<p>";
        } else {
            result += strToCheck.charAt(i);
        }
            
        }

        return result;

    }


}