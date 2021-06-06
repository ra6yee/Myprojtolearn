package ООП;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

public class переопределение_методов {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println(cat.getName());// тут все отлично, вернется васька
         // Тут мы даже не знаем, что в классе-наследнике видимость метода была расширена.

        Tiger tiger = new Tiger();
        System.out.println( tiger.getName());
        /*
        Тут вызывается метод, у которого расширили область видимости.
             Если бы этого сделать было нельзя, всегда можно было бы объявить метод в Tiger:
                          public String getPublicName()
                       {
                          super.getName(); //вызов protected метода
                     }

                   Т.е. ни о каком нарушении безопасности и речи нет.
         */

    // но уже в этом случае возникают проблемы:
        //Cat catTiger = new Tiger(); если не расширить видимость
        //
        Cat catTiger = new Tiger();
        System.out.println(catTiger.getName());
//Если все условия подходят для вызова метода базового типа (Cat),
// то они уж точно подойдут для вызова типа наследника (Tiger)
// Т.к. ограничения на вызов метода были ослаблены, а не усилены.

        //Непонятно, программа и без этого нормально отрабатывается.

    }
    static class Cat
    {
        protected String getName()// тут ограниченная видимость модификатором protected где
                //                                                 Свой класс	Свой пакет	Класс — наследник
        {
            return "Васька";
        }
    }
    static class Tiger extends Cat
    {
        public String getName() // и мы расширили видимость метода до уровня public
        {
            return "Василий Тигранович";
        }
    }


}
