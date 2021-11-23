package src.java.javaFx.listview;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//лист отображает данные  в окне, берет из из коллекции.
//может отображать как один элемент, так и несколько
// зависит от выбора модели отбражения getSelection model
// обобщен. Можно завернуть любой лист в observableList.
// будут отслеживаться изменения в листе.
public class main extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("ListView");
        FlowPane flowPane=new FlowPane(10,10);//это промежутки между элементами
        Scene scene=new Scene(flowPane,400,400);
        primaryStage.setScene(scene);
        primaryStage.show();
        flowPane.setAlignment(Pos.CENTER);
        // begining the magic:
      final Label label=new Label("выберите объект");
        flowPane.getChildren().add(label);
        // создаем список элементов
        ObservableList<String>listOfObjects= FXCollections.observableArrayList("дерево",
                "трава","цветы","ягоды","грибы");
        //и теперь создаем тот самый листвью,
        // в котором и будет отображться  наш лист
        ListView<String> listView=new ListView<String>(listOfObjects);
        //задаем предпочтительные размеры отображения
        listView.setPrefSize(80,80);
        //получаем ту самую модель выбора отображения
        // единичная или множественная
        MultipleSelectionModel<String>multipleSelectionModel=listView.getSelectionModel();
        //вводим приемник событий изменений,
        //чтобы реагировать на выбор элементов в
        //представлении списка
        multipleSelectionModel.selectedItemProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                label.setText("выбранный объект: "+newValue);

            }
        });
        flowPane.getChildren().add(listView);
    }
}
