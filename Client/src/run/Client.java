package run;

import javafx.application.Application;
import javafx.stage.Stage;

import static run.Window.*;


public class Client extends Application {
    private static Stage stage;


    @Override
    public void start(Stage stage) {
        Client.stage = stage;

        setStage(Ask);
        stage.show();
    }

    public static void setStage(Window window) {
        stage.setScene(window.getScene());
        stage.setTitle(window.getTitle());
    }


}
