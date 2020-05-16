package javaFx.TextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
//используется для ввода пользовательских данных
// наследуется от TextInputControl
// если необходимо указать явно размеры,
// то используется метод setPrefColumnCount()
// для указания первичного текста в поле setText
// для получения текста из поля getText
// для подсказки используем setPromptText()
//после нажания на энтер генерируется  событие действия
// в этой программе принаведении фокуса на полеи нажимается энтер
// или нажимает на кнопку пдтвержения, введенная строка считывается и отображается.
public class txtfield extends Application {
    public static void main(String[] args) {
launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TextField");
        FlowPane flowPane=new FlowPane(10,10);//это промежутки между элементами
        Scene scene=new Scene(flowPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        flowPane.setAlignment(Pos.CENTER);
        final Label find=new Label("Search info: ");
        Button getInfo=new Button("Get info");
        //создаем текстовое поле
        final TextField textField =new TextField();
        //создаем подсказку
        textField.setPromptText("enter the string of searching");
        // задаем предпочтительное количество столбцов
        textField.setPrefColumnCount(10);
        //пишем обработчик
        textField.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                find.setText(find.getText()+textField.getText());
            }
        });
        getInfo.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
            //    find.setText();
                find.setText("Search info:"+textField.getText());
            }
        });
flowPane.getChildren().addAll(textField,getInfo,find);
    }
}
