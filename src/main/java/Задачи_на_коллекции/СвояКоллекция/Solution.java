package Задачи_на_коллекции.СвояКоллекция;

import java.io.Serializable;
import java.util.*;
import java.util.Map;
//Амиго, иногда существующих в Java коллекций недостаточно. Тогда можно либо взять стороннюю реализацию, например
//        Google Guava или Apache Commons, либо реализовать свою структуру данных. Сегодня у тебя есть уникальная
//        возможность испытать свои силы и написать часть своей структуры данных.
//        Наша структура данных называется MyMultiMap. Она параметризована дженериками, наследуется от HashMap, и 
//        реализует интерфейсы Cloneable, Serializable. Особенность нашей мапы будет в том, что конструктор принимает 
//        число типа int repeatCount - это количество, сколько значений может хранится по одному ключу.
//        Реализуй методы:
//        1) int size() - должен возвращать количество значений в нашей коллекции.
//        2) V put(K key, V value) - должен добавить элемент value по ключу key. Если в мапе такой ключ уже есть, и 
//        количество значений по этому ключу меньше, чем repeatCount - то добавь элемент value в конец листа в объекте map.
//        Если по такому ключу количество значений равняется repeatCount - то удали из листа в объекте map элемент
//        с индексом ноль, и добавь в конец листа value. Метод должен возвращать значение последнего добавленного элемента
//        по ключу key (но не значение, которое мы сейчас добавляем). Если по ключу key значений еще нет - верни null.
//        3) V remove(Object key) - должен удалить элемент по ключу key. Если по этому ключу хранится несколько элементов
//        - должен удаляться элемент из листа с индексом ноль. Если по какому-то ключу хранится лист размером ноль
//        элементов - удали такую пару ключ : значение. Метод должен возвращать элемент, который ты удалил. Если в мапе
//        нет ключа key - верни null.
//        4) Set<K> keySet() - должен вернуть сет всех ключей, которые есть в мапе map.
//        5) Collection<V> values() - должен вернуть ArrayList<V> всех значений. Порядок значений в листе не имеет значения.
//        6) boolean containsKey(Object key) - должен вернуть true, если в мапе присутствует ключ key, иначе вернуть false.
//        7) boolean containsValue(Object value)- должен вернуть true, если в мапе присутствует значение value, иначе вернуть false.
//        Смотри пример поведения в методе main().
//        Метод main() не принимает участия в тестировании.
//        Требования:
//        •
//        Класс MyMultiMap<K, V> должен наследоваться от HashMap<K, V> и реализовать интерфейсы Cloneable, Serializable.
//        •
//        В классе MyMultiMap должно присутствовать приватное поле HashMap<K, List<V>> map.
//        •
//        Необходимо реализовать метод int size() согласно условию.
//        •
//        Необходимо реализовать метод boolean containsKey(Object key) согласно условию.
//        •
//        Необходимо реализовать метод boolean containsValue(Object value) согласно условию.
//        •
//        Необходимо реализовать метод V put(K key, V value) согласно условию.
//        •
//        Необходимо реализовать метод V remove(Object key) согласно условию.
//        •
//        Необходимо реализовать метод Set<K> keySet() согласно условию.
//        •
//        Необходимо реализовать метод Collection<V> values() согласно условию.
//



/*
MyMultiMap
*/

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new MyMultiMap<>(3);
        for (int i = 0; i < 7; i++) {
            map.put(i, i);
        }
        map.put(5, 56);
        map.put(5, 57);
        System.out.println(map.put(5, 58));             // Expected: 57

        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=56, 57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 9

        System.out.println(map.remove(5));              // Expected: 56
        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 8

        System.out.println(map.keySet());               // Expected: [0, 1, 2, 3, 4, 5, 6]
        System.out.println(map.values());               // Expected: [0, 1, 2, 3, 4, 57, 58, 6]

        System.out.println(map.containsKey(5));         // Expected: true
        System.out.println(map.containsValue(57));      // Expected: true
        System.out.println(map.containsValue(7));       // Expected: false
    }
}

class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        int sizeMap = 0;
        Iterator itrMap = map.entrySet().iterator();
        while (itrMap.hasNext()) {
            Entry entry = (Entry) itrMap.next();
            List<V> list = (List<V>) entry.getValue();
            sizeMap += list.size();
        }
        return sizeMap;
    }

    @Override
    public V put(K key, V value) {
        if (map.containsKey(key)) {
            ArrayList<V> list = new ArrayList<>(repeatCount);
            list = (ArrayList<V>) map.get(key);

            if (list.size() < repeatCount) {
                list.add(value);

                map.put(key, list);
                return null;
            }
            if (list.size() == repeatCount) {
                V v = list.get(list.size() - 1);
                list.remove(0);
                list.add(value);
                map.put(key, list);
                return v;
            }

        } else {
            ArrayList<V> list1 = new ArrayList<>(repeatCount);
            list1.add(0, value);
            map.put(key, list1);
        }
        return null;

    }

    @Override
    public V remove(Object key) {
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            if (list.size() > 1) {
                V v = list.get(0);
                list.remove(0);
                map.put((K) key, list);
                return v;
            }
            if (list.size() == 0) {
                map.remove(key);
            }
        }
        if (!map.containsKey(key))
            return null;

        return null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = map.keySet();
        return set;
    }

    @Override
    public Collection<V> values() {
        List<V> list = new ArrayList<>();
        Iterator iter =  map.entrySet().iterator();
        while (iter.hasNext()) {
            Entry entry = (Entry) iter.next();
            List<V> list1 = (List<V>) entry.getValue();
            for (V z :
                    list1) {
                list.add(z);
            }
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        if (map.containsKey(key)) {
            return true;
        } else
            return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Entry entry = (Entry) itr.next();
            List<V> list = (List<V>) entry.getValue();
            for (V z :
                    list) {
                if (z.equals(value)) return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}
