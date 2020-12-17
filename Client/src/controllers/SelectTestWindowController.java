package controllers;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Test;
import model.TestLine;
import service.TestLibrary;

import java.util.ArrayList;


public class SelectTestWindowController {

    @FXML
    public TableColumn<TestLine, String> testNameCol;

    @FXML
    public TableColumn<TestLine, Integer> queNumbersCol;

    @FXML
    public TableView<TestLine> testTable;

    @FXML
    public void initialize(){

        ArrayList<TestLine> testLinesArr = new ArrayList<>();
        for (int i = 0; i < TestLibrary.getLibrarySize(); i++) {
            testLinesArr.add(new TestLine(TestLibrary.getTestFromIndex(i)));
        }

        ObservableList<TestLine> lines = FXCollections.observableArrayList(testLinesArr);
        testNameCol.setCellValueFactory(new PropertyValueFactory<>("testName"));
        queNumbersCol.setCellValueFactory(new PropertyValueFactory<>("numberOfQuestions"));

        testTable.setItems(lines);


    }
}
