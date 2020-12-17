package controllers;

public enum Windows {
    Ask("/resources/SelectTestWindow.fxml"),
    SelectTest("/resources/AskWindow.fxml");

    public final String path;

    Windows(String path) {
        this.path = path;
    }
}
