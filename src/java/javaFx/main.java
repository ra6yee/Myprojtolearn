package src.java.javaFx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sun.awt.windows.ThemeReader;

public class main extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setResizable(false);
        primaryStage.setTitle("ПРОБНОЕ ОКОНЦЕ");
       VBox root= new VBox(10);
root.setAlignment(Pos.BASELINE_CENTER);
        Scene scene=new Scene(root,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        Label label=new Label("всем меткам метка");
        final Label two=new Label("метка два");

        root.getChildren().add(label);

        root.getChildren().add(two);
      //создаем кнопку
        Button ok=new Button("ok");
 //вводим кнопку в граф сцены
        root.getChildren().add(ok);
  //теперь вызываем метод setAction  и создаем обработчик событий при нажатии на кнопку
        // и получаем анонимный класс
  ok.setOnAction(new EventHandler<ActionEvent>() {
      public void handle(ActionEvent event) {
              two.setText("tup");

      }
  });
   //добавим в конструкцию еще кнопку подтверждения выбора.
        // Создаем кнопки и группу кнопок.
        // Тема будет чай кофе молоко.

    }
}
