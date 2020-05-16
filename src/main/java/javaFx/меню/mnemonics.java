package javaFx.меню;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
// добавим в код мнемоники
// для этого в момент создания кнопки меню перед его именем ставим нижний дефис
 // этим кодом добавляем оперативные   клавиишши
// final void setAcceleration (keyCombination комбинация клвиш)
//чтобы указать в сочетании клавиш ctrl(для os mac meta) достаточно прописать shortcut.
// для запуска эого режима используется метода setMnemonicParsing(boolean)
// по умолчанию он включен
public class mnemonics extends Application {
    Label response;
    public static void main(String[] args) {
        launch();
    }



    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Demo Menu whith mnemonics");
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        //создаем метку для отображения результатов выбора из меню.
        response=new Label("Menu Demo");
        // создаем строку меню
        MenuBar menuBar = new MenuBar();
        // создаем меню файл
        Menu filemenu = new Menu("_File"); //это само меню с мнемоникой
        MenuItem open = new MenuItem("Open");// а это пункты этого меню
        MenuItem save = new MenuItem("Save");// пункты меню
        MenuItem close = new MenuItem("Close");// пункты меню
        MenuItem exit = new MenuItem("Exit");//пункты меню
        //теперь вводим пунктвы меню в само меню
        filemenu.getItems().addAll(open, save, close, new SeparatorMenuItem(), exit);
        //теперь вводим все меню Files в строку меню
        menuBar.getMenus().add(filemenu);
        //создаем меню Options
        Menu options = new Menu("_Options");// с мнемоникой
        //в этом меню создаем целое поменю Colors
        Menu colors = new Menu("Colors");
        //создаем пункты этого меню
        MenuItem red = new MenuItem("Red");
        MenuItem green = new MenuItem("Green");
        MenuItem blue = new MenuItem("Blue");
        // вводим пункты подменю в само подменю
        colors.getItems().addAll(red, green, blue);
        //вводим подменю в меню
        options.getItems().add(colors);
        //создаем подменю priority
        Menu priority = new Menu("Priority");
        // создаем пункты этого меню
        MenuItem high = new MenuItem("High");
        MenuItem low = new MenuItem("Low");
        //вводим пункты в подменю,а подменю в меню
        priority.getItems().addAll(high, low);
        options.getItems().add(priority);
        // введем разделитель
        options.getItems().add(new SeparatorMenuItem());
        //создаем еще один пункт меню reset
        MenuItem reset = new MenuItem("Reset");
        //вводим пункт в меню options
        options.getItems().add(reset);
        //теперь  вводим меню options в строку меню
        menuBar.getMenus().add(options);
        //создаем меню help
        Menu help = new Menu("_Help");// с мнемоникой
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

        // вводим меню в фраф сцены
        borderPane.setTop(menuBar);
        borderPane.setCenter(response);
// добаввляем операттивиные клавишши в меню file
        open.setAccelerator(KeyCombination.keyCombination("shortcut+o"));
        close.setAccelerator(KeyCombination.keyCombination("shortcut+c"));
        exit.setAccelerator(KeyCombination.keyCombination("shortcut+e"));
        save.setAccelerator(KeyCombination.keyCombination("shortcut+s"));
    }
}
