package Сериализация;

import java.io.*;

public class code {
}
/*
    Externalizable для апартаментов
    Реализуй интерфейс Externalizable в классе Apartment.
Требования:
•
Класс Solution.Apartment должен поддерживать интерфейс Externalizable.
•
В классе Solution.Apartment должен быть реализован метод writeExternal с одним параметром типа ObjectOutput.
•
В классе Solution.Apartment должен быть реализован метод readExternal с одним параметром типа ObjectInput.
•
В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeObject с параметром address.
•
В методе writeExternal, на полученном в качестве параметра объекте типа ObjectOutput должен быть вызван метод writeInt с параметром year.
•
Метод readExternal должен корректно восстанавливать из ObjectInput значение поля address.
•
Метод readExternal должен корректно восстанавливать из ObjectInput значение поля year.

        */
 class Solution1222 {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() { super(); }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.address);
            out.writeInt(123);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
address=(String)in.readObject();
year=(int)in.readInt();

        }
    }
//проверим что получилось у меня.Интересно
    public static void main(String[] args) throws IOException, ClassNotFoundException {
Apartment ap=new Apartment("Maykop str.Pionerskaya 385a",2021);
        FileOutputStream fos=new FileOutputStream("apart");

        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(ap);

        //проведем десериализацию объекта и проверим его поля
        FileInputStream fis=new FileInputStream("apart");
        ObjectInputStream ois=new ObjectInputStream(fis);
      Apartment  ap1=(Apartment)ois.readObject();
   fos.close();
   fis.close();
        System.out.println(ap1.toString());
        System.out.println(ap);
    }
}
//Задача решена и усвоена заодно и усложнена.Но стало интересней.

