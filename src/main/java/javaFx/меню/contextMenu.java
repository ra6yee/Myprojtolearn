package javaFx.меню;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//Альтернатива или дополнение меню.Вызывается пкм на элементе управления.
//используется ContextMenu суперкласс PopupMenu, а косвенный суперкласс
//PopupWindow.
// Создается стандартным методом, сначала создаются  отдельные пункты,азатем они вводятся в меню контекста.
// И стандартно генерируется событие действия.
//Для активации подобного меню необходимо вызвать метод setContextMenu() и передать ему ссылку на то меню,
//которое должно всплывать при щелчке пкм на выбранном элементе.
public class contextMenu extends Application {
//Добавим к нашему окну контекстное меню и чуь изменим код.
Label response;
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demo Menu");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        //создаем метку для отображения результатов выбора из меню.
        response=new Label("Menu Demo");
        // создаем строку меню
        MenuBar menuBar = new MenuBar();
        // создаем меню файл
        Menu filemenu = new Menu("File"); //это само меню
        MenuItem open = new MenuItem("Open");// а это пункты этого меню
        MenuItem save = new MenuItem("Save");// пункты меню
        MenuItem close = new MenuItem("Close");// пункты меню
        MenuItem exit = new MenuItem("Exit");//пункты меню
        //теперь вводим пунктвы меню в само меню
        filemenu.getItems().addAll(open, save, close, new SeparatorMenuItem(), exit);
        //теперь вводим все меню Files в строку меню
        menuBar.getMenus().add(filemenu);
        //создаем меню Options
//        Menu options = new Menu("Options");
//        //в этом меню создаем целое поменю Colors
//        Menu colors = new Menu("Colors");
//        //создаем пункты этого меню
//        MenuItem red = new MenuItem("Red");
//        MenuItem green = new MenuItem("Green");
//        MenuItem blue = new MenuItem("Blue");
//        // вводим пункты подменю в само подменю
//        colors.getItems().addAll(red, green, blue);
//        //вводим подменю в меню
//        options.getItems().add(colors);
//        //создаем подменю priority
//        Menu priority = new Menu("Priority");
//        // создаем пункты этого меню
//        MenuItem high = new MenuItem("High");
//        MenuItem low = new MenuItem("Low");
//        //вводим пункты в подменю,а подменю в меню
//        priority.getItems().addAll(high, low);
//        options.getItems().add(priority);
//        // введем разделитель
//        options.getItems().add(new SeparatorMenuItem());
//        //создаем еще один пункт меню reset
//        MenuItem reset = new MenuItem("Reset");
//        //вводим пункт в меню options
//        options.getItems().add(reset);
//        //теперь  вводим меню options в строку меню
//        menuBar.getMenus().add(options);
        //создаем меню help

        ///////////////////////////////////////////////////////////////////
        // собираем новое и нужное меню.
        Menu options=new Menu("Options");
//создаем подменю
        Menu colors=new Menu("Colors");
        //Наполняем подменю пунктами
        CheckMenuItem red= new CheckMenuItem("Red");
        CheckMenuItem blue= new CheckMenuItem("Blue");
        CheckMenuItem green= new CheckMenuItem("Green");
        // добавляем эти подпункты в меню colors
        colors.getItems().addAll(red,blue,green);
        //добавляем подменю в меню
        options.getItems().add(colors);
// выберем по умолчанию красный цвет
        red.setSelected(true);
        ////////////////////////////////////////////
// создаем подменю priority с кнопками-пунктами и
// выбором только одной кнопки одоновременно
        Menu priority =new Menu("Priority");
        // собираем пункты этого подменю
        RadioMenuItem high=new RadioMenuItem("High");
        RadioMenuItem low=new RadioMenuItem("Low");
        // создаем группу кнопок
        ToggleGroup toggleGroup=new ToggleGroup();
        high.setToggleGroup(toggleGroup);
        low.setToggleGroup(toggleGroup);
        // выбираем пункт по умолчанию
        high.setSelected(true);
        //вводим пункты в подменю,а подменю в меню
        priority.getItems().addAll(high,low);
        options.getItems().add(priority);
        // вводим разделитель в это меню
        options.getItems().add(new SeparatorMenuItem());
        //создаем пункт ресет и вводим в подменю
        Menu reset=new Menu("Reset");
        options.getItems().add(reset);
        // вводим оптионс в  главное меню
        menuBar.getMenus().add(options);


        Menu help = new Menu("Help");
        MenuItem about = new MenuItem("About");
        help.getItems().add(about);
        //вводим само меню в строку меню
        menuBar.getMenus().add(help);
        // создаем один обработчик
        EventHandler<ActionEvent> Menhandler = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                String name = ((MenuItem) event.getTarget()).getText();
                if (name.equals("Exit"))
                    Platform.exit();
                response.setText(name+" selected");
                if(name.equals("About"))
                    response.setText("Эта программа пробный вариант \n"
                            +"написания окна с верхним меню \n"
                            +"для Windows.");
            }
        };
        //установим приемники действий  от всего меню
        open.setOnAction(Menhandler);
        close.setOnAction(Menhandler);
        colors.setOnAction(Menhandler);
        exit.setOnAction(Menhandler);
        save.setOnAction(Menhandler);
        red.setOnAction(Menhandler);
        green.setOnAction(Menhandler);
        blue.setOnAction(Menhandler);
        low.setOnAction(Menhandler);
        high.setOnAction(Menhandler);
        reset.setOnAction(Menhandler);
        about.setOnAction(Menhandler);

        // вводим меню в граф сцены
        borderPane.setTop(menuBar);
      //  borderPane.setCenter(response);

        //создаем само контекстное меню
        MenuItem cut=new MenuItem("cut");
        MenuItem copy=new MenuItem("copy");
        MenuItem paste=new MenuItem("paste");
        // создаем само меню и вводим в него пункты, созданные выше
        final ContextMenu editmenu=new ContextMenu(copy,cut,paste);
        // Далее пишем обработчик этого меню.В нашем случае перекидываем его на общий обработчик
        cut.setOnAction(Menhandler);
        copy.setOnAction(Menhandler);
        paste.setOnAction(Menhandler);
// привяжем наше меню к текстовому полю, которое сейчас и создадим
TextField textField=new TextField();
textField.setPrefColumnCount(20);
//теперь сама привязка
        textField.setContextMenu(editmenu);
        // теперь удалим из центра нашей сцены метку  и  создадим
        // панель поточной компоновки и в нее введем новую метку
        // и текстовое поле.
        FlowPane flowPane=new FlowPane(10,10);
        flowPane.setAlignment(Pos.CENTER);
        flowPane.getChildren().addAll(response,textField);
        borderPane.setCenter(flowPane);

    }

}

