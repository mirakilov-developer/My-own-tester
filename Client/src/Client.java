import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Client extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/resources/ClientWindow.fxml"));
        Scene scene= new Scene(root, 300, 275);
        stage.setScene(scene);
        stage.setTitle("Tester 0.0.01");
        stage.show();
    }
}
