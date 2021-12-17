package паттерны_проектирования.dfs.Кеш_прокси;

public interface Storage {
    void add(Object storedObject);
    Object get(long id);
}
