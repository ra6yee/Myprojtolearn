package Задачи_на_коллекции;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import static java.lang.Character.toLowerCase;
//Дана реализация красно-черного дерева.
//        Некоторые методы сломаны. Разберись в коде и исправь ошибки.
//        Метод main не участвует в тестировании.
//        Все модификаторы правильные.
//        Имена переменных и методов не изменяйте.
//        Требования:
//        •
//        Исправь ошибку в методе isEmpty в классе RedBlackTree.
//        •
//        Исправь ошибку в методе rotateWithRightNode в классе RedBlackTree.
//        •
//        Исправь ошибку в методе insert в классе RedBlackTree.
//        •
//        Класс RedBlackTree должен реализовывать красно-черное дерево.

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

class RedBlackTree {
    private static final Node EMPTY = new Node(0);

    static {
        EMPTY.left = EMPTY;
        EMPTY.right = EMPTY;
    }

    protected Node current;
    private Node parent;
    private Node grand;
    private Node great;
    private Node header;

    public RedBlackTree() {
        header = new Node(Integer.MIN_VALUE);
        header.left = EMPTY;
        header.right = EMPTY;
    }

    public boolean isEmpty() {
        return header.right == EMPTY;
    }

    public void clear() {
        header.right = EMPTY;
    }

    public void insert(int item) {
        current = grand = parent = header;
        EMPTY.element = item;
        while (current.element != item) {
            great = grand;
            grand = parent;
            parent = current;
            current = item > current.element ? current.right : current.left;

            if (current.left.color == Color.RED && current.right.color == Color.RED) {
                reorient(item);
            }
        }

        if (current != EMPTY) {
            return;
        }

        current = new Node(item, EMPTY, EMPTY);

        if (item < parent.element) {
            parent.left = current;
        } else {
            parent.right = current;
        }

        reorient(item);
    }

    protected void reorient(int item) {
        current.color = Color.RED;
        current.left.color = Color.BLACK;
        current.right.color = Color.BLACK;

        if (parent.color == Color.RED) {
            grand.color = Color.RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);
            }
            current = rotate(item, great);
            current.color = Color.BLACK;
        }

        header.right.color = Color.BLACK;
    }

    private Node rotate(int item, Node parent) {
        if (item < parent.element) {
            Node node = parent.left;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.left = resultNode;
            return parent.left;
        } else {
            Node node = parent.right;
            Node resultNode = item < node.element ? rotateWithLeftNode(node) : rotateWithRightNode(node);
            parent.right = resultNode;
            return parent.right;
        }
    }

    private Node rotateWithLeftNode(Node element) {
        Node left = element.left;
        element.left = left.right;
        left.right = element;
        return left;
    }

    private Node rotateWithRightNode(Node element) {
        Node right = element.right;
        element.right = right.left;
        right.left = element;
        return right;
    }

    public static enum Color {
        BLACK,
        RED
    }

    public static class Node {
        private int element;
        private Node left;
        private Node right;
        private Color color;

        public Node(int element) {
            this(element, null, null);
        }

        public Node(int element, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.element = element;
            this.color = Color.BLACK;
        }
    }
}
//     Первым параметром приходит имя файла: файл1.
//        файл1 содержит только буквы латинского алфавита, пробелы, знаки препинания, тире, символы перевода каретки.
//        Отсортируй буквы по алфавиту и выведи на экран первые 5 различных букв в одну строку без разделителей.
//        Если файл1 содержит менее 5 различных букв, то выведи их все.
//        Буквы различного регистра считаются одинаковыми.
//        Регистр выводимых букв не влияет на результат.
//        Закрой потоки.
//        Пример 1 данных входного файла:
//        zBk yaz b-kN
//        Пример 1 вывода:
//        abkny
//        Пример 2 данных входного файла:
//        caAC
//        A, aB? bB
//        Пример 2 вывода:
//        abc
//        Подсказка: использовать TreeSet
//        Требования:
//        •
//        Программа должна использовать класс TreeSet.
//        •
//        У объекта типа TreeSet вызови метод add для добавления элементов.
//        •
//        Программа должна выводить результат на экран.
//        •
//        Вывод программы должен соответствовать условию задачи.

/*
Использование TreeSet
*/
class Solution1 {
    public static void main(String[] args) throws IOException {
        String fileName = "c:/file.txt";
        File file = new File(fileName);
        TreeSet<Character> treeSet = new TreeSet<>();
        FileInputStream fis = new FileInputStream(fileName);
        while (fis.available() > 0) {
            Character a = (char) fis.read();
            //a= toLowerCase(a);
            // char aa=(char) fis.read();

            //treeSet.add((char) fis.read());
            if (Character.isAlphabetic(a))
                treeSet.add(toLowerCase(a));
        }
        Iterator<Character> iterator = treeSet.iterator();
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println((iterator.next().toString()));
            }
        } catch (NoSuchElementException e) {
            System.out.println("размер сета недостаточен");
        }


        // Files.readAllBytes(Paths.get(fileName));
    }
}

//Сегодня рассмотрим часть функционала социальных сетей. Откуда сеть знает, каких людей предлагать тебе в друзья,
// которых ты можешь знать? Эту задачу легко решить с помощью графов.
//    Твоя задача реализовать метод Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep), который
//    возвращает индексы людей, которые у тебя в друзьях уже есть и которых ты можешь знать. После этого отработает
//    метод removeFriendsFromSet, и результат этого метода - это все потенциальные друзья человека с индексом index и
//    глубиной поиска deep.
//        Для упрощения будем рассматривать связи всех людей как двумерный массив humanRelationships (смотри пример 
//        массива в методе generateRelationships). По главной диагонали все элементы true, так как это один и тот же 
//        человек. Пересечение столбца и столбика указывает, добавлены ли люди друг у друга в друзья
//        (если true - то люди есть друг у друга в друзьях). Если человек с индексом k добавлен в друзья к человеку с
//        индексом p, это означает, что у человека с индексом p в друзьях есть человек с индексом k.
//        В метод передается два аргумента:
//        int index - это индекс человека в массиве (начиная с нуля);
//        int deep - глубина поиска друзей. Если Маша в друзьях у Наташи и у Маши в друзьях есть Оля, при глубине 
//        поиска = 1, для Наташи нужно добавить в результирующее множество Машу и как потенциального друга Олю. Если 
//        глубина поиска = 2, в это же множество нужно добавить еще и всех, с кем дружит Оля.
//        Смотри пример в методе main.
//        В множестве, которое возвращает метод getAllFriendsAndPotentialFriends не должно быть индекса index.
//        Требования:
//        •
//        В классе Solution должен существовать публичный метод Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep).
//        •
//        В классе Solution должно быть объявлено приватное поле boolean[][] humanRelationships.
//        •
//        В множестве, которое возвращает метод getAllFriendsAndPotentialFriends не должно быть индекса index.
//        •
//        Метод getAllFriendsAndPotentialFriends должен быть реализован согласно условию.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task36.task3611;


/*
Сколько у человека потенциальных друзей?
*/

class Solution2 {
    private boolean[][] humanRelationships;

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.humanRelationships = generateRelationships();

        Set<Integer> allFriendsAndPotentialFriends = solution.getAllFriendsAndPotentialFriends(4, 3);
        System.out.println(allFriendsAndPotentialFriends);                              // Expected: [0, 1, 2, 3, 5, 7]
        Set<Integer> potentialFriends = solution.removeFriendsFromSet(allFriendsAndPotentialFriends, 4);
        System.out.println(potentialFriends);                                           // Expected: [2, 5, 7]
    }

    public Set<Integer> getAllFriendsAndPotentialFriends(int index, int deep) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> tmpSet = new HashSet<>();
        tmpSet.add(index);
        for (int i1 = 0; i1 < deep; i1++) {
            for (Integer z : tmpSet
            ) {
                for (int i = 0; i < humanRelationships[z].length - 1; i++) {
                    if (humanRelationships[z][i]) {
                        set.add(i);
                    }
                }
                for (int j = z + 1; j < humanRelationships.length; j++) {
                    if (humanRelationships[j][z]) {
                        set.add(j);

                    }
                }
            }
            tmpSet.remove(index);
            tmpSet.removeAll(set);
            tmpSet.addAll(set);
        }
        set.remove(index);
        return set;
    }

    // Remove from the set the people with whom you already have a relationship
    public Set<Integer> removeFriendsFromSet(Set<Integer> set, int index) {
        for (int i = 0; i < humanRelationships.length; i++) {
            if ((i < index) && (index < humanRelationships.length) && humanRelationships[index][i]) {
                set.remove(i);
            } else if ((i > index) && humanRelationships[i][index]) {
                set.remove(i);
            }
        }
        return set;
    }

    // Return test data
    private static boolean[][] generateRelationships() {
        return new boolean[][]{
                {true},                                                                 //0
                {true, true},                                                           //1
                {false, true, true},                                                    //2
                {false, false, false, true},                                            //3
                {true, true, false, true, true},                                        //4
                {true, false, true, false, false, true},                                //5
                {false, false, false, false, false, true, true},                        //6
                {false, false, false, true, false, false, false, true, false},                  //7
                {false, false, false, true, false, false, false, true, true, true},                  //8
                {false, false, false, true, false, false, false, true, true, false, false},                  //9
                {false, false, false, true, true, false, false, true, false, false, false, false}                  //10
        };
    }
}

//    Историки добавили несколько дат произошедших событий в уникальное множество в методе initializeDates.
//        Далее они точнее изучили исторические материалы, и уточнили время последнего события lastDate. Каково же было их
//         изумление, когда в этом множестве не находится нужная дата - метод isLastDateInDates возвращает false.
//        Амиго - твой долг помочь истории. Внеси необходимые изменения, чтобы дата последнего события находилась в 
//        множестве dates (чтобы вывод программы был true).
//        Требования:
//        •
//        В классе Solution должно быть объявлено приватное поле Set<Date> dates.
//        •
//        В классе Solution должно быть объявлено приватное поле Date lastDate.
//        •
//        Метод isLastDateInDates должен правильно возвращать содержит ли dates дату lastDate.
//        •
//        Количество элементов в множестве dates не должно измениться после вызова метода updateLastDate.
//        •
//        В методе updateLastDate необходимо удалить из множества dates старую дату lastDate.
//        •
//        В методе updateLastDate необходимо добавить в множество dates обновленную дату lastDate.


/*
Почему сет не содержит элемент?
*/

 class Solution4 {
    private Set<Date> dates;
    private Date lastDate;

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        solution.initializeDates();
        solution.updateLastDate(3_600_000L);
        System.out.println(solution.isLastDateInDates());
        solution.iteratorOfSet();

    }

    public void iteratorOfSet(){
        Iterator iterator=dates.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public boolean isLastDateInDates() {
        return dates.contains(lastDate);
    }

    private void initializeDates() {
        dates = new HashSet<>();
        lastDate = new Date(9999999L);
        dates.add(lastDate);
        dates.add(new Date(2222222L));
        dates.add(new Date(3333333L));
        dates.add(new Date(4444444L));
        dates.add(new Date(5555555L));
    }

    protected void updateLastDate(long delta) {
        dates.remove(lastDate);
        lastDate.setTime(lastDate.getTime() + delta);
        dates.add(lastDate);
    }
}




























