package src.java.Многопоточность;

public class synchronized_Samples {
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// В классе Solution создай public static класс IntegerHolder.
//IntegerHolder должен быть для типа int (имя переменной должно быть value), быть thread safe и изменяемым.
//        В этом классе должны быть два publicметода get и set.
//        Требования:
//        •
//        Класс Solution должен содержать public static класс IntegerHolder.
//        •
//        Класс IntegerHolder должен содержать private поле value типа int.
//        •
//        Класс IntegerHolder должен содержать public метод get(), который должен вернуть value.
//        •
//        Класс IntegerHolder должен содержать public метод set(int value), который должен установить value переданным значением.
//        •
//        Класс IntegerHolder должен быть thread safe.

/*
Вежливость - это искусственно созданное хорошее настроение
*/
 class Solution71 {
     public static class IntegerHolder{

             private int value;

        synchronized public int get() {
             return value;
         }

       synchronized   public void set(int value) {
             this.value = value;
         }
     }
    public static void main(String[] args) {
    }
}


//    Все методы, кроме метода main, класса Solution должны быть thread safe.
//        Сделайте так, чтобы оба метода могли выполняться одновременно двумя различными тредами.
//synchronized(this) для этого не подходит, используй другой объект для лока.
//        Требования:
//        •
//        Класс Solution должен содержать метод getSumOfVar1AndVar2().
//        •
//        Класс Solution должен содержать метод getSumOfVar3AndVar4().
//        •
//        Метод getSumOfVar1AndVar2() должен содержать synchronized блок.
//        •
//        Метод getSumOfVar3AndVar4() должен содержать synchronized блок.
//        •
//        Synchronized блоки методов getSumOfVar1AndVar2() и getSumOfVar3AndVar4() должны использовать мьютексы
//        разных объектов.

/*
Мудрый человек думает раз, прежде чем два раза сказать
*/
 class Solution72 {
    int var1;
    int var2;
    int var3;
    int var4;

    public Solution72(int var1, int var2, int var3, int var4) {
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
    }

   //чушь полнейшая
        public int getSumOfVar1AndVar2 () {
            synchronized (new Object()){
                return var1 + var2;
            }
            }

  synchronized   public int getSumOfVar3AndVar4() {
      synchronized (this.getClass()) {
          return var3 + var4;
      }
  }

    public static void main(String[] args) {

    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// В синхронизированных блоках используй нужный лок.
//Требования:
//        •
//        Класс Solution должен содержать private static final поле int NUMBER_LOCKS.
//        •
//        Класс Solution должен содержать private final поле Node[] buckets.
//        •
//        Класс Solution должен содержать private final поле Object[] locks.
//        •
//        Все методы класса Solution не должны быть synchronized.
//        •
//        В методе get() класса Solution в synchronized блоке используй lock из массива locks в зависимости от хэша
//        объекта и количества лок объектов.
//        •
//        В методе clear() класса Solution в synchronized блоке используй lock из массива locks в зависимости от индекса
//        элемента и количества лок объектов.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/*
Распределение элементов по корзинам с собственным локом
*/
 class Solution73 {
    private static final int NUMBER_LOCKS = 12;
    private final Node[] buckets;
    private final Object[] locks;

    static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution73(int numberBuckets) {
        buckets = new Node[numberBuckets];
        locks = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % NUMBER_LOCKS]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % NUMBER_LOCKS]) {
                buckets[i] = null;
            }
        }
    }

    public static void main(String[] args) {

    }
}




