package src.java.паттерны_проектирования.dfs.Динамическая_прокси;
// прокси на примере. Имеем некий класс и интерфейс, который реализует класс
//предположим что к полям и методам класса доступа нет и нет возможности их переписать.Но необходимо сделать так,чтобы
// в кажом методе высвечивалась надпись с названием автосалона "АвтоРынок в Калуге".
// что бы сделать такую надстройку используем прокси

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class sample_Proxy {
}
interface equipment{
   void volumeEngine(int i);
  void transmission(String trans);
  void modelCar(String model);
  void year(int year);

}
class Car implements equipment{
int volumeEngine,year;
String transmissions,model;

//    public Car(int age, int year, String transmissions, String model) {
//        this.age = age;
//        this.year = year;
//        this.transmissions = transmissions;
//        this.model = model;
//    }

    public int getVolumeEngine() {
        return volumeEngine;
    }

    public void setVolumeEngine(int volumeEngine) {
        this.volumeEngine = volumeEngine;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTransmissions() {
        return transmissions;
    }

    public void setTransmissions(String transmissions) {
        this.transmissions = transmissions;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void volumeEngine(int i) {
        setVolumeEngine(i);
        System.out.println("Установлен объем двигателя "+ getVolumeEngine());
    }

    @Override
    public void transmission(String trans) {
        setTransmissions(trans);
        System.out.println("установлена коробка передач "+getTransmissions());
    }

    @Override
    public void modelCar(String model) {
setModel(model);
        System.out.println("установлена модель авто"+getModel());
    }

    @Override
    public void year(int year) {
setYear(year);
        System.out.println("Год выпуска "+getYear());
    }
}
// для создания прокси поднадобится несколько вещей:
// InvocationHandler — это специальный интерфейс, который позволяет перехватить любые вызовы методов к нашему объекту и
// добавить нужное нам дополнительное поведение.
//Нам необходимо сделать собственный перехватчик — то есть, создать класс и реализовать этот интерфейс.В интерфейсе используется
// один метод invoke, в котором и укажем дополнительную логику
// так же необходимо завести в наш класс переменную с объектом нашего !!!ИНТЕРФЕЙСА!!!, из которого будем перехватывать методы
class newCar implements InvocationHandler{
    private equipment equipment1;// это интерфейс

    public newCar(src.java.паттерны_проектирования.dfs.Динамическая_прокси.equipment equipment) {
        this.equipment1 = equipment;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("АвтоРынок в Калуге");
        System.out.println(method.getName());// можно выводить в файл и указывать ,например время.
        method.invoke(equipment1,args);// это доработка чтобы вызывался оригинальный метод
        return null;
    }
}
//а теперь создадим оригинатьный объект нашего закрытого класса и привяжем к нему нашу прокси

class vaz2101{
    public static void main(String[] args) {
        Car vaz01=new Car();
       //получим загрузчик классов у оригинального объекта
       ClassLoader vaz01ClassLoader=vaz01.getClass().getClassLoader();
       //получаем все интерфейсы оригинального объекта
       Class[] interfaces=vaz01.getClass().getInterfaces();
       //А теперь создаем прокси у нашего объекта
       equipment proxyVaz01=(equipment) Proxy.newProxyInstance(vaz01ClassLoader,interfaces,new newCar(vaz01));//не сказать что это так просто
// пробуем вызвать у нашего прокси какой нибудь оригинальный метод
        proxyVaz01.modelCar("ваз копейка");// но получили в консоли только логику,указанную в прокси, без выхова логики оригинального метода
// что бы поулчить нужный вывод в консолиЯ, придется доработать пметод invoke и сам перехватчик.
        //public Object invoke(Object proxy, Method method, Object[] args)
        //
        //У метода invoke() есть доступ к методу, вместо которого он вызывается, и ко всем его аргументам (Method method, Object[] args).
        // и мы должны вытянуть этот метод из этого вызова  method.invoke(equipment1,args);
proxyVaz01.transmission("механика, это же автоваз, прости господи");
    }
}
// в целом, наш прокси готов и работоспособен. Надеюсь, есть такой уже готовый шаблон, чтобы не писать столько всякого кода самому.
//
/*
Представь, что у тебя есть 20 методов, которые могут выполнять только залогиненные пользователи твоей программы.
 С помощью изученных приемов ты легко сможешь добавить в эти 20 методов проверку того, ввел ли пользователь
  логин и пароль, не дублируя код проверки отдельно в каждом методе.

Или, к примеру, если ты хочешь создать журнал, куда будут записываться все действия пользователей, это также легко
сделать с использованием прокси.

Можно даже сейчас: просто допиши в пример код, чтобы название метода выводилось в консоль при вызове invoke(), и
ты получишь простенький журнал логов нашей программы :)

В завершение лекции, обрати внимание на одно важное ограничение.

Создание прокси объекта происходит на уровне интерфейсов, а не классов. Прокси создается для интерфейса.

Взгляни на этот код:

//Создаем прокси нашего объекта vasia
Person proxyVasia = (Person) Proxy.newProxyInstance(vasiaClassLoader, interfaces, new PersonInvocationHandler(vasia));

Здесь мы создаем прокси именно для интерфейса Person.

Если попробуем создать прокси для класса, то есть поменяем тип ссылки и попытаемся сделать приведение к классу Man,
у нас ничего не выйдет.

Man proxyVasia = (Man) Proxy.newProxyInstance(vasiaClassLoader, interfaces, new PersonInvocationHandler(vasia));

proxyVasia.introduce(vasia.getName());

Exception in thread "main" java.lang.ClassCastException: com.sun.proxy.$Proxy0 cannot be cast to Man

Наличие интерфейса — обязательное требование. Прокси работает на уровне интерфейсо
 */







