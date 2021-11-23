package GEnerics;
import java.util.Set;


public class wSolution {
}
//    Реализуй логику метода getAllAnimals.
//        Аргумент метода pathToAnimals - это абсолютный путь к директории, в которой хранятся скомпилированные классы.
//        Путь не обязательно содержит / в конце.
//        НЕ все классы наследуются от интерфейса Animal.
//        НЕ все классы имеют публичный конструктор без параметров.
//        Только для классов, которые наследуются от Animal и имеют публичный конструктор без параметров, - создать по
//        одному объекту.
//        Добавить созданные объекты в результирующий сет и вернуть.
//        Метод main не участвует в тестировании.
//        Требования:
//        Размер множества возвращаемого методом getAllAnimals должен быть равен количеству классов поддерживающих
//        интерфейс Animal и
//        имеющих публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве
//        параметра).
//        В множестве возвращаемом методом getAllAnimals должны присутствовать все классы поддерживающие интерфейс
//        Animal и имеющие
//        публичный конструктор без параметров (среди классов расположенных в директории переданной в качестве параметра).
//        В множестве возвращаемом методом getAllAnimals НЕ должен присутствовать ни один класс не поддерживающий
//        интерфейс Animal или
//        не имеющий публичного конструктора без параметров (среди классов расположенных в директории переданной в
//        качестве параметра).
//        Метод getAllAnimals должен быть статическим.
//        ..............................................................................................................................





/*
ClassLoader - что это такое?
*/
 class Solution43 {
    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution43.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        return null;
    }
}


 interface Animal {
}


 class Sheep implements Animal {
     private Sheep() {
     }

     public Sheep(Integer integer) {
     }
 }


     class Catty implements Animal {
        public Catty() {
        }
    }
class Elephant {
    private Elephant() {
    }
}