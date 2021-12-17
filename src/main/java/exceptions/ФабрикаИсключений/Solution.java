package exceptions.ФабрикаИсключений;

//Создай класс - фабрику исключений, который содержит один статический метод, возвращающий нужное исключение.
//        Этот метод должен принимать один параметр - энум.
//        Если передан энум:
//        * ApplicationExceptionMessage, верни исключение Exception
//        * DatabaseExceptionMessage, верни исключение RuntimeException
//        * UserExceptionMessage, верни Error иначе верните IllegalArgumentException без сообщения.
//        В качестве сообщения (message) для каждого возвращаемого объекта используйте элементы энума, в которых все
//        знаки подчеркивания замените на пробелы. Сообщение должно быть в нижнем регистре за исключением первого символа.
//        Например, сообщение для ApplicationExceptionMessage.SOCKET_IS_CLOSED - "Socket is closed".
//        Верните класс созданной фабрики в методе Solution.getFactoryClass.
//        Энумы не меняй.
//        Требования:
//        •
//        Метод getFactoryClass должен возвращать фабрику исключений.
//        •
//        ApplicationExceptionMessage не должен содержать никакие дополнительные методов или конструкторы.
//        •
//        DatabaseExceptionMessage не должен содержать никакие дополнительные методов или конструкторы.
//        •
//        UserExceptionMessage не должен содержать никакие дополнительные методов или конструкторы.
//        •
//        Статический метод фабрики исключений должен возвращать исключения перечисленные в условии (включая сообщение)
//        для любых входящих параметров.
//        •
//        Фабрика должна иметь один метод и он должен быть статическим.

enum UserExceptionMessage {
    USER_DOES_NOT_EXIST,
    USER_DOES_NOT_HAVE_PERMISSIONS
}

 enum DatabaseExceptionMessage {
    NOT_ENOUGH_CONNECTIONS,
    NO_RESULT_DUE_TO_TIMEOUT
}


/*
Фабрика исключений
*/

public class Solution {
   // private static Object ApplicationExceptionMessage;

    public static Class getFactoryClass() {
        return FactoryExceptions.class;
    }

    public static void main(String[] args) {

FactoryExceptions.exception(DatabaseExceptionMessage.NO_RESULT_DUE_TO_TIMEOUT);
//FactoryExceptions.exception(UserExceptionMessage.USER_DOES_NOT_HAVE_PERMISSIONS);

    }
}
 enum ApplicationExceptionMessage {
    UNHANDLED_EXCEPTION,
    SOCKET_IS_CLOSED
}
class FactoryExceptions {
    public static Throwable  exception  (Enum a) {
        String text = a.name();
        text = text.replaceAll("_", " ");

        text = text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
        //  System.out.println(text);
        System.out.println(a.getDeclaringClass().getSimpleName());
        if (a instanceof ApplicationExceptionMessage)
        { return new Exception(text);}
        if(a instanceof DatabaseExceptionMessage){
            return new RuntimeException(text);}
            if(a instanceof UserExceptionMessage){
                return new Error(text);
            }

        return new IllegalArgumentException();
    }
}

//class FactoryExceptions {
//    public static Throwable exception(Enum type) {
////        if (type == null)
////            return new IllegalArgumentException();
//
//        String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");
//
//        if (type instanceof ApplicationExceptionMessage)
//            return new Exception(message);
//
//        if (type instanceof DatabaseExceptionMessage)
//            return new RuntimeException(message);
//
//        if (type instanceof UserExceptionMessage)
//            return new Error(message);
//
//        return new IllegalArgumentException();
//    }
//}

