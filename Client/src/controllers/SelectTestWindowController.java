package controllers;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;

public class SelectTestWindowController {
    @FXML
    public ListView<String> testList;

    @FXML
    public void initialize() {
        ObservableList<String> testNames = FXCollections.observableArrayList("1" ,"2", "3", "4");
        testList.setItems(testNames);
    }
}
