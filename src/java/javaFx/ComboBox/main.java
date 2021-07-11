package src.java.javaFx.ComboBox;
//комбобокс-это такой как бы список, но раскрывающийся.
//имеется возможность пользователя редактировать список
// но тут строго можно выбрать одновременно только один пункт списка.
//Генерирует событие действия, когда в нем изменяетя элемент списка.
// Но можно и проигнорировать это событие,аполучить просто элемент списка по мере надобности
//метод getValue позволяет получить выбранный в данный момент элемент списка
// если значения нет, то вернется null
// можно и установить новое значение методом getValue.
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class main extends Application {
    ComboBox<String>comboBox;
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        //создаем окошко
        primaryStage.setTitle("комбобоксы");
        FlowPane flowPane=new FlowPane(10,10);
        Scene scene=new Scene(flowPane,400,400);
         flowPane.setAlignment(Pos.CENTER);
         primaryStage.setScene(scene);
         primaryStage.show();
         primaryStage.setResizable(false);
//создаем список observableList, который и будет отображаться
        ObservableList<String>observableList= FXCollections.observableArrayList("раз","два","три","четыре");
 // создаем тот самый комбобокс
       comboBox=new ComboBox<String>(observableList);
        //устанавливаем ззначение по умолчанию
        comboBox.setValue("четыре");
        final Label label=new Label("выберите число");
        // а теперь пишем обработчик
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label.setText( "выбранное число "+ comboBox.getValue());
            }
        });
    //вводим все это в граф сцены
    flowPane.getChildren().addAll(comboBox,label);
    // можно разрешить редактировать элементы списка вот так
        comboBox.setEditable(true);
            }
}
