package src.java.Null_Object;
// все указано в коде;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class solution1211 {
}

///Почитай на вики про паттерн "Null Object".
//Используй Files, чтобы в конструкторе класса Solution правильно инициализировать поле fileData объектом ConcreteFileData.
//        Если возникли какие-то проблемы со чтением файла по пути pathToFile, то инициализируй поле объектом NullFileData.
//        Требования:
//        •
//        Конструктор Solution должен инициализировать поле fileData объектом ConcreteFileData.
//        •
//        Если в конструкторе Solution возникла ошибка, нужно инициализировать поле fileData объектом NullFileData.
//        •
//        Конструктор Solution должен корректно устанавливать значение поля hidden у объекта ConcreteFileData.
//        •
//        Конструктор Solution должен корректно устанавливать значение поля executable у объекта ConcreteFileData.
//        •
//        Конструктор Solution должен корректно устанавливать значение поля directory у объекта ConcreteFileData.
//        •
//        Конструктор Solution должен корректно устанавливать значение поля writable у объекта ConcreteFileData.


interface FileData {
    boolean isHidden();

    boolean isExecutable();

    boolean isDirectory();

    boolean isWritable();
}

class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {

        try {
            this.fileData=
                    new ConcreteFileData(Files.isHidden(Paths.get(pathToFile)),Files.isExecutable(Paths.get(pathToFile)),
                            Files.isDirectory(Paths.get(pathToFile)),Files.isWritable(Paths.get(pathToFile)));
        } catch (IOException e) {
            this.fileData=new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}


class ConcreteFileData implements FileData {

    private boolean hidden;
    private boolean executable;
    private boolean directory;
    private boolean writable;

    public ConcreteFileData(boolean hidden, boolean executable, boolean directory, boolean writable) {
        this.hidden = hidden;
        this.executable = executable;
        this.directory = directory;
        this.writable = writable;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public boolean isExecutable() {
        return executable;
    }

    @Override
    public boolean isDirectory() {
        return directory;
    }

    @Override
    public boolean isWritable() {
        return writable;
    }
}


class NullFileData implements FileData {
    private Exception exception;

    public NullFileData(Exception e) {
        this.exception = e;
    }

    public Exception getException() {
        return exception;
    }

    @Override
    public boolean isHidden() {
        return false;
    }

    @Override
    public boolean isExecutable() {
        return false;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public boolean isWritable() {
        return false;
    }
}
