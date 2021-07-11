package src.java.паттерны_проектирования.dfs.adapter;

//import JavaRush.Core.Task.Solution35;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class code {
}
/*
TableAdapter
Измени класс TableAdapter так, чтобы он адаптировал ATable к BTable.
Метод getHeaderText должен возвращать такую строку "[username] : tablename".
Пример, "[Amigo] : DashboardTable".
Требования:
•
Класс Solution должен содержать public static интерфейс ATable.
•
Класс Solution должен содержать public static интерфейс BTable.
•
Класс Solution должен содержать public static класс TableAdapter.
•
Класс TableAdapter должен реализовывать интерфейс BTable.
•
Класс TableAdapter должен содержать приватное поле aTable типа ATable.
•
Класс TableAdapter должен содержать конструктор с параметром ATable.
•
Класс TableAdapter должен переопределять метод getHeaderText согласно заданию.

*/

 class Solution {
    public static void main(String[] args) {
        //это пример вывода
        ATable aTable = new ATable() {
            @Override
            public String getCurrentUserName() {
                return "Amigo";
            }

            @Override
            public String getTableName() {
                return "DashboardTable";
            }
        };

        BTable table = new TableAdapter(aTable);
        System.out.println(table.getHeaderText());
    }

    public static class TableAdapter implements BTable {
private ATable atb;

        public TableAdapter(ATable atb) {
            this.atb = atb;
        }

        @Override
        public String getHeaderText() {
            String out=this.atb.getCurrentUserName()+" : "+this.atb.getTableName();
            return out;
        }
    }

    public interface ATable {
        String getCurrentUserName();
        String getTableName();
    }

    public interface BTable {
        String getHeaderText();
    }
}

/*
Адаптер
Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.
Требования:
•
AmigoStringWriter должен быть интерфейсом.
•
Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
•
Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
•
Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
•
Метод flush() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
•
Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
•
Метод close() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.

*/

class AdapterFileOutputStream implements AmigoStringWriter {
private FileOutputStream fileOutputStream;

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public static void main(String[] args) {

    }

    @Override
    public void flush() throws IOException {
        this.fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
this.fileOutputStream.write(s.getBytes());
    }

    @Override
    public void close() throws IOException {
this.fileOutputStream.close();
    }
}
 interface AmigoStringWriter {
    void flush() throws IOException;
    void writeString(String s) throws IOException;
    void close() throws IOException;
}
/*
Адаптируй IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10цифр при необходимости (смотри примеры).
Обратите внимание на формат вывода фамилии и имени человека.
Требования:
•
Класс Solution должен содержать public static поле countries типа Map<String, String>.
•
В статическом блоке класса Solution инициализируй поле countries тестовыми данными согласно заданию.
•
Класс IncomeDataAdapter должен реализовывать интерфейсы Customer и Contact.
•
Класс IncomeDataAdapter должен содержать приватное поле data типа IncomeData.
•
Класс IncomeDataAdapter должен содержать конструктор с параметром IncomeData.
•
В классе IncomeDataAdapter реализуй методы интерфейсов Customer и Contact используя подсказки в виде комментариев в интерфейсах.

 */

 class Solution1 {
     public static Map<String, String> countries = new HashMap<String, String>();
     static {
      countries.put("UA","Ukraine");
      countries.put("RU","Russia");
      countries.put("CA","Canada");
     }


    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Customer,Contact {
                     private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getCompanyName() {
            return null;
        }

        @Override
        public String getCountryName() {
           String out=countries.get("UA");
            return out;
        }

        @Override
        public String getName() {
            return "Ivanov, Ivan";
        }

        @Override
        public String getPhoneNumber() {
            return null;
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}
/*
И еще один адаптер

Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
В классе адаптере создать приватное финальное поле Scanner fileScanner. Поле инициализировать в конструкторе с одним
аргументом типа Scanner.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950
Петров Петр Петрович 31 12 1957
В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать
 данные только одного человека.
Требования:
•
PersonScanner должен быть интерфейсом.
•
Класс PersonScannerAdapter должен реализовывать интерфейс PersonScanner.
•
Класс PersonScannerAdapter должен содержать приватное поле fileScanner типа Scanner.
•
Класс PersonScannerAdapter должен содержать конструктор с параметром Scanner.
•
Метод close() класса PersonScannerAdapter должен делегировать полномочие такому же методу fileScanner.
•
Метод read() класса PersonScannerAdapter должен читать строку с файла, парсить её, и возвращать данные только одного
человека, в виде объекта класса Person.


*/

class Solution4 {

    public static void main(String[] args) throws IOException, ParseException {
//Scanner one= new Scanner("c:\\text.txt");
//PersonScannerAdapter psa= new PersonScannerAdapter(one);
//Person person= psa.read();
//        System.out.println(person.toString());
//        File file=new File("c:\\text.txt");
//        System.out.println(new PersonScannerAdapter(new Scanner(file)).read());

        Scanner sc = new Scanner(Paths.get("C:/text.txt"), "Windows-1251");
        PersonScanner psc = new PersonScannerAdapter(sc);

        System.out.println(psc.read());
        System.out.println(psc.read());
        psc.close();

    }

    public static class PersonScannerAdapter implements PersonScanner {
          private Scanner filescanner;

        public PersonScannerAdapter(Scanner filescanner) {
            this.filescanner = filescanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
           // Person person=new Person();
            String info=this.filescanner.nextLine();
            String []arrayStr=info.split(" ");
            String firstName=arrayStr[0];
            String middleName=arrayStr[2];
             String lastName=arrayStr[1];
             String data=(arrayStr[3]+" "+arrayStr[4]+" "+arrayStr[5]);
            SimpleDateFormat sdf=new SimpleDateFormat("dd MM yyyy");
            Date holiday=sdf.parse(data);
            Person person=new Person(firstName,middleName,lastName,holiday);
            return person;
        }

        @Override
        public void close() throws IOException {
           this.filescanner.close();
        }
    }
}
 class Person {
    private String firstName;
    private String middleName;
    private String lastName;
    private Date birthDate;

    public Person(String firstName, String middleName, String lastName, Date birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s",lastName , middleName,firstName  , birthDate.toString());
    }
}
interface PersonScanner {
    Person read() throws IOException, ParseException;

    void close() throws IOException;
}








