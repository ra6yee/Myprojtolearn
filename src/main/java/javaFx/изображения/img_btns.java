package javaFx.изображения;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


//используется класс image и класс imageView.
//можно загружать изображение из потока типа inputstream
//воспроизведение изображение посредством класса imageview,
//является потомком node, можно ввести в граф сцены
public class img_btns  extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("изображения в окнах");
        //поточная панель
        FlowPane flowPane = new FlowPane();
        // создаем сцену
        Scene scene=new Scene(flowPane,500,500);
        //устанавливаем сцену на подмостки
        primaryStage.setScene(scene);
        //
        primaryStage.show();
      //  primaryStage.setResizable(false);
        Image img=new Image("image/one.jpg");
       //.юполучаем изображение и вводим его в окно через граф сцены.
        ImageView imageView=new ImageView(img);
        flowPane.getChildren().add(imageView);
         flowPane.setAlignment(Pos.BASELINE_CENTER);
    // теперь вводим изобрежние в метке
        // сначала создадим node изображения , которое вводим в метку
        ImageView lab= new ImageView("image/two.png");
        Label label= new Label("Привет мир!",lab);
        flowPane.getChildren().add(label);
    // и введем картинку в кнопку
        ImageView btnImg=new ImageView("image/three.jpg");
        Button btn=new Button("OK",btnImg);
//и загоняем кнопку в граф сцены
        flowPane.getChildren().add(btn);
        //можно изменить положение надписи
        // посредством setContentDisplay. В классе ContentDisplay
        //находятся константы с указанием места расположения РИСУНКА!!!
        btn.setContentDisplay(ContentDisplay.TOP);
        // можно оставить только изображение
     //ю.   btn.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
    }
}
