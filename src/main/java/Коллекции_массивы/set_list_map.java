package Коллекции_массивы;

import java.util.*;

public class set_list_map {
    public static void main(String[] args) {
        {

//для перебора любой коллекции ввели класс итератор. Имеет два метода hasnext  и next. есть метод remove удаляет
// последний элемент взятый итератором
            Set<String> set = new HashSet<String>();
            set.add("Mama");
            set.add("Mila");
            set.add("Ramu");

            //получение итератора для множества
            Iterator<String> iterator = set.iterator();

            while (iterator.hasNext())        //проверка, есть ли ещё элементы
            {
                //получение текущего элемента и переход на следующий
                String text = iterator.next();

                System.out.println(text);
            }
        }

        List<String> list = new ArrayList<String>();
        list.add("Mama");
        list.add("Mila");
        list.add("Ramu");

        Iterator<String> iterator = list.iterator();//получение итератора для списка

        while (iterator.hasNext())      //проверка, есть ли ещё элементы
        {
            //получение текущего элемента и переход на следующий
            String text = iterator.next();

            System.out.println(text);
        }

// с мар сложнее всего. Необходима дополнительная информация.
        Map<String, String> map = new HashMap<String, String>();
        map.put("first", "Mama");
        map.put("second", "Mila");
        map.put("third", "Ramu");

        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();

        while (iterator1.hasNext())
        {
            //получение «пары» элементов
            Map.Entry<String, String> pair = iterator1.next();
            String key = pair.getKey();            //ключ
            String value = pair.getValue();        //значение
            System.out.println(key + ":" + value);
        }
    }
}
//       for(Map.Entry<String, String> pair : map.entrySet())
//        System.out.println(pair.getKey());     разные выводы значений и ключей из мар
//
//        map.forEach((key, value) -> {
//        System.out.println(key);
//        });
//
//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()){
//        Map.Entry<String, String> pair = iterator.next();
//        System.out.println(pair.getKey());
//        }
//
/*

Квартет «Методы»
 оптимальные листы для разных операций

class Solution5 {
    public static List getListForGet() {
        return new ArrayList();

    }

    public static List getListForSet() {
        return new ArrayList();

    }

    public static List getListForAddOrInsert() {
        return new LinkedList();

    }

    public static List getListForRemove() {
        return new LinkedList();

    }
 */
//set имеет только уникальные элементы
//TreeSet  дополнительно сортирует объекты по возрастанию и имеет только уникальные элементы.
/*
чтобы удалить элемент из коллекции нужен итератор, иначе ничего не удалится при одновременном переборе коллекции



  public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();
        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Петровский", dateFormat.parse("JUNE 1 2012"));
        map.put("Высотников", dateFormat.parse("JULY 1 2012"));
        map.put("Брукхаймер", dateFormat.parse("APRIL 1 2012"));
        map.put("Нагиев", dateFormat.parse("JANUARY 1 2012"));
        map.put("Сталеваров", dateFormat.parse("AUGUST 1 2012"));
        map.put("Плотников", dateFormat.parse("SEPTEMBER 1 2012"));
        map.put("Высоцкий", dateFormat.parse("MARCH 1 2012"));
        map.put("Старинов", dateFormat.parse("DECEMBER 1 2012"));
        map.put("Губошлепов", dateFormat.parse("FEBRUARY 1 2012"));

 Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
        Map.Entry<String, Date> pair = iterator.next();
            int num=pair.getValue().getMonth();
            if(num>4 && num<8){iterator.remove();


        return map;


 */

