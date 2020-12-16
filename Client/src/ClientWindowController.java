import com.sun.javafx.scene.control.behavior.ListCellBehavior;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;


public class ClientWindowController {
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

    public void variantClick(MouseEvent mouseEvent) {
        if (var1.isSelected()) {
            var2.setSelected(false);
            var3.setSelected(false);
            var4.setSelected(false);
        } else if (var2.isSelected()) {
            var1.setSelected(false);
            var3.setSelected(false);
            var4.setSelected(false);
        } else if (var3.isSelected()) {
            var2.setSelected(false);
            var1.setSelected(false);
            var4.setSelected(false);
        } else if (var4.isSelected()) {
            var2.setSelected(false);
            var3.setSelected(false);
            var1.setSelected(false);
        }
    }

    public void sendAnswers(MouseEvent mouseEvent) {

    }
}
