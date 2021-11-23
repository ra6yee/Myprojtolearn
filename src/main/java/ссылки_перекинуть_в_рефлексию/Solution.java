package src.java.ссылки_перекинуть_в_рефлексию;

import org.apache.logging.log4j.core.Appender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// Реализуй логику методов get, put, remove класса SoftCache:
//Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key. Если такого ключа
// в cacheMap нет - верни null.
//        Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value. Метод должен вернуть
//         null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value по
//        этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
//        Метод AnyObject remove(Long key)должен удалить из мапы cacheMap пару key : value по ключу key. Метод должен 
//        вернуть null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value
//        по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
//        Не изменяй класс AnyObject.
//        Метод main не принимает участия в тестировании.
//        Требования:
//        •
//        Класс AnyObject не должен быть изменен.
//        •
//        В классе SoftCache должно существовать приватное поле Map<Long, SoftReference<AnyObject>> cacheMap.
//        •
//        Реализуй метод get согласно условию.
//        •
//        Реализуй метод put согласно условию.
//        •
//        Реализуй метод remove согласно условию.

/*
Кеш на основании SoftReference
*/

public class Solution {
    public static void main(String[] args) {
        SoftCache cache = new SoftCache();

        for (long i = 0; i < 2_500_000; i++) {
            cache.put(i, new AnyObject(i, null, null));
        }
    }
}

 class AnyObject {

    private Long id;
    private String name;
    private Calendar creationTime = new GregorianCalendar();
    private String additionalDescription;

    public AnyObject(Long id, String name, String additionalDescription) {
        this.id = id;
        if (name != null) {
            this.name = name;
        } else {
            this.name = "AnyObject#" + id;
        }
        if (additionalDescription != null) {
            this.additionalDescription = additionalDescription;
        } else {
            this.additionalDescription = "This is object #" + id;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnyObject that = (AnyObject) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        return creationTime.equals(that.creationTime);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + creationTime.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AnyObject{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                ", creationTime = " + creationTime.getTime() +
                ", additionalDescription = '" + additionalDescription + '\'' +
                '}';
    }
}

 class SoftCache {
    private Map<Long, SoftReference<AnyObject>> cacheMap = new ConcurrentHashMap<>();
    //Метод AnyObject get(Long key) должен возвращать объект типа AnyObject из мапы cacheMap по ключу key. Если такого ключа
// в cacheMap нет - верни null.
    public AnyObject get(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.get(key);
               if(softReference==null)
                   return null;
               else
                   return softReference.get();
        //напишите тут ваш код
    }
    // Метод AnyObject put(Long key, AnyObject value) должен добавлять в мапу пару key : value. Метод должен вернуть
     //         null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value по
//        этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.

    public AnyObject put(Long key, AnyObject value) {

                   SoftReference<AnyObject> softReference = cacheMap.put(key, new SoftReference<>(value));
               if(softReference==null){
                   return null;
               }else{
                   AnyObject a=softReference.get();
                   softReference.clear();
                   return  a;
               }
        //напишите тут ваш код
    }
   //  Метод AnyObject remove(Long key)должен удалить из мапы cacheMap пару key : value по ключу key. Метод должен 
     //        вернуть null, если в cacheMap по такому ключу ранее не было значения. Иначе - верни предыдущее значение value
//        по этому ключу. Не забудь вызвать метод clear() у объекта типа SoftReference<AnyObject>.
    public AnyObject remove(Long key) {
        SoftReference<AnyObject> softReference = cacheMap.remove(key);
        if(softReference==null){
            return null;
        }else{
            AnyObject a=softReference.get();
            softReference.clear();
            return  a;
        }
        //напишите тут ваш код

}
}

//     Разберись в примере.
//        Реализуй логику метода getPopulatedList класса Helper:
//        1) создай список, который сможет хранить призрачные ссылки на объекты Monkey
//        2) добавь в список 200 ссылок, используйте очередь helper.getQueue()
//        3) верни заполненный список
//        Требования:
//        •
//        Метод getPopulatedList должен возвращать список заполненный фантомными ссылками на объекты типа Monkey.
//        •
//        Метод getPopulatedList должен возвращать список из 200 элементов.
//        •
//        Класс Helper не должен быть приватным.
//        •
//        Метод getPopulatedList не должен быть приватным.

/*
Призрачные ссылки
*/
class Solution1 {
    public static Helper helper = new Helper();

    public static class Monkey {
    }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime();
        List<PhantomReference<Monkey>> list = helper.getPopulatedList();

        //before GC
        helper.checkListWithReferences(list, "before");

        helper.callGC();
        helper.heapConsuming();

        //after GC
        helper.checkListWithReferences(list, "after");

        helper.finish();
    }

    public static class Helper {
        private ReferenceQueue<Monkey> queue = new ReferenceQueue<>();

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        public ReferenceQueue<Monkey> getQueue() {
            return queue;
        }

        void heapConsuming() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                while (true) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("Out of memory error raised");
            }
        }

        public void checkListWithReferences(List<PhantomReference<Monkey>> list, String string) {
            int count = 0;
            for (PhantomReference<Monkey> reference : list) {
                if (reference.isEnqueued()) {
                    count++;
                }
            }

            System.out.println(String.format("The enqueue reference count is %d (%s GC was called)", count, string));
        }

        public List<PhantomReference<Monkey>> getFilledList() {
            return null;
        }

        public void finish() throws InterruptedException {
            int count = 0;
            while (queue.poll() != null) {
                count++;
            }
            System.out.println(count + " objects are in the queue of phantom reference");
            System.out.println("It took " + getTime() + " sec");
        }

        public List<PhantomReference<Monkey>> getPopulatedList() {
            List<PhantomReference<Monkey>> list =new ArrayList<>();
            for (int i = 0; i <200 ; i++) {
                list.add(new PhantomReference<>(new Monkey(),helper.getQueue()));
            }
             return list;
        }
    }
}
// Класс Cache - универсальный параметризированный класс для кеширования объектов.
//    Он работает с классами (дженерик тип Т), у которых обязан быть:
//        а) публичный конструктор с одним параметром типа K;
//        б) метод K getKey() с любым модификатором доступа.
//        Задание:
//        1. Выбери правильный тип для поля cache. Map<K, V> cache должен хранить ключи, на которые есть активные ссылки.
//        Если нет активных ссылок на ключи, то они вместе со значениями должны автоматически удаляться из cache.
//        2. Реализуй логику метода getByKey:
//        2.1. Верни объект из cache для ключа key.
//        2.2. Если объекта не существует в кэше, то добавьте в кэш новый экземпляр используя рефлексию, см. пункт а).
//        3. Реализуй логику метода put:
//        3.1. Используя рефлексию получи ссылку на метод, описанный в пункте б).
//        3.2. Используя рефлексию разреши к нему доступ.
//        3.3. Используя рефлексию вызови метод getKey у объекта obj, таким образом ты получишь ключ key.
//        3.4. Добавь в кэш пару <key, obj>.
//        3.5. Верни true, если метод отработал корректно, false в противном случае. Исключения игнорируй.
//        Требования:
//        •
//        Поле cache должно быть инициализировано объектом типа WeakHashMap.
//        •
//        Метод getByKey должен возвращать объект из кеша.
//        •
//        Метод getByKey должен добавлять объект в кеш если его там нет.
//        •
//        Метод put должен извлекать из переданного объекта ключ и добавлять в кеш пару <key, obj>.
//        •
//        Метод put должен возвращать true, если он отработал корректно, иначе false.

/*
Долго тупил с методом getByKey из за Дженериков, для меня они как то тяжело даются. Рефлексия мне как то проще зашла.
для тех, кому надо getByKey:
1. Берем из мапы как обычно по ключу значение (наш объект) и возвращаем его если он есть.
2. если нет, то, т.к. в аргументах метода у нас не просто переданный объект (как в методе put), а объект класса Class<V>
  то мы сразу у него получаем конструктор, в аргументах которого указываем (получаем) класс ключа key
3. Создаем объект класса Object с помощью полученного конструктора и передаем в него key
4. помещаем в мапу ключ с объектом
5. возвращаем объект по ключу.
put:
1. тут уже необходимо создать объект из obj получив класс
2. Извлекаем из полученного объекта нужный метод. Т.к. он у нас приватный используем getDeclaredMethod("getKey")
3. Позволяем системе его изменять: setAccessible(true);
4. Запускаем полученный метод: invoke(obj); и, поскольку, метод призван вернуть ключ то записываем его (значение ключа)
в переменную.
5. Кладем в мапу объект (переданный) по ключу
6. Возвращаем true
7. Если не сработало возвращаем false
 */


/*
Кэширование
*/
class Solution22 {
   private static final Logger logger= LoggerFactory.getLogger(Solution22.class);

    public static void main(String[] args) throws Exception {
  logger.info("begin the program");
        SomeKey someKey = new SomeKey();
        someKey.name = "test";
//         logger.debug();
//         logger.info("объекту присвоено имя");
        SomeKey someKeyNew = new SomeKey();
        someKeyNew.name = "testNew";

        SomeValue value = new SomeValue(someKey);

        Cache<SomeKey, SomeValue> cache = new Cache<>();
        cache.put(value);

        SomeValue existingValueFromCache = cache.getByKey(someKey, SomeValue.class);
        System.out.println(existingValueFromCache);

        SomeValue newValueFromCache = cache.getByKey(someKeyNew, SomeValue.class);
        System.out.println(newValueFromCache);

    /* Expected output:
        SomeValue{myKey=SomeKey{name='test'}}
        SomeValue{myKey=SomeKey{name='testNew'}}
        2
         */
    System.out.println(cache.size());

    }

    public static class SomeKey {
        String name;

        @Override
        public String toString() {
            return "SomeKey{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static class SomeValue {
        private SomeKey myKey;

        public SomeValue() {
        }

        public SomeValue(SomeKey myKey) {        //use this constructor
            this.myKey = myKey;
        }

        private SomeKey getKey() {
            return myKey;
        }

        @Override
        public String toString() {
            return "SomeValue{" +
                    "myKey=" + myKey +
                    '}';
        }
    }
}




 class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap<>();   //TODO add your code here

    public V getByKey(K key, Class<V> clazz) throws Exception {
        //TODO add your code here
       if (cache.get(key)==null){
           V newValue = (V) clazz.getConstructor(key.getClass()).newInstance(key);
           cache.put(key, (V)(newValue));
     //  key.getClass();
       }
        return cache.get(key);
    }

    public boolean put(V obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        //TODO add your code here
       Class c=obj.getClass();
       Method m=c.getDeclaredMethod("getKey");
       m.setAccessible(true);

        Method methlist[]
                = c.getDeclaredMethods();
        Solution22.SomeKey finding= (Solution22.SomeKey) m.invoke(obj);
        V newValue = (V) c.getConstructor(finding.getClass()).newInstance(finding);
        cache.put((K) finding,newValue);
        return true;
    }

    public int size() {
        return cache.size();
    }
}

