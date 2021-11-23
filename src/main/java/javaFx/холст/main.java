package src.java.javaFx.холст;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// для графики нужно создать холст canvas и создать объект класса
//GraphicsContext,  он является node, можно ввести в граф сцены
public class main extends Application {
    public static void main(String[] args) {
        launch();
    }
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Графика примеры");
        // используем панель поточной компановки flowPanel
        FlowPane rootPane=new FlowPane();
        //создаем сцену, вводим в нее панель и задаем размеры окна по умолчанию
        Scene scene=new Scene(rootPane,500,500);
        // загоняем сцену на подмостки
        primaryStage.setScene(scene);
        primaryStage.show();
        //создаем холст
        Canvas canvas=new Canvas(400,400);
        //создаем объект класса graphicsContext
        // и вызываем метод, нужный для получения объекта .getGraphicsContext2D();
// у холста!!!
        GraphicsContext gs=canvas.getGraphicsContext2D();
        // теперь можно рисовать на этом холсте
        gs.strokeLine(0,0,400,400); //линия , диагональ по холсту
        //добавим еще рисунок овал или круг
        gs.strokeOval(0,0,400,400);
//добавим вторую диагональ
        gs.strokeLine(0,400,400,0);

        //добавим надпись в холст
        gs.setFont(new Font(20));// меняем размер шрифта
        gs.strokeText("Это пробный холст для графики",105,30);

           // теперь вводим холст в граф сцены
       rootPane.getChildren().add(canvas);
       // выровним по центру
       rootPane.setAlignment(Pos.CENTER);

    }
}
