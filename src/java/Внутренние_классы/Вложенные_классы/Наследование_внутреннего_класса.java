package src.java.Внутренние_классы.Вложенные_классы;

import java.math.BigDecimal;

public class Наследование_внутреннего_класса {
}

/*
Наследование от внутреннего класса
Внутри класса Solution создай 2 внутренних public класса Apt3Bedroom, BigHall.
Унаследуй их от Apartments и Hall.
Требования:
•
Класс Apt3Bedroom должен быть создан внутри класса Solution.
•
Класс BigHall должен быть создан внутри класса Solution.
•
Класс Apt3Bedroom должен быть публичным.
•
Класс BigHall должен быть публичным.
•
Класс Apt3Bedroom должен быть потомком класса Building.Apartments.
•
Класс BigHall должен быть потомком класса Building.Hall.

*/
class Solution8 {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }
public class Apt3Bedroom extends Building.Apartments {
    public Apt3Bedroom(Building building) {
        building.super();
    }
}
public class BigHall extends Building.Hall{
        public BigHall(Building building,BigDecimal square){
            building.super(square);
        }
}
    public static void main(String[] args) {

    }
}
/*
Рефакторинг Rectangle
В классе Rectangle:
1. Измени методы getHeight и getWidth, чтобы они возвращали объекты типов HasHeight и HasWidth соответственно.
2. Для этого внутри методов getHeight и getWidth создай локальные классы - реализации интерфейсов.
3. Переименуй getHeight в castToHasHeight, getWidth в castToHasWidth (на имени метода нажмиShift+F6).
4. Убери наследование интерфейсов в классе Rectangle.
P.S. Ожидается, что после внесения требуемых изменений, закомментированный код в методе станет рабочим и должен быть раскомментирован.
Требования:
•
В класса Rectangle должен быть реализован метод castToHasHeight.
•
В класса Rectangle должен быть реализован метод castToHasWidth.
•
Метод castToHasHeight должен возвращать объект типа HasHeight.
•
Метод castToHasWidth должен возвращать объект типа HasWidth.
•
Объект возвращаемый методом castToHasHeight должен вычислять высоту, как разницу между y координатами.
•
Объект возвращаемый методом castToHasWidth должен вычислять ширину, как разницу между x координатами.
•
Класс Rectangle не должен реализовывать интерфейс HasHeight.
•
Класс Rectangle не должен реализовывать интерфейс HasWidth.


*/
 /*
Рефакторинг Rectangle
*/
class Solution22 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
       // System.out.println(getHeight(rectangle));
        //System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        System.out.println(getHeight(rectangle.castToHasHeight()));
        System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(HasHeight rectangle) {
        return rectangle.getHeight();
    }

    public static double getWidth(HasWidth rectangle) {
        return rectangle.getWidth();
    }


    public static class Rectangle {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public HasHeight castToHasHeight() {
            class rect implements HasHeight {

                @Override
                public double getHeight() {
                    return Math.abs(point1.getY() - point2.getY());
                }
            }
            return new rect();
        }
           public HasWidth castToHasWidth() {
           class rect1 implements HasWidth{

               @Override
               public double getWidth() {
                   return Math.abs(point1.getX() - point2.getX());
               }
           }
            return new rect1();
        }

//        public double castToHasWidth() {
//            return Math.abs(point1.getX() - point2.getX());
//        }
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task24.task2404;

 class Point {
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task24.task2404;

 interface HasWidth {
    double getWidth();
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task24.task2404;
 interface HasHeight {
    double getHeight();
}
//х з что это, но это работает.Непонятно как и почему только
