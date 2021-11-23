package GEnerics;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.util.ListIterator;

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Параметризируй классы SomeClass и Solution следующим образом:
//1. SomeClass должен работать с типами, которые наследуются от Number;
//        2. Solution должен работать с типами, которые наследуются от List, который в свою очередь параметризируется типом SomeClass.
//        Требования:
//        •
//        Класс SomeClass должен работать с типами которые наследуются от Number.
//        •
//        Класс Solution должен работать с типами, которые наследуются от List, который в свою очередь параметризируется типом SomeClass.
//        •
//        Класс SomeClass должен быть публичным.
//        •
//        Класс SomeClass должен быть статическим.
//        •
//        Класс SomeClass должен находиться внутри класса Solution.


import java.util.List;

/*
Знакомство с дженериками
*/
public class Solution<T extends List<Solution.SomeClass>> {
    public static class SomeClass<T extends Number> {
    }

    public static void main(String[] args) {

    }
}

    ///Измени статический метод в классе GenericStatic так, чтобы он стал дженериком.
//    Пример вызова дан в методе main.
//        Требования:
//        •
//        Метод someStaticMethod в классе GenericStatic должен быть изменен в соответствии с условием задачи.
//        •
//        Метод someStaticMethod должен быть статическим.
//        •
//        Метод someStaticMethod должен быть публичным.
//        •
//        Метод someStaticMethod должен выводить данные на экран.

/*
Вызов статического метода
*/
 class Solution1 {
    public static void main(String[] args) {
        Number number = GenericStatic.<Number>someStaticMethod(new Integer(3));
    }
}


class GenericStatic {
    public static<T> T  someStaticMethod( Object   genericObject) {
        System.out.println(genericObject);
        return (T) genericObject;
    }
}
//    Насколько я понял, дженерик - это переменная для типа. И этой переменной мы даём какое-то имя. Наиболее часто
//    используемые имена для типов: E - Element (used extensively by the Java Collections Framework), K - Key,
//    N - Number, T - Type, V - Value.
//
//        В треугольных скобках при объявлении метода мы перечисляем типы, которые будем использовать. <T> говорит о том,
//        что все T в методе будут одного типа. При этом, если <T> было объявлено до этого на уровне класса, то мы
//        перекрываем этот тип другим, локальным. Может быть конструкция "public static <T> void methodName" или
//        "public <T, R> T methodName".
//
//        В нашем случае возвращаемый тип T, такой же, как и тип у аргумента метода. Именно <T> в объявлении метода нам
//        об этом говорит.
//
//        P. S. могу ошибаться в деталях, так как это то, что я понял из нагугленного за 5 минут.
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Параметризируй класс Solution, чтобы он мог работать со всеми классами, которые наследуются от HashMap.
//Метод getMap должен возвращать тип поля map.
//        Требования:
//        •
//        Класс Solution должен быть параметризирован типом который является наследником HashMap.
//        •
//        В классе Solution должно существовать поле map.
//        •
//        В классе Solution должен существовать метод getMap.
//        •
//        Метод main должен выводить данные на экран.

/*
Простой generics
*/
 class Solution22<T extends HashMap> {
    private HashMap map;

    public Solution22(HashMap map) {
        this.map = map;
    }

    public HashMap getMap() {
        return map;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("string", 4);
        Solution22 solution = new Solution22(hashMap);
        HashMap mapFromSolution = solution.getMap();
        System.out.println(mapFromSolution.getClass());


        LinkedHashMap<Solution22, Solution22> hashMap2 = new LinkedHashMap<>();
        hashMap2.put(solution, solution);
        Solution22 solution2 = new Solution22(hashMap2);
        LinkedHashMap mapFromSolution2 = (LinkedHashMap)solution2.getMap();   //need to cast  :(
        System.out.println(mapFromSolution2.getClass());
    }
}
//? при объявлении классов не используется. нужно указать тип буквой. обычно - T.
//        потому что мы этот тип обозначаем, чтобы где-то в коде класса использовать.

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Реализуй вспомогательныe методы в классе Solution, которые должны создавать соответствующую коллекцию и помещать туда переданные объекты.
//Методы newArrayList, newHashSet параметризируй типом T.
//        Метод newHashMap параметризируй типами К(ключ) и V(значение). Аргументы метода newHashMap должны принимать списки,
//        в которых содержатся наследники типов K и V.
//        Возвращаемые коллекции должны быть такого же типа, что и переданные в метод объекты.
//        Подсказка: в методе newHashMap нужно проверить чтобы списки ключей и значений совпадали по размерам, в
//        противном случае кинь IllegalArgumentException.
//        Требования:
//        •
//        Метод newArrayList должен быть параметризован типом Т.
//        •
//        Метод newArrayList должен возвращать ArrayList, который содержит переданные в метод объекты.
//        •
//        Метод newHashSet должен быть параметризован типом Т.
//        •
//        Метод newHashSet должен возвращать HashSet, который содержит переданные в метод объекты.
//        •
//        Метод newHashMap должен быть параметризован типом K и V.
//        •
//        Метод newHashMap должен возвращать HashMap, который содержит переданные в метод ключи и значения.
//        •
//        Метод newHashMap должен кидать IllegalArgumentException, если списки ключей и значений не совпадают по размеру.





/*
Collections & Generics
*/
 class Solution31 {

    public static void main(String[] args) {
//      ArrayList<String>list= newArrayList("раз","два ","три","четыре");
//        for (int i = 0; i <list.size() ; i++) {
//            System.out.println((String) list.get(i));
//        }
HashSet<Integer>set=newHashSet(12,23,33,2,445,2,2,0);
            for (Integer z :
                    set) {
                System.out.println(z);
            }
        }


//public static <T> ArrayList<T> newArrayList(T... elements)
    public static<T> T newArrayList(Object... elements) {
       ArrayList<T>list=new ArrayList<>();
        for (Object i : elements) {
            list.add((T)i);
        }
       // list.add((T)elements);
        //напишите тут ваш код
        return (T)list;
    }

    public static<T> HashSet<T> newHashSet(T... elements) {
        //напишите тут ваш код
            HashSet<T>set=new HashSet<>();
        for (T z :
                elements) {
            set.add((T)z);
        }
        return set;
    }

    public static<K,V>  HashMap<K,V> newHashMap(List<? extends K> keys, List<? extends V> values) {
        if(keys.size()!=values.size()){
            throw new IllegalArgumentException();
        }
        HashMap<K,V>map=new HashMap<K,V>();
        //напишите тут ваш код
        for (int i = 0; i <keys.size() ; i++) {
            map.put(keys.get(i),values.get(i));

        }
        return map;
    }
}

//    Дан класс Solution, параметризированный T.
//        Ограничьте параметр T.
//        T должен быть !!!!!наследником!!!!! класса ClassForGenerics и одновременно реализовывать интерфейс InterfaceForGenerics.
//        Менять можно только класс Solution.
//        Требования:
//        •
//        Класс Solution должен быть параметризирован типом который является наследником класса ClassForGenerics и
//        одновременно реализовывать интерфейс InterfaceForGenerics.
//        •
//        Интерфейс InterfaceForGenerics не должен расширять другие интерфейсы.
//        •
//        Класс ClassForGenerics не должен поддерживать интерфейс InterfaceForGenerics.
//        •
//        Класс Solution не должен быть наследником класса ClassForGenerics.


/*
Несколько суперклассов для дженерика
*/
   class Solution4<T extends ClassForGenerics & InterfaceForGenerics> {
    public static void main(String[] args) {
        Solution4<TestClassGood> testClassSolution = new Solution4<>();
        testClassSolution.check();

        //!!! Следующие оба варианта не должны работать, закомментируй их:
      //  Solution4<TestClassWrong1> wrong1Solution = new Solution4<>();
        //wrong1Solution.check();

       // Solution4<TestClassWrong2> wrong2Solution = new Solution4<>();
       // wrong2Solution.check();
    }

    public void check() {
        System.out.println("Works!");
    }

    public static class TestClassGood extends ClassForGenerics implements InterfaceForGenerics {

    }

    public static class TestClassWrong1 extends ClassForGenerics {

    }

    public static class TestClassWrong2 implements InterfaceForGenerics {

    }

}

interface InterfaceForGenerics {
}

 class ClassForGenerics {
}

///Реализуй логику метода convert в классе ConvertableUtil, который должен возвращать словарь, значениями которого
// являются элементы переданного cписка, а ключами являются объекты, полученные вызовом интерфейсного метода getKey.
//        Элементы cписка должны наследоваться от Convertable, который в свою очередь параметризирован каким-то ключом.
//        Например, ConvertableBook параметризирован String, т.е. ключ в результирующем словаре должен иметь тип - String
//        ConvertableUser параметризирован Integer, т.е. ключ в результирующем словаре должен иметь тип - Integer
//
//
//        Значения в словаре должны совпадать с элементами Списка.
//        Смотрите метод main для примера.


//        Расставьте в методе ConvertableUtil.convert дженерик типы.
//        Требования:
//        •
//        В множестве значений словаря возвращенного методом convert класса ConvertableUtil должны содержаться все
//        элементы конвертируемого списка.
//        •
//        Размер словаря возвращенного методом convert класса ConvertableUtil должен быть равен размеру конвертируемого
//        списка.
//        •
//        В множестве ключей словаря возвращенного методом convert класса ConvertableUtil должны содержаться ключи
//        конвертируемого списка, полученные с помощью вызова метода getKey на каждом объекте списка.
//        •
//        Конвертация должна проходить в соответствии с условием задачи, ключи получаем с помощью метода getKey, а
//        значением служат сами объекты списка.




/*
List to Map
*/
 class Solution5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        List<ConvertableUser> users = new ArrayList<>();
        users.add(new ConvertableUser(234, "First User"));
        users.add(new ConvertableUser(235, "Second User"));
        users.add(new ConvertableUser(236, "Third User"));

        Map<Integer, ConvertableUser> newMap = ConvertableUtil.convert(users);
        System.out.println(newMap);
        //{236=ConvertableUser{id=236, name='Third User'},
        // 235=ConvertableUser{id=235, name='Second User'},
        // 234=ConvertableUser{id=234, name='First User'}}

        //////////////////////////////////////////////////////////

        List<ConvertableBook> books = new ArrayList<>();
        books.add(new ConvertableBook("First Book"));
        books.add(new ConvertableBook("Second Book"));
        books.add(new ConvertableBook("Third Book"));

        Map<String, ConvertableBook> bookMap = ConvertableUtil.convert(books);
        System.out.println(bookMap);
        //{Third Book=ConvertableBook{name='Third Book'},
        // First Book=ConvertableBook{name='First Book'},
        // Second Book=ConvertableBook{name='Second Book'}}
    }
}

 class ConvertableBook implements Convertable<String> {
    private String name;

    public ConvertableBook(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return name;
    }

    @Override
    public String toString() {
        return "ConvertableBook{" +
                "name='" + name + '\'' +
                '}';
    }
}
class ConvertableUser implements Convertable<Integer> {
    private Integer id;
    private String name;

    public ConvertableUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getKey() {
        return id;
    }

    @Override
    public String toString() {
        return "ConvertableUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

interface Convertable<Key> {
    Key getKey();
}




 class ConvertableUtil {

    public static<K,V> Map<K,V> convert(List<? extends Convertable<K>> list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Map result = new HashMap();
        for (int i = 0; i <list.size() ; i++) {
//         Object obj=   list.get(i);
//         Class clazz=obj.getClass();
//            Method m=clazz.getDeclaredMethod("getKey");
//            m.setAccessible(true);
        // result.put(  m.invoke(obj),obj);
         result.put(  list.get(i).getKey(),list.get(i));
        }
        return result;
    }
}
/*
Попытаюсь "разжевать на пальцах" как просили ниже. Не забываем для начала обозначить метод как дженерик, без этого
пляски с бубном и пустая трата времени с <?>.
Что бы ввести в игру параметры для статического метода эти параметры надо объявить в сигнатуре метода. Представьте что
это какие то переменные, которые надо как то объявить. Вот их и объявляют в сигнатуре.

В нашем статическом методе сразу обозначим что мы будем иметь дело с двумя типами: условный <K> тип-ключи и условный <V>
 тип-значений. т.о. получим
public static <K, V extends Convertable<K>> Map convert(List<V> list) {
}


Какими эти типы могут быть - мы уже обозначили в сигнатуре метода, поэтому дальше, внутри самого метода, используем эти
типы просто как переменные. Например при создании поля map будем использовать просто
Map<K, V> result = new HashMap();

без всяких уточнений вроде extends

P.S. еще ниже писали что можно через рефлексию, но не забывайте 2 вещи:
1) дженериками обязательно надо научиться пользоваться, чем мы и занимаемся на этом уровне
2) рефлексия - не дешевая вещь с точки зрения производительности
Хотя для себя лучше попробовать как можно больше способов решения.
 */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//     Перепиши дженерики в методе add иcпользуя wildcards.
//        Логику не меняй.
//        Не оставляй закомментированный код.
//        Требования:
//        •
//        Вывод на экран должен соответствовать условию задачи.
//        •
//        Логика метода add должна быть сохранена.
//        •
//        В методе add должны использоваться wildcards.
//        •
//        Метод add должен быть статическим.




/*
Wildcards
*/
class Solution221 {

    public static <D, H extends D, S extends H> void add(List<? super S > destinationList, List<? extends D> sourceList) {
        ListIterator<D> destListIterator = (ListIterator<D>) destinationList.listIterator();
        ListIterator<S> srcListIterator = (ListIterator<S>) sourceList.listIterator();
        for (int i = 0; i < sourceList.size(); i++) {
            destListIterator.add(srcListIterator.next());
        }
    }


    public static void main(String[] args) {
        List<B> destination = new ArrayList<>();
        destination.add(new B());
        List<C> source = new ArrayList<>();
        source.add(new C());
        add(destination, source);
        System.out.println(destination);
        System.out.println(source);

        /*
[com.javarush.test.level39.lesson08.task01.Solution$C@203b4f0e, com.javarush.test.level39.lesson08.task01.Solution$B@15c330aa]
[com.javarush.test.level39.lesson08.task01.Solution$C@203b4f0e]
         */
    }

    static class A {
    }

    static class B extends A {
    }

    static class C extends B {
    }
}

//    Проанализируй классы в задаче.
//        В методе main создано два дома: один для котов и один для собак.
//        Однако сейчас, когда в дом для кошек заходит собака, возникает конфликт и все находящиеся в нем коты вынуждены
//        покинуть дом (метод checkConflicts).
//        Помоги котам защитить свой дом от посторонних, а также не позволить им случайно заходить в дом для собак.
//        Для этого параметризируй House типом T и внеси соответствующие правки в реализацию класса.
//        Метод main не принимает участие в тестировании.
//        Требования:
//        •
//        Класс House должен быть параметризован с типом T.
//        •
//        Поле residents в классе House должно быть параметризовано типом T.
//        •
//        Метод enter в классе House должен принимать объект типа T.
//        •
//        Метод leave в классе House должен принимать объект типа T.
//        •
//        Метод checkConflicts в классе House больше не нужен и должен быть удален.

/*
Вход воспрещен!
*/
 class House<T> {

    private List<? super T> residents = new ArrayList();

    public void  enter(T resident) {
        residents.add(resident);
        checkConflicts();
    }

    public void leave(T resident) {
        residents.remove(resident);
    }

    private void checkConflicts() {
        boolean conflict = false;
        for (Object resident : residents) {
            if (resident instanceof Dog) {
                conflict = true;
            }
        }

        if (conflict) {
            Iterator iterator = residents.iterator();
            while (iterator.hasNext()) {
                Object resident = iterator.next();
                if (resident instanceof Cat) {
                    iterator.remove();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("В доме находятся:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Dog bruno = new Dog("Bruno");
        Puppy larsik = new Puppy("Larsik");
        Cat barsik = new Cat("Barsik");
        Kitten keksik = new Kitten("Keksik");

        House<Dog> dogHouse = new House();
        dogHouse.enter(bruno);
        dogHouse.enter(larsik);
        //dogHouse.enter(barsik);
        System.out.println(dogHouse.toString());

        House<Cat> catHouse = new House();
        catHouse.enter(barsik);
        catHouse.enter(keksik);
       // catHouse.enter(bruno);
        System.out.println(catHouse.toString());
    }
}
 class Kitten extends Cat {

    public Kitten(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Котенок " + name;
    }
}

 class Dog {

    protected String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Пес " + name;
    }
}

class Puppy extends Dog {

    public Puppy(String name) {
        super(name);
    }

    @Override
    public String toString() {
        return "Щенок " + name;
    }
}

class Cat {

    protected String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Кот " + name;
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Разберись с текущими классами.
//Метод newInstance класса Generatorдолжен создавать Event для каждого нового вызова, однако сейчас компилятор ругается на синтаксис.
//        Переделай класс Generator так, что бы конструкция стала рабочей.
//        Подсказка: Для создания объекта потребуется использовать методClass<T>.newInstance().
//        Требования:
//        •
//        Класс Generator должен быть параметризован типом Т.
//        •
//        Класс Generator должен иметь поле типа Class, которое параметризовано типом Т.
//        •
//        Класс Generator должен иметь конструктор, который инициализирует поле типа Class.
//        •
//        Метод newInstance в классе Generator должен создавать и возвращать объект типа Т.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task35.task3512;

/*
Генератор объектов
*/
 class Solution32 {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Generator<Event> eventGenerator = new Generator<>(Event.class);

        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
        System.out.println(eventGenerator.newInstance().getId());
    }

}
class Event {

    private static int nextId = 1;


    private int id;

    public Event() {
        id = nextId++;
    }

    public int getId() {
        return id;
    }
}

 class Generator<T> {
     Class<T> clazz;
     public Generator(Class<T> eventClass) {
         this.clazz=eventClass;
     }

     T  newInstance() throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }
}


class Zoo<T>
{
 Class<T> clazz;
 ArrayList<T> animals = new ArrayList<T>();

 Zoo(Class<T> clazz)
 {
  this.clazz = clazz;
 }

 public T createNewAnimal() throws IllegalAccessException, InstantiationException {
  T animal = clazz.newInstance();
  animals.add(animal);
  return animal;
 }
}
/*
    Zoo<Tiger> zoo = new Zoo<Tiger>(Tiger.class); // вот тут передается тип!
    Tiger tiger = zoo.createNewAnimal();
*/













