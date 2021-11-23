package src.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class tasks {
}
//    Расставь правильно JAXB аннотации у статических классов.
//        Требования:
//        •
//        Класс Cat должен быть отмечен аннотацией @XmlRootElement.
//•
//        Класс Cat должен быть отмечен аннотацией @XmlType с параметром name = "cat".
//        •
//        Класс Dog должен быть отмечен аннотацией @XmlRootElement.
//•
//        Класс Dog должен быть отмечен аннотацией @XmlType с параметром name = "dog".

/*
Первая сериализация в XML
*/
 class Solution {
    public static void main(String[] args) throws IOException, JAXBException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        StringWriter writer = new StringWriter();
        convertToXml(writer, cat);
        convertToXml(writer, dog);
        System.out.println(writer.toString());
        /* expected output
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<cat>
    <name>Murka</name>
    <age>5</age>
    <weight>3</weight>
</cat>
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<dog>
    <name>Killer</name>
    <age>8</age>
    <owner>Bill Jeferson</owner>
</dog>
        */
    }

    public static void convertToXml(StringWriter writer, Object obj) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(obj, writer);
    }

    public static class Pet {
        public String name;
    }
    @XmlType(name="Cat")
    @XmlRootElement
    public static class Cat extends Pet {
        public int age;
        public int weight;
    }
    @XmlType(name = "Dog")
    @XmlRootElement
    public static class Dog extends Pet {
        public int age;
        public String owner;
    }
}

//    В метод convertFromXmlToNormal первым параметром приходит строка, содержащая xml объект.
//        Вторым параметром приходит класс, объект которого необходимо вернуть.
//        Метод convertFromXmlToNormal должен создать объект из xml-строки и вернуть его.
//        Требования:
//        •
//        В методе convertFromXmlToNormal должен быть создан новый объект типа JAXBContext с помощью статического метода
//        JAXBContext.newInstance, в качестве параметра используй целевой класс.
//        •
//        В методе convertFromXmlToNormal должен быть создан новый объект типа Unmarshaller с помощью метода
//        createUnmarshaller вызванного на объекте типа JAXBContext.
//        •
//        Метод convertFromXmlToNormal должен корректно преобразовывать входящую xml строку в объект требуемого класса.
//        •
//        Метод convertFromXmlToNormal должен быть статическим.


/*
Десериализация XML объекта
*/
 class Solution1 {
    public static void main(String[] args) throws IOException, JAXBException {
        String xmlData = "<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
        Cat cat = convertFromXmlToNormal(xmlData, Cat.class);
        System.out.println(cat);
    }

    public static <T> T convertFromXmlToNormal(String xmlData, Class<T> clazz) throws IOException, JAXBException {
        JAXBContext context=JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller=context.createUnmarshaller();
        StringReader reader=new StringReader(xmlData);

        return (T) unmarshaller.unmarshal(reader);
        //return (T)JAXBContext.newInstance(clazz).createUnmarshaller().unmarshal(new StringReader(xmlData));
        //почему нельзя? можно...
    }

    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat {
        public String name;
        public int age;
        public int weight;

        @Override
        public String toString() {
            return "Cat{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", weight=" + weight +
                    '}';
        }
    }
}
//    Восстанови класс по переданной строке xml.
//        Класс должен быть в отдельном файле.
//        Метод getClassName должен возвращать восстановленный класс.
//        Метод main не участвует в тестировании.
//        Требования:
//        •
//        Класс Shop должен быть создан в отдельном файле.
//        •
//        В классе Shop должно быть создано поле goods типа Goods.
//        •
//        В классе Shop должно быть создано поле count типа int.
//        •
//        В классе Shop должно быть создано поле profit типа double.
//        •
//        В классе Shop должен быть создан массив строк secretData.
//        •
//        В классе Shop должен содержаться вложенный статический класс Goods.
//        •
//        В классе Shop.Goods должен быть создан список строк names.
//        •
//        Все поля класса Shop должны быть публичными.
//        •
//        Метод getClassName класса Solution должен возвращать класс Shop.

/*
Создание класса по строке xml

 */
 class Solution22 {
    public static void main(String[] args) throws JAXBException {
        String xmlData =
                "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                        "<shop>\n" +
                        "    <goods>\n" +
                        "        <names>S1</names>\n" +
                        "        <names>S2</names>\n" +
                        "    </goods>\n" +
                        "    <count>12</count>\n" +
                        "    <profit>123.4</profit>\n" +
                        "    <secretData>String1</secretData>\n" +
                        "    <secretData>String2</secretData>\n" +
                        "    <secretData>String3</secretData>\n" +
                        "    <secretData>String4</secretData>\n" +
                        "    <secretData>String5</secretData>\n" +
                        "</shop>";

        StringReader reader = new StringReader(xmlData);

        JAXBContext context = JAXBContext.newInstance(getClassName());
        Unmarshaller unmarshaller = context.createUnmarshaller();

        Object o = unmarshaller.unmarshal(reader);

        System.out.println(o.toString());
    }

    public static Class getClassName() {
        return null;  //your class name
    }
}

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//<shop>
//<goods>
//<names>S1</names>
//<names>S2</names>
//</goods>
//<count>12</count>
//<profit>123.4</profit>
//<secretData>String1</secretData>
//<secretData>String2</secretData>
//<secretData>String3</secretData>
//<secretData>String4</secretData>
//<secretData>String5</secretData>
//</shop>

























