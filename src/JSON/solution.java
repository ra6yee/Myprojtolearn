package src.JSON;

// ///НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1
//   1) В программе не выполнено основное требование к сериализации в JSON.
//        Найди ошибку и исправь.
//        2) Расставь правильно JSON аннотации у классов.
//        Все данные должны сериализоваться.
//        Требования:
//        •
//        Класс Pet должен быть помечен как готовый к сериализации в JSON.
//        •
//        Класс Cat должен быть помечен как готовый к сериализации в JSON.
//        •
//        Класс Dog должен быть помечен как готовый к сериализации в JSON.
//        •
//        Все данныеные у классов Pet, Cat, Dog должны сериализоваться.

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Map;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



import java.util.Date;

/*
Первая сериализация в JSON
*/
public class solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        convertToJSON(writer, pets);
        System.out.println(writer.toString());
        //[{"name":"Murka","age":5,"weight":3},{"name":"Killer","age":8,"owner":"Bill Jeferson"}]
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }
@JsonAutoDetect
    public static class Pet implements Serializable {
      public  String name;
    }
@JsonAutoDetect
    public static class Cat extends Pet {
      public   int age;
       public int weight;
    }
@JsonAutoDetect
    public static class Dog extends Pet {
      public   int age;
      public   String owner;
    }
}
//НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1
//        Расставь JSON аннотации так, чтобы результат работы метода main был следующим
//        {"wildAnimal":"Murka","over":3}
//        Требования:
//        •
//        Поле name класса Cat должно быть отмечено аннотацией JsonProperty.
//        •
//        Поле age класса Cat должно быть отмечено аннотацией JsonIgnore.
//        •
//        Поле weight класса Cat должно быть отмечено аннотацией JsonProperty.
//        •
//        Значение (value) аннотации JsonProperty у поля name должно быть равно "wildAnimal".
//        •
//        Значение (value) аннотации JsonProperty у поля weight должно быть равно "over".

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/*
Вторая сериализация в JSON
*/
 class Solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        StringWriter writer = new StringWriter();
        convertToJSON(writer, cat);
        System.out.println(writer.toString());
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, object);
    }

    @JsonAutoDetect
    public static class Cat {
        @JsonProperty("wildAnimal")
        public String name;
@JsonIgnore
        public int age;
@JsonProperty("over")
        public int weight;

        Cat() {
        }
    }
}

//НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1
//        В метод convertFromJsonToNormal первым параметром приходит имя файла, который содержит один ДЖЕЙСОН объект.
//        Вторым параметром приходит имя класса, объект которого находится в файле.
//        Метод convertFromJsonToNormal должен вычитать объект из файла, преобразовать его из JSON и вернуть.
//        Требования:
//        •
//        В методе convertFromJsonToNormal должен быть создан объект типа ObjectMapper с помощью конструктора без параметров.
//        •
//        Объект возвращаемый методом convertFromJsonToNormal должен быть получен с помощью метода readValue класса ObjectMapper.
//        •
//        Метод convertFromJsonToNormal должен быть статическим.
//        •
//        Метод convertFromJsonToNormal должен быть публичным.



/*
Десериализация JSON объекта
*/
class Solution1 {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
       ObjectMapper objectMapper=new ObjectMapper();

        FileReader reader=new FileReader(fileName);
        return objectMapper.readValue(reader,clazz);
    }

    public static void main(String[] args) {

    }
}

//НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.6.1
//        Два класса имеют одинаковые поля, но не имеют общий суперкласс. Пример, классы First и Second.
//        Реализовать логику метода convertOneToAnother, который должен возвращать объект класса resultClassObject, 
//        значения полей которого равны значениям полей в объекте one.
//        Используй объект типа ObjectMapper.
//        Известно, что у классов есть JSON аннотация, у которой значение property равно имени класса в нижнем регистре.
//        На примере класса First, это className="first"
//        Классы First и Second не участвуют в тестировании, они предоставлены в качестве тестовых данных.
//        Требования:
//        •
//        Метод convertOneToAnother должен возвращать объект класса resultClassObject значения полей которого равны
//         значениям полей объекта one.
//        •
//        В методе convertOneToAnother должен быть создан объект типа ObjectMapper.
//        •
//        Метод convertOneToAnother должен быть статическим.
//        •
//        Метод convertOneToAnother должен быть публичным.


/*
Конвертация из одного класса в другой используя JSON
*/
class Solution12 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Second s = (Second) convertOneToAnother(new First(23,"Nicolo"), Second.class);
        System.out.println(s.getClass());
        System.out.println(s.i);
        System.out.println(s.name);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException, ClassNotFoundException {
ObjectMapper on=new ObjectMapper();
StringWriter sw=new StringWriter();
        on.disable(MapperFeature.USE_ANNOTATIONS);
on.writeValue(sw,one);
       // System.out.println(sw.toString());
// String name=resultClassObject.getName();

StringReader sr=new StringReader(sw.toString());
        return on.readValue(sr,resultClassObject);

    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=First.class,  name="first"))
    public static class First {
        public First() {
        }

        public First(int i, String name) {
            this.i = i;
            this.name = name;
        }

        public int i;
        public String name;
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME,  property="className")
    @JsonSubTypes(@JsonSubTypes.Type(value=Second.class, name="second"))
    public static class Second {
        public int i;
        public String name;
    }
}

//НЕОБХОДИМО: подключенные библиотеки Jackson Core, Bind и Annotation версии 2.8.1
//        Расставь JSON аннотации так, чтобы результат выполнения метода main был следующим:
//        {
//          "className" : ".ParkingLot",
//          "name" : "Super ParkingLot",
//          "city" : "Kyiv",
//          "vehicles" : [ {
//            "className" : "com.javarush.task.task33.task3305.RacingBike",
//            "name" : "Simba",
//            "owner" : "Peter",
//            "age" : 2
//          }, {
//            "className" : "com.javarush.task.task33.task3305.Motorbike",
//            "name" : "Manny",
//            "owner" : null
//          }, {
//            "className" : "com.javarush.task.task33.task3305.Car"
//          } ]
//        }
//        Подсказка: это всего два класса.
//        Требования:
//        •
//        Вывод на экран должен соответствовать условию задачи.
//        •
//        Класс ParkingLot должен быть отмечен аннотацией @JsonTypeInfo с подходящим набором параметров.
//        •
//        Класс Vehicle должен быть отмечен аннотацией @JsonTypeInfo с подходящим набором параметров.


@JsonTypeInfo(use =JsonTypeInfo.Id.MINIMAL_CLASS,property="className")
 class ParkingLot {
    public String name;
    public String city;
    public List<Vehicle> vehicles;

    public ParkingLot(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", vehicles=" + vehicles +
                '}';
    }
}

/* 
Конвертация из одного класса в другой используя JSON
*/
 class Solution21 {
    public static void main(String[] args) throws IOException {
        ParkingLot parkingLot = new ParkingLot("Super ParkingLot", "Kyiv");
        RacingBike racingBike = new RacingBike("Simba", "Peter", 2);
        Motorbike motorbike = new Motorbike("Manny");
        Car car = new Car();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(racingBike);
        vehicles.add(motorbike);
        vehicles.add(car);
        parkingLot.setVehicles(vehicles);
        convertToJson(parkingLot);
    }

    public static void convertToJson(ParkingLot parkingLot) throws IOException {
        StringWriter writer = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(writer, parkingLot);
        System.out.println(writer.toString());
    }
}
 class Motorbike extends Vehicle {
    private String owner;

    public Motorbike(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
 class RacingBike extends Motorbike {
    private String owner;
    private int age;

    public RacingBike(String name, String owner, int age) {
        super(name);
        this.owner = owner;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "RacingBike{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", age=" + age +
                '}';
    }
}
@JsonTypeInfo(use =JsonTypeInfo.Id.CLASS, property="className" )
abstract class Vehicle {
    protected String name;
    protected String owner;
    protected int age;
}
 class Car extends Vehicle {
}

//     В результате выполнения кода в методе main класса Solution возникает странная ошибка
//        при сериализации/десериализации в JSON. На экран должна быть выведена строка sampleJsonString,
//        а выводится не совсем она.
//        Разберись в чем проблема и исправь. Обрати внимание на класс RealBean.
//        Требования:
//        •
//        Метод getAdditionalMap должен быть отмечен одной подходящей Jackson аннотацией.
//        •
//        Сериализация элементов additionalMap в json должна происходить, как сериализация обычных полей класса.
//        •
//        Десериализация элементов additionalMap из json должна происходить, как десериализация обычных полей класса.
//        •
//        Метод main должен выводить данные на экран.


/*
Странная ошибка
*/
 class Solution22 {
    public static void main(String[] args) throws IOException {
        StringWriter stringWriter = new StringWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String sampleJsonString = "{\"id\":1,\"name\":\"first\",\"KEY#1\":\"VALUE#1\",\"KEY#3\":\"VALUE#3\",\"KEY#2\":\"VALUE#2\"}";
        RealBean realBean = objectMapper.readValue(sampleJsonString, RealBean.class);

        objectMapper.writeValue(stringWriter, realBean);
        System.out.println(stringWriter.toString());
    }
}

 class RealBean {
    protected final int id;
    protected final String name;

    protected Map<String, Object> additionalMap = new HashMap<>();

    @JsonCreator
    public RealBean(@JsonProperty("id") int id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
     @JsonAnyGetter
    public Map<String, Object> getAdditionalMap() {
        return additionalMap;
    }

    @JsonAnySetter
    public void setAdditionalMap(String name, Object value) {
        additionalMap.put(name, value);
    }
}

//     Сделай так, чтобы при сериализации объекта типа Zoo, каждому элементу списка animals был добавлен тип (dog для класса Dog, cat для класса Cat).
//        Для проверки можешь использовать метод main класса Solution.
//        Было:
//        {"animals":[{"name":"doggy","barkVolume":0.0},{"name":"catty","lives":0}]}
//        Должно стать:
//        {"animals":[{"type":"dog","name":"doggy","barkVolume":0.0},{"type":"cat","name":"catty","lives":0}]}
//        Требования:
//        •
//        Класс Zoo.Animal должен быть отмечен аннотацией @JsonTypeInfo.
//•
//        Класс Zoo.Animal должен быть отмечен аннотацией @JsonSubTypes.
//•
//        Класс Zoo.Dog должен быть отмечен аннотацией @JsonTypeName.
//•
//        Класс Zoo.Cat должен быть отмечен аннотацией @JsonTypeName.
//•
//        При сериализации в JSON всем объектам списка animals должен быть добавлен тип и сохранен основной формат (пример в задании).

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task33.task3312;



/*
Сериализация зоопарка
*/
 class Solution222 {
    public static void main(String[] args) throws JsonProcessingException {
        Zoo.Dog dog = new Zoo.Dog("doggy");
        Zoo.Cat cat = new Zoo.Cat("catty");
        Zoo zoo = new Zoo();
        zoo.animals.add(dog);
        zoo.animals.add(cat);

        String result = new ObjectMapper().writeValueAsString(zoo);

        System.out.println(result);
    }
}

 class Zoo {
    public List<Animal> animals = new ArrayList<>();
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Dog.class, name = "dog"),
        @JsonSubTypes.Type(value = Cat.class, name = "cat")
})
    public static class Animal {
        public Animal(String name) {
            this.name = name;
        }

        public String name;
    }

    public static class Dog extends Animal {

        public double barkVolume;

        public Dog(String name) {
            super(name);
        }
    }

    public static class Cat extends Animal {
        boolean likesCream;
        public int lives;

        public Cat(String name) {
            super(name);
        }
    }
}


//     Используя аннотацию JsonFormat сделай так, чтобы поле содержащее дату в классе Event сериализировалось в формате (dd-MM-yyyy hh:mm:ss).
//        Требования:
//        •
//        Поле eventDate в классе Event должно быть отмечено аннотацией @JsonFormat.
//•
//        Объекты типа Event должны корректно сериализовываться в JSON в соответствии с условием задачи.
//        •
//        В конструкторе класса Event должен быть создан новый объект типа Date без аргументов.
//        •
//        Поле eventDate должно быть публичным.



/*
Сериализация даты в JSON
*/
 class Solution121 {
    public static void main(String[] args) throws JsonProcessingException {
        Event event = new Event("event#1");

        String result = new ObjectMapper().writeValueAsString(event);

        System.out.println(result);
    }
}

class Event {
    public String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public Date eventDate;

    public Event(String name) {
        this.name = name;
        eventDate = new Date();
    }
}








































