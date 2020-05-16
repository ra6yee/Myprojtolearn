package javaFx.checkbox;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
//генерирует поле с галочкой.И поле имеет три состояния.
// Отмечено, не отмечено и неопределенное.
//Приступим
public class checkBx extends Application {
    public static void main(String[] args) {
        launch();
    }
    public void start(Stage primaryStage) throws Exception {
// создаем окно
        primaryStage.setTitle("CheckBox");
        FlowPane flowPane=new FlowPane(10,10);
        flowPane.setAlignment(Pos.CENTER);
        Scene scene=new Scene(flowPane, 230,140);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        // создаем некоторые метки
        Label title=new Label("выберите источник воспроизведения звука");
        final Label bottom=new Label("источник не выбран");
        // содаем разделительную линия
        Separator separator=new Separator();
        separator.setPrefWidth(200);
        // создаем флажки
        final CheckBox disk=new CheckBox("disk");
        final CheckBox flash=new CheckBox("flash");
       final CheckBox radio=new CheckBox("radio");
        // вводим все это в сцену, потом напишем обработчик
        flowPane.getChildren().addAll(title,separator,disk,flash,radio,bottom);
      // в обработчике используем метод isSelected()
        disk.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if (disk.isSelected()) {
                    bottom.setText("выбран " + disk.getText());
                }
            }
                 });
                flash.setOnAction(new EventHandler<ActionEvent>() {
                    public void handle(ActionEvent event) {
                        if (flash.isSelected()) {
                            bottom.setText("выбран " + flash.getText());

                        }
                    }
                    });
                        radio.setOnAction(new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent event) {
                                if (radio.isSelected()) {
                                    bottom.setText("выбран " + radio.getText());
                                }

                            }
                        });
                    }

}