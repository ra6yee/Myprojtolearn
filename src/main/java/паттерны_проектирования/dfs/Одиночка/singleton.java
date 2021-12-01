package паттерны_проектирования.dfs.Одиночка;

public class singleton {
    private static singleton sin;

    public static singleton getInstance() {
        if(sin==null){
            sin=new singleton();
        }
        return sin;
    }
// и делаем приватный конструктор

    private singleton() {
    }
}
