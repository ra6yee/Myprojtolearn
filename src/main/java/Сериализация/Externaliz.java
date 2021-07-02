package Сериализация;
import java.io.*;
import java.util.Base64;

public class Externaliz {
}

// при имплементации интерфейса Externalizable ты должен реализовать два обязательных метода — writeExternal() и readExternal().
 class UserInfo implements Externalizable {

    private String firstName;
    private String lastName;
    private String superSecretInformation;

    private static final long SERIAL_VERSION_UID = 1L;

    //...конструктор, геттеры, сеттеры, toString()...

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}
/*
у нас появились существенные изменения!

Главное из них очевидно: при имплементации интерфейса Externalizable ты должен реализовать два обязательных
метода — writeExternal() и readExternal().

Как мы и говорили ранее, вся ответственность за сериализацию и десериализацию будет лежать на программисте.

Однако теперь ты можешь решить проблему отсутствия контроля над этим процессом! Весь процесс программируется напрямую
тобой, что, конечно, создает гораздо более гибкий механизм.

Кроме того решается проблема и c безопасностью. Как видишь, у нас в классе есть поле: персональные данные которые
 нельзя хранить в незашифрованном виде.

Теперь мы легко можем написать код, соответствующий этому ограничению.

К примеру, добавить в наш класс два простых приватных метода для шифрования и дешифрования секретных данных.
Записывать их в файл и вычитывать из файла мы будем именно в зашифрованном виде. А остальные данные будем записывать
 и считывать как есть :)

В результате наш класс будет выглядеть примерно так:
 */
 class UserInfo1 implements Externalizable {

    private String firstName;
    private String lastName;
    private String superSecretInformation;

    private static final long serialVersionUID = 1L;

    public UserInfo1() {
    }

    public UserInfo1(String firstName, String lastName, String superSecretInformation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.superSecretInformation = superSecretInformation;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.getFirstName());
        out.writeObject(this.getLastName());
        out.writeObject(this.encryptString(this.getSuperSecretInformation()));
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        firstName = (String) in.readObject();
        lastName = (String) in.readObject();
        superSecretInformation = this.decryptString((String) in.readObject());
    }

    private String encryptString(String data) {
        String encryptedData = Base64.getEncoder().encodeToString(data.getBytes());
        System.out.println(encryptedData);
        return encryptedData;
    }

    private String decryptString(String data) {
        String decrypted = new String(Base64.getDecoder().decode(data));
        System.out.println(decrypted);
        return decrypted;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuperSecretInformation() {
        return superSecretInformation;
    }
}
/*

Мы реализовали два метода, которые в качестве параметров используют те же ObjectOutput out и ObjectInput, с которыми
 уже встречались в лекции о Serializable.

В нужный момент шифруем или расшифровываем необходимые данные и в таком виде используем их для сериализации
нашего объекта.

Посмотрим, как это будет выглядеть на практике:
 */
 class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOutputStream fileOutputStream = new FileOutputStream("save.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        UserInfo1 userInfo = new UserInfo1("Ivan", "Ivanov", "Ivan Ivanov's passport data");

        objectOutputStream.writeObject(userInfo);

        objectOutputStream.close();

    }
}
/*
В методах encryptString() и decryptString() мы специально добавили вывод в консоль, чтобы проверить, в каком виде будут
 записаны и прочитаны секретные данные.

Код выше вывел в консоль строку:

SXZhbiBJdmFub3YncyBwYXNzcG9ydCBkYXRh

Шифрование удалось!

Полное содержание файла выглядит так:

¬н sr UserInfoГ!}ҐџC‚ћ  xpt Ivant Ivanovt $SXZhbiBJdmFub3YncyBwYXNzcG9ydCBkYXRhx
 */

//Теперь попробуем использовать написанную нами логику десериализации.
class Main1 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("save.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);


        UserInfo1 userInfo = (UserInfo1) objectInputStream.readObject();
        System.out.println(userInfo);

        objectInputStream.close();

    }
}
/*
Все оказалось не так просто! Механизм десериализации выбросил исключение и потребовал от нас создать конструктор по
умолчанию. Интересно, зачем? В Serializable мы обходились и без него… :/

Здесь мы подошли к еще одному важному нюансу. Разница между Serializable и Externalizable заключается не только
в «расширенном» доступе для программиста и возможность более гибко управлять процессом, но и в самом процессе. Прежде
всего, в механизме десериализации.

При использовании Serializable под объект просто выделяется память, после чего из потока считываются значения, которыми
 заполняются все его поля.

Если мы используем Serializable, конструктор объекта не вызывается! Вся работа производится через рефлексию
(Reflection API, который мы мельком упоминали в прошлой лекции).

В случае с Externalizable механизм десериализации будет иным. В начале вызывается конструктор по умолчанию.
И только потом у созданного объекта UserInfo вызывается метод readExternal(), который и отвечает за заполнение
полей объекта.

Именно поэтому любой класс, имплементирующий интерфейс Externalizable, обязан иметь конструктор по умолчанию.

 */



