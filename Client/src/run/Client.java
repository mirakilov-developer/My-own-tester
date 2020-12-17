import controllers.Window;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static controllers.Window.*;


public class Client extends Application {
    private static Scene scene;


    @Override
    public void start(Stage stage) throws IOException {
        setScene(Ask);
        stage.setScene(scene);
        stage.setTitle("Tester 0.0.01");
        stage.show();
    }

    private static void setScene(Window window) {
        scene = window.getScene();
    }


}
