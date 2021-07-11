package src.java.паттерны_проектирования.dfs.обертка_System;

import java.io.*;

public class in {public static void main(String[] args) throws IOException
{
    //кладем данные в строку
    StringBuilder sb = new StringBuilder();
    sb.append("Lena").append('\n');
    sb.append("Olya").append('\n');
    sb.append("Anya").append('\n');
    String data = sb.toString();

    //Оборачиваем строку в класс ByteArrayInputStream
    InputStream is = new ByteArrayInputStream(data.getBytes());

    //подменяем in
    System.setIn(is);

    //вызываем обычный метод, который не подозревает о наших манипуляциях
    readAndPrintLine();
}

    public static void readAndPrintLine() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        while (true)
        {
            String line = reader.readLine();
            if (line == null) break;
            System.out.println(line);
        }
        reader.close();
        isr.close();
    }
}
/*
System.in – это простая статическая переменная типа InputStream, но присвоить ей новое значение просто так нельзя.
 Зато можно воспользоваться методом System.setIn().

Для начала нам нужно создать буфер, потом положить в него какие-то значения. Затем завернуть в класс, который умеет из
 этого буфера читать данные по протоколу InputStream.
 */