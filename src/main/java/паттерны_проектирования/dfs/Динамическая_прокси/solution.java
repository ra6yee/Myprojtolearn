package src.java.паттерны_проектирования.dfs.Динамическая_прокси;


//1) В отдельном файле создай публичный класс CustomInvocationHandler, который будет хэндлером при создании прокси-объекта.
//        2) CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.
//        3) CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
//        4) Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
//        5) После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
//        6) Реализуй логику метода getProxy, который должен создавать прокси (Proxy.newProxyInstance(...)).
//        См. пример вывода в методе main.
//        Метод main не участвует в тестировании.
//        Требования:
//        •
//        Класс CustomInvocationHandler должен существовать.
//        •
//        Класс CustomInvocationHandler должен поддерживать интерфейс InvocationHandler.
//        •
//        Класс CustomInvocationHandler должен иметь один публичный конструктор с одним аргументом типа SomeInterfaceWithMethods.
//        •
//        Перед вызовом любого метода у оригинального объекта должна выводиться фраза [methodName in].
//        •
//        После вызова любого метода у оригинального объекта должна выводиться фраза [methodName out].
//        •
//        Метод getProxy должен создавать прокси для интерфейса SomeInterfaceWithMethods.


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
Создание прокси-объекта
*/
class CustomInvocationHandler implements InvocationHandler{
    private SomeInterfaceWithMethods someInterfaceWithMethods;

    public CustomInvocationHandler(SomeInterfaceWithMethods someInterfaceWithMethods) {
        this.someInterfaceWithMethods = someInterfaceWithMethods;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName()+" in");
        method.invoke(someInterfaceWithMethods,args);
        System.out.println(method.getName()+" out");
        return null;
    }
}
 class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
      SomeInterfaceWithMethodsImpl sif=new SomeInterfaceWithMethodsImpl();
      ClassLoader loader=sif.getClass().getClassLoader();
      Class[] interfaces=sif.getClass().getInterfaces();
      SomeInterfaceWithMethods proxySif=(SomeInterfaceWithMethods) Proxy.newProxyInstance(loader,interfaces,new CustomInvocationHandler(sif));
        return proxySif;
    }
}
 class SomeInterfaceWithMethodsImpl implements SomeInterfaceWithMethods {
    public void voidMethodWithoutArgs() {
        System.out.println("inside voidMethodWithoutArgs");
    }

    public String stringMethodWithoutArgs() {
        System.out.println("inside stringMethodWithoutArgs");
        return null;
    }

    public void voidMethodWithIntArg(int i) {
        System.out.println("inside voidMethodWithIntArg");
        voidMethodWithoutArgs();
    }
}


 interface SomeInterfaceWithMethods {
    void voidMethodWithoutArgs();

    String stringMethodWithoutArgs();

    void voidMethodWithIntArg(int i);
}

