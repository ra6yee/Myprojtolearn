package javaFx.TreeView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class treeViewClass extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Дерево");
        BorderPane borderPane=new BorderPane();
        Scene scene=new Scene(borderPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
