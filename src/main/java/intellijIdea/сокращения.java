package intellijIdea;

public class сокращения {
    //Настроить горячие клавиши Идеи можно набрав команду Ctrl + Alt + S
    //или File/Settings и выбрав в меню Appearance & Behavior/Keymap.
// альт и инс создание гетеров и сетеров и конструктора
    // отправка команды по энтеру
    //1. psvm + tab -> public static void main
    //2. sout + tab -> System.out.println()
    //3. serr + tab -> System.err.println()
    //4. System.out.println(«» + Enter -> + «»)
    //5.1 I + Enter -> for(Object object : ){} + ESC
    //5.2 Iter + Enter -> for(Object o: ){} + ESC
    //6. fori + tab -> for (int i = 0; i < ; i++){}
    //
    /*
    Ctrl + E открывает последний файл
    Ctrl + F12 навигация по открытому файлу
Alt + Home панель навигации

Ctrl + Space	Список компонентов (класса, метода, переменной)
Ctrl + Shift + Space	Smart code – фильтрует список из методов и переменных ожидаемого типа
Ctrl + Alt + Space	Название любого класса проекта независимо от импортируемых
Ctrl + Shift + Enter	Завершение оператора
Ctrl + P	Сведения о параметрах (в пределах аргументов вызоваемого метода)
Ctrl + Q	Быстрый поиск документации
Shift + F1	Внешняя документация
Ctrl + наведение мышью на фрагмент кода	Краткая информация
Ctrl + F1	Показать описания ошибки или предупреждения в каретку
Alt + Insert	Генерация кода (Getters, Setters, Constructors, hashCode/equals, toString)
Ctrl + O	Переопределение метода
Ctrl + I	Реализация методов
Ctrl + Alt + T	Поместить фрагмент кода в (if..else, try..catch, for, synchronized, etc.)
Ctrl + /	Однострочное комментирование / раскомментирование
Ctrl + Shift + /	Многострочное комментирование / раскомментирование
Ctrl + W	Выбирает последовательность возрастающих блоков кода
Alt + Q	Контекстная информация
Alt + Enter	Показать предлагаемое исправление
Ctrl + Alt + L	Форматирование кода
Ctrl + Alt + O	Удалить неиспользуемые импорты
Ctrl + Alt + I	Авто-отступ линии
Tab / Shift + Tab	Отступ / удаление отступа выбранному фрагменту кода
Ctrl + X or Shift + Delete	Вырезать фрагмент кода
Ctrl + C or Ctrl + Insert	Копировать фрагмент кода
Ctrl + V or Shift + Insert	Вставить фрагмент кода из буфера обмена
Ctrl + Shift + V	Вставить последний фрагмент кода из буфера обмена
Ctrl + D	Дублирование строки
Ctrl + Y	Удаление строки
Ctrl + Shift + J	Объединение строк
Ctrl + Enter	Разделение строки
Shift + Enter	Начать с новой строки
Ctrl + Shift + U	Переключить стоящее слово рядом с кареткой в нижний / верхний регистр
Ctrl + Shift + ] / [	Выделить код до конца / начала блока
Ctrl + Delete	Удалить слово после каретки
Ctrl + Backspace	Удалить слово перед каретки
Ctrl + NumPad+/-	Развернуть / свернуть блок кода
Ctrl + Shift + NumPad+	Развернуть все
Ctrl + Shift + NumPad-	Свернуть все
Ctrl + F4	Закрыть активное окно редактора

2. Поиск / замена
Ctrl + F	Поиск
F3	Искать дальше
Shift + F3	Искать назад
Ctrl + R	Замена
Ctrl + Shift + F	Искать по проекту
Ctrl + Shift + R	Заменить по проекту
Ctrl + Shift + S	Поиск по шаблону
Ctrl + Shift + M	Замена по шаблону


3. Поиск Использования кода
Alt + F7 / Ctrl + F7	Найти использования / Найти использования в файле
Ctrl + Shift + F7	Выделить используемое в файле
Ctrl + Alt + F7	Показать использования
4. Компиляция и выполнение
Ctrl + F9	Структурирование проекта и сборка измененных файлов
Ctrl + Shift + F9	Компиляция выбранного файла пакета или модуля
Alt + Shift + F10	Выбрать конфигурацию и запустить
Alt + Shift + F9	Выбрать конфигурацию и запустить в debug режиме
Shift + F10	Запустить
Shift + F9	Запустить в debug режиме
Ctrl + Shift + F10	Выполнить в контексте конфигурации из редактора
5. Отладка
F8	Шаг обхода
F7	Шаг
Shift + F7	Умный шаг
Shift + F8	Выйти
Alt + F9	Запуск до курсора
Alt + F8	Вычисление выражения
F9	Резюме программы
Ctrl + F8	Переключить точку останова
Ctrl + Shift + F8	Показать точки останова
6. Навигация
Ctrl + N	Перейти к классу
Ctrl + Shift + N	Перейти к файлу
Ctrl + Alt + Shift + N	Перейти к символу
Alt + Right/Left	Переход к следующей / предыдущей вкладки редактора
F12	Вернуться к предыдущему окну инструмента
Esc	Перейти к редактору (от окна инструментов)
Shift + Esc	Скрыть активное или последнее активное окно
Ctrl + Shift + F4	Закрыть активное run/messages/find/… окно
Ctrl + G	Перейти к номеру строки
Ctrl + E	Последние файлы
Ctrl + Alt + Left/Right	Перейдите назад / вперед
Ctrl + Shift + Backspace	Перейдите в последнее местоположение Редактора
Alt + F1	Выберите текущий файл или символ в любом режиме
Ctrl + B or Ctrl + Click	Перейти к объявлению
Ctrl + Alt + B	Перейти к реализации
Ctrl + Shift + I	Открыть быстрый поиск по определению
Ctrl + Shift + B	Перейти к объявления типа
Ctrl + U	Перейти к супер методу или классу
Alt + Up/Down	Переход к предыдущему / следующему методу
Ctrl + ] / [	Перейти в конец / начало блока
Ctrl + F12	Файловая структура
Ctrl + H	Иерархии Типа
Ctrl + Shift + H	Иерархия метода
Ctrl + Alt + H	Иерархии вызовов
F2 / Shift + F2	Следующий / предыдущий выделенные ошибки
F4 / Ctrl + Enter	Редактировать исходник / Просмотр
Alt + Home	Показать панель навигации
F11	Переключить закладку
Ctrl + Shift + F11	Переключить закладку с мнемонические
Ctrl + #[0-9]	Перейти к номером закладки
Shift + F11	Показать закладки
7. Рефакторинг
F5	Копирование
F6	Переместить
Alt + Delete	Безопасное удаление
Shift + F6	Переименовать
Ctrl + F6	Изменить сигнатуру
Ctrl + Alt + N	Встроить
Ctrl + Alt + M	Поместить в метод
Ctrl + Alt + V	Поместить в переменную
Ctrl + Alt + F	Поместить в поле
Ctrl + Alt + C	Поместить в константу
Ctrl + Alt + P	Поместить в параметр
8. VCS
Ctrl + K	Коммит проекта в VCS
Ctrl + T	Обновить проект из VCS
Alt + Shift + C	Посмотреть последние изменения
Alt + BackQuote (`)	Быстрый VCS
9. Интерактивные шаблоны
Ctrl + Alt + J	Окружение с живым шаблоном
Ctrl + J	Вставьте живой шаблон
iter	Итерация в Java SDK 1.5 стиле
inst	Проверяет тип объекта с InstanceOf
itco	Итерация элементов java.util.Collection
itit	Итерация элементов java.util.Iterator
itli	Итерация элементов java.util.List
psf	    public static final
thr	    throw new
sout	System.out.println()
10. Общие
Alt + #[0-9]	Откройте соответствующее окно инструмента
Ctrl + S	Сохранить все
Ctrl + Alt + Y	Cинхронизировать
Ctrl + Alt + F11	Переключение полноэкранного режима
Ctrl + Shift + F12	Переключить максимизацию редактору
Alt + Shift + F	Добавить в избранное
Alt + Shift + I	Проверьте текущий файл с текущим профилем
Ctrl + BackQuote (`)	Быстрое переключение текущей схемы
Ctrl + Alt + S	Открытые окна Параметры
Ctrl + Alt + Shift + S	Открыть диалоговое Структура проекта
Ctrl + Shift + A	Найти Действие
Ctrl + Tab	Переключение между вкладками и окна инструментов

     */


    //Все сокращения: ctrl + J
    /* Редактирование текста:
            1. ctrl + shift + -> — выделение слова вправо
2.1 shift + end -> выделение строки в конец
2.2 shift + home -> выделение строки в начало
3. ctrl + D -> копирование строки
4.1 ctrl + W -> по-элементное выделение
4.2 ctrl + shift + w -> по-элементная отмена выделения
5. ctrl + Y -> удалить строку
6. ctrl + X -> вырезать строку
7.1 ctrl + [+] -> раскрыть блок
7.2 ctrl + [-] -> закрыть блок
8.1 ctrl + shift + [+] -> раскрыть все блоки
8.2 ctrl + shift + [-] -> закрыть все блоки
9.1 ctrl + [~] (русская Ё) -> настройки цветовой схемы, стиля кода, keymap
10. ctrl + alt + o -> optimize reports (оптимизация импортов)
11. throws NSFE -> выкинуть эксепшн (набрать абревиатуру)
12. ctrl + BS -> удалить слово
13. alt + ins -> вызов генератора методов
14.1 tab -> сдвиг вправо строки/блока
14.2 shift + tab -> сдвиг влево строки/блока
15. ctrl + alt + i -> выравнивание отступов
16. ctrl + alt + t -> surround with (помещает выбранный блок в стандартную конструкцию)
17.1 ctrl + / -> однострочный комментарий (комментировать/раскомментировать)
17.2 ctrl + shift + / -> многострочный комментарий (комментировать/раскомментировать)
18. alt + 1 -> alt + ins -> создать класс, интерфейс и т.п.
19. ctrl + tab -> switcher (переключение между панелями)
20. ctrl + N -> имя класса -> переход к данному классу
21. ctrl + F4 -> закрыть вкладку
22. ctrl + I -> реализация методов, к примеру абстрактного класса


Дополнительные панели:
1. alt + 0 -> сообщения
2. alt + 1 -> открыть/закрыть дерево проектов
3. alt + 6 -> TODO

Навигация:
1. ctrl + { -> переход к открывающейся фигурной скобке
2. ctrl + G — переход к строке с номером

     */
}
