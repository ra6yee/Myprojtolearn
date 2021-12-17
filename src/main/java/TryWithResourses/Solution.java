package TryWithResourses;


/*
Улучшения в Java 7 (try-with-resources)
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public void printFile1() throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream("file.txt")) {

            int data = fileInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = fileInputStream.read();
            }
        }
    }

    public void printFile2() throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream("file.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream)) {


            int data = bufferedInputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = bufferedInputStream.read();
            }
        }
    }

    public static void main(String[] args) {

    }
}


//    Перепиши реализации методов класса Solution.
//        Используй нововведения (multiple exceptions), касающиеся обработки исключений, которые были добавлены в Java 7.
//        Требования:
//        •
//        В конструкторе класса Solution в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.
//        •
//        В методе write в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.
//        •
//        В методе read в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.
//        •
//        В методе disconnect в одном catch блоке должны быть обработаны исключения WrongDataException и ConnectionException.

 class ConnectionException extends Exception {
    public ConnectionException() {
        super();
    }
    public ConnectionException(String message) {
        super(message);
    }
}
 class WrongDataException extends Exception {
    public WrongDataException() {
        super();
    }
    public WrongDataException(String message) {
        super(message);
    }
}

 interface Connection {
    void connect() throws WrongDataException, ConnectionException;
    void write(Object data) throws WrongDataException, ConnectionException;
    Object read() throws WrongDataException, ConnectionException;
    void disconnect() throws WrongDataException, ConnectionException;
}

class SolutionException extends Exception {
    public SolutionException() {
        super();
    }
    public SolutionException(String message) {
        super(message);
    }
}


/*
Улучшения в Java 7 (multiple exceptions)
*/
 class Solution1 {
    private final Connection connection;

    public Solution1() throws SolutionException {
        try {
            connection = new ConnectionMock();
            connection.connect();
        }
        catch (WrongDataException|ConnectionException e) {
            throw new SolutionException(e.getClass().getSimpleName() + ": " + e.getMessage());
           // throw new SolutionException("ConnectionException: " + e.getMessage());
        }
//        catch (ConnectionException e) {
//            throw new SolutionException("ConnectionException: " + e.getMessage());
//        }
    }

    public void write(Object data) throws SolutionException {
        try {
            connection.write(data);
        }
        catch (WrongDataException|ConnectionException e) {
            throw new SolutionException(e.getClass().getSimpleName() + e.getMessage());
        }
//        catch (ConnectionException e) {
//            throw new SolutionException("ConnectionException: " + e.getMessage());
//        }
    }

    public Object read() throws SolutionException {
        try {
            return connection.read();
        }
        catch (WrongDataException|ConnectionException e) {
            throw new SolutionException(e.getClass().getSimpleName() + e.getMessage());
        }
//        catch (ConnectionException e) {
//            throw new SolutionException("ConnectionException: " + e.getMessage());
//        }
    }

    public void disconnect() throws SolutionException {
        try {
            connection.disconnect();
        }
        catch (WrongDataException|ConnectionException e) {
            throw new SolutionException(e.getClass().getSimpleName() + e.getMessage());
        }
//        catch (ConnectionException e) {
//            throw new SolutionException("ConnectionException: " + e.getMessage());
//        }
    }

    public static void main(String[] args) {

    }
}

 class ConnectionMock implements Connection {
    @Override
    public void connect() throws WrongDataException, ConnectionException {
    }

    @Override
    public void write(Object data) throws WrongDataException, ConnectionException {
    }

    @Override
    public Object read() throws WrongDataException, ConnectionException {
        return null;
    }

    @Override
    public void disconnect() throws WrongDataException, ConnectionException {

    }
}
