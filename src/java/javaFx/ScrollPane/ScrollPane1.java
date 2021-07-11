package src.java.javaFx.ScrollPane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//прокрутка принудительно
// так же можно указать где  будут полосы прокрутки
public class ScrollPane1 extends Application {
    public static void main(String[] args) {
        launch();
    }
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("scroll");
        BorderPane borderPane=new BorderPane();
        Scene scene=new Scene(borderPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
      //  primaryStage.setResizable(false);
        Label label=new Label(
                "A scrollPane streamlines the process of\n"+
                        "adding scroll bars to a windows whose \n"+
                        "content exceed the windows dimensions.\n "+
                        "It also enables a control to fit in a\n"+
                        "smaller space than it otherwise would.\n"
        );
    //создаем полосу прокрутки
        ScrollPane scrollPane=new ScrollPane(label);
        scrollPane.setPrefViewportHeight(80);
        scrollPane.setPrefViewportWidth(130);
               borderPane.setTop(scrollPane);
    }

}
