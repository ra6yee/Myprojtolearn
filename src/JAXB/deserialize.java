package src.JAXB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.StringReader;

public class deserialize {
    public static void main(String[] args) throws JAXBException
{
    String xmldata ="<cat><name>Murka</name><age>5</age><weight>4</weight></cat>";
    StringReader reader = new StringReader(xmldata);

    JAXBContext context = JAXBContext.newInstance(Cat.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();

    Cat cat = (Cat) unmarshaller.unmarshal(reader);
}
  //  Класс, объект которого десериализуется из XML
    @XmlType(name = "cat")
    @XmlRootElement
    public static class Cat
    {
        public String name;
        public int age;
        public int weight;

        public Cat()
        {
        }
    }
}
