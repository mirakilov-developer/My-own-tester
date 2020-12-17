package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import model.Answer;
import model.Question;
import run.Client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AskWindowController {
    List<String> variants = new ArrayList<>();
    String correctVariant = "4";
    private Question que;

    @FXML
    private ToggleGroup toggleGroup;

    @FXML
    public Label counter;

    @FXML
    public Button submit;

    @FXML
    public Label correctVar;

    @FXML
    public Label questionText;

    @FXML
    public RadioButton var1;

    @FXML
    public RadioButton var2;

    @FXML
    public RadioButton var3;

    @FXML
    public RadioButton var4;


    @FXML
    public void initialize() {
        toggleGroup = new ToggleGroup();

        var1.setToggleGroup(toggleGroup);
        var2.setToggleGroup(toggleGroup);
        var3.setToggleGroup(toggleGroup);
        var4.setToggleGroup(toggleGroup);

        variants.addAll(new ArrayList<String> (List.of("2", "3", "4", "7")));
        que = new Question("2*2=?", correctVariant, variants);
        Collections.shuffle(variants);

        questionText.setText("2**2=?");
        var1.setText(variants.get(0));
        var2.setText(variants.get(1));
        var3.setText(variants.get(2));
        var4.setText(variants.get(3));
    }

    @FXML
    public void receiveTests(){

    }

    public void variantClick(MouseEvent mouseEvent) {

    }

    public void sendAnswers(MouseEvent mouseEvent) {
        Client.setStage(Window.SelectTest);

        if (!var1.isSelected() && !var2.isSelected() &&
                !var3.isSelected() && var1.isSelected()) {
            return;
        }

        String answer = "";

        if (var1.isSelected()) answer = var1.getText();
        if (var2.isSelected()) answer = var2.getText();
        if (var3.isSelected()) answer = var3.getText();
        if (var4.isSelected()) answer = var4.getText();

        Answer ans = new Answer(que, answer);

        if (ans.isCorrect()){
            correctVar.setText("It's correct");
        } else correctVar.setText("No, it's not correct, correct variant is " + que.getCorrectVariantStr());

        correctVar.setVisible(true);
    }
}
