package src.java.Tree;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
   Entry<String>root;
   List<Entry>list=new LinkedList<>();
//  @Override
//   public boolean add( String element){
//
//   }
    public CustomTree() {
          root=new Entry<String>("0");
        list.add(0,root);
    }

    @Override
    public String get(int index) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new  UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new  UnsupportedOperationException();
    }

    @Override
    public int size() {
        throw new  UnsupportedOperationException();
    }

public static class Entry<T>implements Serializable{
 String elementName;
 boolean availableToAddLeftChildren, availableToAddRightChildren;
Entry<T> parent, leftChild, rightChild;

    public Entry(String elementName) {
        this.elementName = elementName;
        this.availableToAddLeftChildren=true;
        this.availableToAddRightChildren=true;

    }
    public boolean isAvailableToAddChildren(){
        boolean rezult=(availableToAddRightChildren|availableToAddLeftChildren);
        return rezult;
    }
}
}
//Прочитал в книге Роберта Лафоре "Структуры и алгоритмы данных в Java" 381 страницу - глава
// "Представление дерева в виде массива" и все легко и просто решилось. 631 решивший.

//Госпаде, смотрю на решения по 200-300 строчек и не понимаю, как можно всё так запутать. Решается одним списком
// LinkedList и переменной размера этого списка, обьявленных под сигнатурой класса. Метод add() - 20 строчек,
// getParent() - 10 строчек, size() - 1 строчка(интересно, какая?). Два момента: size не должен учитывать root и
// при привязывании leftChild или rightChild к parent, не забывайте соответствующие availableToAddChildren забить
// значением false.

//Задача из серии неберучка и соответсвено пахнет. Ломал голову, что от меня хотят, мало что понял в 4 задании. Итак по
// порядку что я понял:
//чтобы переопределить метод: public int size() { return size;}  просто создаем поле в классе: int size = 0; Далее в
// этом же классе создаем поле: List<Entry<String>> list = new LinkedList<>(); С арайлистом почему-то не
// приняло - ругалось на пункт что 129 родитель - это 64.
//Там же создаем поле Entry<String> root; Поля созданы. Пишем конструктор:
// public CustomTree(){ this.root = new Entry<String>("0");  root.parent = root;  list.add(root.parent); }
// Метод size - смотри про него выше. Метод адд - самая большая головная боль. Тут пришлось попариться:
//в методе public boolean add(String elementName) создаем{ Entry<String> entry = new Entry<>(elementName);
// Бежим циклом по полю list, в цикле создаем объект: entry.parent = list.get(i); Проверяем на наличие детей
// if (entry.parent.isAvailableToAddChildren()) {list.add(entry); size++;
// if (entry.parent.availableToAddLeftChildren) {list.add(entry.parent);
// entry.parent.availableToAddLeftChildren = false; return true;} также проверяем правого} в самом конце метода
// возвращаем false; метод public String getParent(String s)  тут проще, создаем строку:String parent = null;
// Бежим снова циклом по листу, проверяем в цикле:
// if (s.equals(list.get(i).elementName)) parent = list.get(i).parent.elementName;break; возвращаем parent.
// Валидация пройдена по 4 пункуту


