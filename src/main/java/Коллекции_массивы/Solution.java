package Коллекции_массивы;

//Реализуй логику метода getData так, чтобы main отработал без исключений.
//        Остальной код не менять.
//        Требования:
//        •
//        Метод getData не должен возвращать null.
//        •
//        Метод getData должен возвращать объект удовлетворяющий условию задачи.
//        •
//        Метод getData должен быть публичным.
//        •
//        Метод getData должен быть статическим.


import java.util.Arrays;
import java.util.List;

/*
Давно забытый Array
*/
public class Solution {
    public static void main(String[] args) {
        List<Number> numbers = Arrays.<Number>asList(1, 2, 3);
        addDataToList(numbers, getData());
        System.out.println(numbers);
    }

    public static Number[] getData() {
        return Arrays.<Number>asList().toArray(new Number[0]);
    }

    public static void addDataToList(List<Number> list, Number... data) {
        for (Number number : data) {
            list.add(number);
        }
    }
}
