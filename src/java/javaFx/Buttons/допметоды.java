package src.java.javaFx.Buttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class допметоды extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("metods");
        BorderPane borderPane=new BorderPane();
        Scene scene=new Scene(borderPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        Button button=new Button("experience");
        borderPane.setTop(button);
        final Label label=new Label("text");
        button.setBlendMode(BlendMode.DARKEN);//метод накладывает кнопку на сцену позади него. бррр
        // можно  наложить на кнопку маску в виде какой то фигуры и кнопка будет выгдядеть этой фигурой.
      //  Circle circle=new Circle(10,10,30);
       // button.setClip(circle);
//        label.setLayoutX(10);
//        label.setLayoutY(10);
     borderPane.getChildren().add(label);
     //   borderPane.setTop(label);
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label.setText("pressed");
            }
        });
        button.setFocusTraversable(true);// можно фокус перемещать с помощью стрелочек на клавиатуре и клавиши таб
button.setMouseTransparent(true);// кнопка активируется только с помощью клавиатуры
 button.setContentDisplay(ContentDisplay.CENTER);//Определяет расположение текста относительно кнопки.
  button.setUnderline(true);// подчеркивает текст кнопки
        button.setWrapText(true);// переносит непомещающийсяя текст на другую строку
        button.setCancelButton(true);//кнопка будет активироваться клавишей эскейп, а не клавишей энтер
    }
}
