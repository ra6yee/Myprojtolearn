package src.java.Enum_Class;
import java.util.*;

public class code {
}

/*
Новые возможности!
Используя возможности enum-а реализуй метод getLetterPosition, который должен возвращать позицию буквы.
Позиция буквы A - 1.
Требования:
•
Класс Solution должен содержать enum Alphabet.
•
Alphabet должен содержать по порядку 26 букв английского алфавита.
•
Метод getLetterPosition у класса Alphabet должен возвращать позицию буквы в алфавите.
•
Метод getLetterPosition должен вызывать метод ordinal.

*/
class Solution {
    public static void main(String[] args) {
        System.out.println(Alphabet.Z.getLetterPosition());
    }

    public enum Alphabet {
        A, B, C, D, E,
        F, G, H, I, J,
        K, L, M, N, O,
        P, Q, R, S, T,
        U, V, W, X, Y, Z;

        int getLetterPosition() {
            return this.ordinal()+1;
        }
    }
}


/*
Машину на СТО не повезем!
Инициализируй поле wheels используя данные из loadWheelNamesFromDB.
Выкинь исключение в случае некорректных данных.
Подсказка: если что-то не то с колесами, то это не машина!
Сигнатуры не менять.
Требования:
•
Enum Wheel в классе Solution менять нельзя.
•
Сигнатуры в классе Car менять нельзя.
•
Во время создания машины нужно вызвать метод loadWheelNamesFromDB.
•
В случае возврата неправильных данных о колесах, нужно кинуть исключение.
•
Инициализируй поле wheels полученными данными.

*/
class Solution1 {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            wheels=new ArrayList<>();
            if(loadWheelNamesFromDB().length<4){
                try {
                    throw new IllegalAccessException();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
           String[] loadedWheels=loadWheelNamesFromDB();
            for (String z:loadedWheels
                 ) {if (z.toString().equals(Wheel.valueOf(z).toString())){
                     wheels.add(Wheel.valueOf(z));
            }

            }
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car=new Car();
        for (Wheel z:car.wheels
             ) {
            System.out.println(z);

        }
    }
}


