package src.java.Final;

public class code {
}
/*
Запрети наследование
Запрети наследование от класса Listener.
Требования:
•
Класс Listener должен быть создан внутри класса Solution.
•
Класс Listener должен быть публичным.
•
Класс Listener должен быть статическим.
•
Должна быть запрещена возможность стать потомком класса Listener.

*/
 class Solution {

  final   public static class Listener {
        public void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }
//проверим возможность наследоваться от листенера, при добавлении к нему модификатора финал
//    public static class Speaker extends Listener{
//         // действительно, не получается произвести наследование.
//}
    public static void main(String[] args) {

    }
}
/*
Запрети переопределение
Запрети переопределение метода onMouseDown.
Требования:
•
Класс Listener должен быть создан внутри класса Solution.
•
Класс Listener должен быть публичным.
•
Метод onMouseDown должен быть публичным.
•
Должна быть запрещена возможность переопределить метод onMouseDown.

*/
class Solution1 {

    public static class Listener {
       final public  void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {
;
    }
}
/*
Запрети создание экземпляров класса
Запрети создание экземпляров класса Listener.
Требования:
•
Класс Listener должен быть создан внутри класса Solution.
•
Класс Listener должен быть публичным.
•
Класс Listener должен быть статическим.
•
Должна быть запрещена возможность создавать экземпляры класса Listener.
Добавил абстрактный класс, причем тут финал непонятно.

*/
class Solution2 {

 abstract  public static   class Listener {
        public void onMouseDown(int x, int y) {
            // Do something when the mouse down event occurs
        }

        public void onMouseUp(int x, int y) {
            // Do something when the mouse up event occurs
        }
    }

    public static void main(String[] args) {
//Listener lis=new Listener();
    }
}
