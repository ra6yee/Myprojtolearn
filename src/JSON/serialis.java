package src.JSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
@JsonAutoDetect
class Cat implements Serializable {
   public String name;
   public int age;
    public String sex;

    public Cat() {
    }
}

public class serialis {
    public static void main(String[] args) throws IOException {
        Cat Lena=new Cat();//этот объект будем сериализовать джексоном
        Lena.name="lena";
        Lena.age=38;
        Lena.sex="male";
// результат сериализации запишем в :
        StringWriter writer1=new StringWriter();
        //создаем объект джексона, который будет производить сериализацию
        ObjectMapper objectMapper=new ObjectMapper();
        // сама сериализация: 1-куда, 2-что
        objectMapper.writeValue(writer1,Lena);
        String rez=writer1.toString();
        System.out.println(rez);
    }

}
