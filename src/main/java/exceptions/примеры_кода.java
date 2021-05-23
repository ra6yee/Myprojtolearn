package exceptions;

import java.io.CharConversionException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.FileSystemException;
import java.rmi.RemoteException;

public class примеры_кода {
}
/*
Исключение при работе с числами
*/

class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код

        try {
            int a = 42 / 0;
        } catch (ArithmeticException e) {
            e.getMessage();          // красный шрифт
            e.printStackTrace();
            System.out.println(e); // обычный шрифт вывода
        }

        //напишите тут ваш код
    }
}
/*
Исключение при работе со строками
*/

class Solution2 {
    public static void main(String[] args) {
        //напишите тут ваш код

        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        //напишите тут ваш код
    }
}
/*
Исключение при работе с массивами
*/

class Solution3 {
    public static void main(String[] args) {
        //напишите тут ваш код

        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println(e);
        }

        //напишите тут ваш код
    }
}
/*
Исключения. Просто исключения.
*/

class Solution4 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        try {
            method1();
        } catch (NullPointerException e) {
            e.printStackTrace();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //напишите тут ваш код
    }

    public static void method1() throws NullPointerException, ArithmeticException, FileNotFoundException, URISyntaxException {
        int i = (int) (Math.random() * 4);
        if (i == 0) {
            throw new NullPointerException();
        } else if (i == 1) {
            throw new ArithmeticException();
        } else if (i == 2) {
            throw new FileNotFoundException();
        } else if (i == 3) {
            throw new URISyntaxException("", "");
        }
    }
}
/*
Группа перехвата исключений
*/

class Solution5 {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код


            try {
                method1();
            } catch (Exception3 exception3) {
                exception3.printStackTrace();
            }catch (Exception2 exception2) {
                exception2.printStackTrace();
            }catch (Exception1 exception1) {
                exception1.printStackTrace();
            }


            //напишите тут ваш код

    }


    public static void method1() throws Exception1, Exception2, Exception3 {
        int i = (int) (Math.random() * 3);
        if (i == 0) {
            throw new Exception1();
        } else if (i == 1) {
            throw new Exception2();
        } else if (i == 2) {
            throw new Exception3();
        }
    }
}

class Exception1 extends Exception {
}

class Exception2 extends Exception1 {
}

class Exception3 extends Exception2 {
}
/*
Перехват выборочных исключений
*/

class Solution6 {
    public static StatelessBean BEAN = new StatelessBean();

    public static void main(String[] args) throws IOException {
        handleExceptions();
    }

    public static void handleExceptions() throws IOException,FileSystemException {
        try {
            BEAN.methodThrowExceptions();
        } catch (FileSystemException e) {
            BEAN.log(e);
            throw e;
        }catch (CharConversionException e) {
            BEAN.log(e);

        }catch (IOException e) {
            BEAN.log(e);

        }
    }

    public static class StatelessBean {
        public void log(Exception exception) {
            System.out.println(exception.getMessage() + ", " + exception.getClass().getSimpleName());
        }

        public void methodThrowExceptions() throws CharConversionException, IOException {
            int i = (int) (Math.random() * 3);
            if (i == 0) {
                throw new CharConversionException();
            } else if (i == 1) {
                throw new FileSystemException("");
            } else if (i == 2) {
                throw new IOException();
            }
        }
    }
}
/*
Перехват checked-исключений
*/

class Solution7 {
    public static void main(String[] args) {
        handleExceptions(new Solution7());

    }

    public static void handleExceptions(Solution7 obj) {
        try {
            obj.method1();
            obj.method2();
            obj.method3();
        }  catch (IndexOutOfBoundsException | NumberFormatException | IOException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public void method1() throws IOException {
        throw new IOException();
    }

    public void method2() throws NoSuchFieldException {
        throw new NoSuchFieldException();
    }

    public void method3() throws RemoteException {
        throw new RemoteException();
    }
}
