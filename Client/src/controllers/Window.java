package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

public enum Window {
    Ask("/resources/AskWindow.fxml", "Ask", 700, 500),
    SelectTest("/resources/SelectTestWindow.fxml","SelectTest", 700, 500);

    private Scene scene;
    private final String path;
    private final int height;
    private final int width;

    private final String title;

    Window(String path, String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
        this.path = path;

        try {
            this.scene = initScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {

        return scene;
    }

    public String getTitle() {
        return title;
    }

    private Scene initScene() throws IOException {
        Parent root = FXMLLoader.load(run.Client.class.getResource(path));
        return new Scene(root, width, height);
    }

    private void refreshScene() {
        try {
            scene = initScene();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
