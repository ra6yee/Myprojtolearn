package src.java.UncaughtExceptionHandler;
import java.awt.*;
import java.io.*;
import javax.swing.*;
public class code {
}


 class StackWindow extends JFrame
        implements Thread.UncaughtExceptionHandler {

    private JTextArea textArea;

    public StackWindow(
            String title, final int width, final int height) {
        super(title);
        setSize(width, height);
        textArea = new JTextArea();
        JScrollPane pane = new JScrollPane(textArea);
        textArea.setEditable(false);
        getContentPane().add(pane);
    }

    public void uncaughtException(Thread t, Throwable e) {
        addStackInfo(e);
    }

    public void addStackInfo(final Throwable t) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
                toFront();
                StringWriter sw = new StringWriter();
                PrintWriter out = new PrintWriter(sw);
                t.printStackTrace(out);
                textArea.append(sw.toString());
            }
        });
    }
}
class DumpTest {
    public static void main(final String args[]) throws Exception {
        Thread.UncaughtExceptionHandler handler = new StackWindow(
                "Show Exception Stack", 600, 300);
        Thread.setDefaultUncaughtExceptionHandler(handler);
        new Thread() {
            public void run() {
                System.out.println(1 / 0);
            }
        }.start();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Press Enter for next exception");
        br.readLine();
        new Thread() {
            public void run() {
                System.out.println(args[0]);
            }
        }.start();
        System.out.print("Press Enter to end");
        br.readLine();
        System.exit(0);
    }
}