package src.java.javaFx.Buttons;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//создание и работа с кнопками
public class buttons extends Application {
    public static void main(String[] args) {
launch();
    }

    public void start(Stage primaryStage) throws Exception {
      //создание простого окна
       primaryStage.setTitle("кнопки разные");
        final FlowPane flowPane =new FlowPane(10,10);
        VBox vBox=new VBox();
       Scene scene=new Scene(flowPane,400,400);
       primaryStage.setScene(scene);
       primaryStage.show();
       // создаем простую кнопку
        final Button button=new Button("Button");
        //вводим ее в граф сцены
        flowPane.getChildren().add(button);
        // выведем ее на центр
        flowPane.setAlignment(Pos.CENTER);

        //теперь обработаем нажатие на кнопку
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                Label label=new Label("Button ON");

                flowPane.getChildren().add(label);
             //   flowPane.getChildren().remove(label);

            }
        });
//создаем кнопку toggle.Это кнопка с фиксированным нажатием.
//для проверки состояния используется метод isSelected.
// если нажата-true, если отжата-false.
//проверять в обработчике кнопки
        final ToggleButton toggleButton=new ToggleButton("Toggle");
       // flowPane.setAlignment(Pos.BASELINE_LEFT);
        final Label label=new Label();

        flowPane.getChildren().add(toggleButton);
       // flowPane.setAlignment(Pos.BASELINE_LEFT);
        flowPane.getChildren().add(label);
        toggleButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                //проверяем нажатие на кнопку
                if(!toggleButton.isSelected()){
                   label.setText("unpressed");
                }else label.setText("pressed");
            }
        });

        //RadioButton это группа кнопок из которых можно выбрать
        // и нажать на одну. Используется для выбора только одного варианта
        //из нескольких.
        // В принципе это кнопки Toggle , которые объединены в одну группу.
        // ToggleGroup.setToggleGroup.Как только кнопки в этой группе, активизируется
        // режим их исключительно включения только одной.
        // Для выбираемой кнопки можно вызывать метод setSelect().
        // Если параметр состояния выбирается true, то кнопка выбираеся, в ином случае нет.
        //для первоначального выбора кнопкиЮ выбирается метод fire().

        //выбор транспортного средства.Программа.
//создаем три радиокнопки
        RadioButton air=new RadioButton("Airplane");
        RadioButton car=new RadioButton("Car");
        RadioButton train=new RadioButton("Train");
        // создаем группу
        ToggleGroup toggleGroup =new ToggleGroup();
//вводим кнопки в эту группу
        air.setToggleGroup(toggleGroup);
        car.setToggleGroup(toggleGroup);
        train.setToggleGroup(toggleGroup);
//пишем обработчики под каждую кнопку
        final Label label1=new Label();
        flowPane.getChildren().addAll(air,car,train,label1);
        air.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label1.setText("выбран самолет");
            }
        });
        car.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label1.setText("выбран автомобиль");
            }
        });
        train.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                label1.setText("выбран поезд");
            }
        });
// далее выбираем первую кнопку по умолчанию
        air.fire();

        //добавим в конструкцию еще кнопку подтверждения выбора.
        // Создаем кнопки и группу кнопок.
        // Тема будет чай кофе молоко.


        RadioButton milk= new RadioButton("milk");
        RadioButton tea= new RadioButton("tea");
        RadioButton coffee= new RadioButton("coffee");
        //создаем группу
        final ToggleGroup toggleGroup1=new ToggleGroup();
        //вводим кнопки в группу
        milk.setToggleGroup(toggleGroup1);
        tea.setToggleGroup(toggleGroup1);
        coffee.setToggleGroup(toggleGroup1);
        //выбираем кнопку по умолчанию
        coffee.setSelected(true);
        //создадим две метки
        Label choose=new Label(" выберите напиток ");
        final Label confirm=new Label("напиток не выбран");
        // а теперь магия.Обрабатываем кнопки так,чтобы получить именно нажатую кнопку
        // а нет, не разбрался, создаем кнопку для подтвержения,
        // и в ее обработке будем ловить  текс с кнопки,которая будет нажата
        Button btnConfm=new Button("подтвердите свой выбор");
        btnConfm.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                RadioButton rb3=(RadioButton)toggleGroup1.getSelectedToggle();
                confirm.setText(rb3.getText()+" подтвержеден");
            }
        });
// введем разделительную линию
        Separator separator=new Separator();
        separator.setMaxWidth(200);
        //вводим в сцену все это
        flowPane.getChildren().addAll(choose,milk,tea,coffee,separator,btnConfm,confirm);
    }
}
