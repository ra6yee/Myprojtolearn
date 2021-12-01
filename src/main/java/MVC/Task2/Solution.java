package MVC.Task2;
//Перемести некоторые методы в нужные классы, что бы получить паттерн MVC. Если необходимо - внеси изменения в метод 
// main, которые отражают внесенные тобой изменения. Поведение программы при этом не должно измениться.
//НЕ изменяй названия классов, методов и полей.
//        Требования:
//        •
//        Вывод программы должен остаться без изменений.
//        •
//        Необходимо переместить метод void increaseSpeed(int) из класса CarModel в класс CarController.
//        •
//        Необходимо переместить метод void decreaseSpeed(int) из класса CarModel в класс CarController.
//        •
//        В методе main класса Solution метод increaseSpeed необходимо вызывать у контроллера, а не у модели.
//        •
//        В методе main класса Solution метод decreaseSpeed необходимо вызывать у контроллера, а не у модели.


/*
Рефакторинг MVC
*/

public class Solution {
    public static void main(String[] args) {
        // Fetch car record from the database
        CarModel model = retrieveCarFromDatabase();

        // Create a view to show the car's speed on a speedometer (the console)
        SpeedometerView view = new SpeedometerView();

        CarController controller = new CarController(model, view);
        controller.updateView();

        // Update the model data
        controller.increaseSpeed(15);
        controller.updateView();

        // Update the model data
        controller.increaseSpeed(50);
        controller.updateView();

        // Update the model data
        controller.decreaseSpeed(7);
        controller.updateView();
    }

    private static CarModel retrieveCarFromDatabase() {
        CarModel currentCar = new CarModel();
        currentCar.setBrand("Nissan");
        currentCar.setModel("Almera Classic");
        currentCar.setSpeed(0);
        currentCar.setMaxSpeed(200);
        return currentCar;
    }
}
 class CarModel {
    private String brand;
    private String model;
    private int speed;
    private int maxSpeed;



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
 class CarController {
    private CarModel model;
    private SpeedometerView view;
    // private int speed;
    // private int maxSpeed;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
      //  this.speed=model.getSpeed();
       // this.maxSpeed=model.getMaxSpeed();

    }

     public void increaseSpeed(int seconds) {
         if (model.getSpeed() < model.getMaxSpeed()) {
             model.setSpeed((int) (model.getSpeed()+ (3.5 * seconds)));
         }
         if (model.getSpeed() > model.getMaxSpeed()) {
            // speed = maxSpeed;
              model.setSpeed(model.getMaxSpeed());
         }
     }

     public void decreaseSpeed(int seconds) {
         if (model.getSpeed() > 0) {
           //  speed -= (12 * seconds);
             model.setSpeed(model.getSpeed()-(12 * seconds));
         }
         if (model.getSpeed() < 0) {
           //  speed = 0;
         model.setSpeed(0);
         }
     }





    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }
}
 class SpeedometerView {
    public void printCarDetails(String brand, String model, int speed) {
        System.out.println("Car: \nBrand: " + brand + "\nModel: " + model + "\nCurrent Speed: " + speed + "\n");
    }
}
/*
Бизнес логика должна остаться в модели!
Переименуйте методы в модели например в setSpeedUp и setSpeedDown.
Вызовите их в контроллере, будут волки сыты, овцы целы.


Вообще-то, модель может (и даже должна) хранить бизнес-логику для управления данными, это называется Толстая Модель, и
её преимущество в том, что когда бизнес-логика переносится в модель, контроллер становится более свободным и может
сконцентрироваться на своей главной цели - обрабатывать ввод данных пользователя.

Правильнее всего, я считаю, было бы добавить методы в controller onSpeedUp(int), onSpeedDown(int), которые бы
делегировали управление соответствующим методами модели.

И небольшая практика для меня: Модель - пассивная, тонкая, Контроллер в данной задаче является Презентером, Вид
пассивный. Пользователь взаимодействует через контроллер, значит вид служит исключительно для отображения данных.

К чему все это: MVC - это не просто паттерн. MVC это прежде всего набор архитектурных идей/принципов/подходов, которые
могут быть реализованы различными способами с использованием различных шаблонов. Есть такие вещи, как пассивная и
активная модель, пассивный и активный вид, толстая и тонкая модель, и, в зависимости от этого, MVC будет реализовываться
 по-разному.

Самый оптимальный вид MVC: толстая, активная модель, активный вид. Тогда модель будет содержать в себе бизнес-логику по
управлению данными, а после изменения данных будет сама оповещать вид о том, что данные были изменены, посредством
шаблона Observer (Подписчик), после чего вид будет получать обновленные данные из модели.

Если пользователь взаимодействует через контроллер, то контроллер обрабатывает входные данные, манипулирует нужным
образом с моделью, после чего модель оповещает вид об изменениях и вид автоматически получает данные с модели и
обновляется.

Если пользователь взаимодействует через вид, то два варианта:

1) Виду известно напрямую об контроллере и он передает информацию в контроллер.
2) (Чаще) Контроллер подписывается на вид, и при получении данных от пользователя, вид отправляет оповещение контроллеру.
 Данный вариант используется чаще, чтобы сохранять слабое связывание.
*/