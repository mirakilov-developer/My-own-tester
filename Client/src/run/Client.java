package run;

import controllers.Window;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import static controllers.Window.*;


public class Client extends Application {
    private static Stage stage;
    private static Scene scene;


    @Override
    public void start(Stage stage) {
        Client.stage = stage;

        setStage(Ask);
        stage.show();
    }

    private static void setScene(Window window) {
        scene = window.getScene();

    }

    public static void setStage(Window window) {
        setScene(window);

        stage.setScene(scene);
        stage.setTitle(window.getTitle());
    }


}
