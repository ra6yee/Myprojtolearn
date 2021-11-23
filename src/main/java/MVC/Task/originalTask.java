package MVC.Task;

import java.util.ArrayList;
import java.util.List;
public class originalTask {
}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////В отдельных файлах создай классы Service, Model, View, Controller.
//    Распредели методы из класса Solution по созданным классам учитывая, что должен получиться MVC.
//        Создай нужные поля класса при необходимости.
//        Не добавляй своих других методов.
//        Метод main() оставь в классе Solution.
//        Требования:
//        •
//        Создай класс Service в отдельном файле.
//        •
//        Создай класс Model в отдельном файле.
//        •
//        Создай класс View в отдельном файле.
//        •
//        Создай класс Controller в отдельном файле.
//        •
//        Перемести реализацию метода getData() в подходящий класс.
//        •
//        Перемести реализацию метода getStringDataList() в подходящий класс. Учти, что метод getData() находится не в классе Solution.
//        •
//        Перемести реализацию метода onShowDataList() в подходящий класс. Учти, что метод getStringDataList() находится не в классе Solution.
//        •
//        Перемести реализацию метода fireShowDataEvent() в подходящий класс. Учти, что метод onShowDataList() находится не в классе Solution.
//        •
//        Метод main() должен создать объект типа View и вызвать у него подходящий метод. Поведение программы не должно измениться.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task36.task3601;


/*
MVC - простая версия
*/
 class Solution1 {
    public static void main(String[] args) {
        new Solution1().fireShowDataEvent();
    }

    public List<String> getData() {
        List<String> data = new ArrayList<String>() {{
            add("First string");
            add("Second string");
            add("Third string");
        }};
        return data;
    }

    public void fireShowDataEvent() {
        System.out.println(onShowDataList());
    }

    public List<String> getStringDataList() {
        return getData();
    }

    public List<String> onShowDataList() {
        return getStringDataList();
    }
}
