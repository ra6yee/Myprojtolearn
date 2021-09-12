package src.java.Многопоточность;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class volatile_code {
}
//Требования:
//        •
//        Класс Solution должен содержать public static final поле String DEFAULT_JAVARUSH_THREAD_NAME.
//        •
//        Класс Solution должен содержать private static final поле AtomicInteger createdThreadIndex.
//        •
//        Класс Solution должен содержать private static final поле AtomicInteger aliveThreadIndex.
//        •
//        Класс Solution должен содержать private static final поле Logger log.
//        •
//        Класс Solution должен содержать private static поле boolean debugSession.
//        •
//        Расставь volatile там, где необходимо.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////package com.javarush.task.task26.task2604;


/*
Для того, чтобы усовершенствовать ум, надо больше размышлять, чем заучивать
*/
 class Solution51 extends Thread {
    public static final String DEFAULT_JAVARUSH_THREAD_NAME = "JavaRushThread";

    private static final AtomicInteger createdThreadIndex = new AtomicInteger();
    private static final AtomicInteger aliveThreadIndex = new AtomicInteger();

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format", "%1$tF %1$tT %4$s %2$s %5$s%6$s%n");
    }

    private static final Logger log = Logger.getLogger(Solution51.class.getName());

    private volatile static boolean debugSession = true;

    public Solution51() {
        this(DEFAULT_JAVARUSH_THREAD_NAME);
    }

    public Solution51(String name) {
        super(name + "-" + createdThreadIndex.incrementAndGet());

        setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
            public void uncaughtException(Thread t, Throwable e) {
                log.log(Level.SEVERE, "An error occurred in thread " + t.getName(), e);
            }
        });
    }

    public static void main(String[] args) {
        new Solution51().start();
        new Solution51().start();
        new Solution51().start();
    }

    public void run() {

            boolean debug = debugSession;
            if (debug) {
                log.log(Level.INFO, "Created " + getName());
            }
            try {
                aliveThreadIndex.incrementAndGet();
                log.log(Level.INFO, "Thread " + getName() + " in progress...");
                throw new RuntimeException("Oops " + getName());
            } finally {
                aliveThreadIndex.decrementAndGet();
                if (debug) {
                    log.log(Level.INFO, "Exiting " + getName());
                }
            }

    }
    public static int getThreadsCreated() {
        return createdThreadIndex.get();
    }

    public static int getThreadsAlive() {
        return aliveThreadIndex.get();
    }

    public static boolean isDebug() {
        return debugSession;
    }

    public static void setDebug(boolean ds) {
        debugSession = ds;
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Расставь volatile там, где необходимо.
//Требования:
//        •
//        Класс Solution должен содержать private static поле ScheduledExecutorService interruptScheduledExecutor.
//        •
//        Класс Solution должен содержать private static поле Thread taskThread.
//        •
//        Класс Solution должен содержать private static поле RethrowableTask task.
//        •
//        Класс RethrowableTask должен содержать private поле Throwable throwable.
//        •
//        Класс RethrowableTask должен содержать private поле Runnable runnable.
//        •
//        Расставь volatile там, где необходимо.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////import java.util.concurrent.Executors;


/*
Трудолюбие - душа всякого дела и залог благосостояния
*/
class Solution77 {

    private static ScheduledExecutorService interruptScheduledExecutor;
    private static Thread taskThread;
    private static RethrowableTask task;

    public static void main(String[] args) throws Exception {
        runTaskBySchedule(new Runnable() {
                              @Override
                              public void run() {
                                  System.out.println("A");
                                  throw new RuntimeException("it's test");
                              }
                          }, 1_000, TimeUnit.MILLISECONDS
        );

        interruptScheduledExecutor.shutdown();
    }

    public static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit) throws Exception {
        task = new RethrowableTask(runnable);
        taskThread = new Thread(task);
        taskThread.start();

        interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
        interruptScheduledExecutor.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);
        Thread.sleep(unit.toMillis(timeout));
        try {
            task.rethrow();
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
    }

    public static class RethrowableTask implements Runnable {
        private volatile Throwable throwable;
        private Runnable runnable;

        public RethrowableTask(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            try {
                runnable.run();
            } catch (Throwable throwable) {
                this.throwable = throwable;
            }
        }

        public void rethrow() throws Exception {
            if (throwable != null) {
                System.out.println("B");
                throw new Exception(throwable);
            }
        }
    }
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////Расставь volatile там, где необходимо.
//Требования:
//        •
//        Класс Solution должен содержать private final поле URL javarushUrl.
//        •
//        Класс Solution должен содержать private final поле URL javarushUrl1Child.
//        •
//        Класс Solution должен содержать private final поле URL javarushVkGroupUrl.
//        •
//        Класс Solution должен содержать private final поле URL javarushVkGroupUrl1Child.
//        •
//        Класс Solution должен содержать private final поле URL javarushVkGroupUrl2Child.
//        •
//        Класс Solution должен содержать private final поле URL javarushVkGroupUrl3Child.
//        •
//        Класс Solution должен содержать private поле ExecutorService executorService.
//        •
//        Класс Solution должен содержать private поле Set<URL> urlsForProcessing.
//        •
//        Класс UrlTask должен содержать private final поле URL url.
//        •
//        Расставь volatile там, где необходимо.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////ackage com.javarush.task.task26.task2606;



/*
Тот, кто любит труд, не нуждается в развлечениях
*/
class Solution54 {
    private final URL javarushUrl;
    private final URL javarushUrl1Child;
    private final URL javarushVkGroupUrl;
    private final URL javarushVkGroupUrl1Child;
    private final URL javarushVkGroupUrl2Child;
    private final URL javarushVkGroupUrl3Child;

    private volatile ExecutorService executorService;
    private final Set<URL> urlsForProcessing = Collections.synchronizedSet(new HashSet<>());

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        Solution54 solution = new Solution54();
        solution.start();
        Thread.sleep(1000);
        solution.stop();
    }

    public Solution54() throws MalformedURLException {
        javarushUrl = new URL("http://javarush.ru/");
        javarushVkGroupUrl = new URL("http://vk.com/javarush");
        javarushUrl1Child = new URL("http://info.javarush.ru/page/FAQ/");
        javarushVkGroupUrl1Child = new URL("https://plus.google.com/114772402300089087607/about");
        javarushVkGroupUrl2Child = new URL("https://www.facebook.com/pages/Javarush/524321077686033");
        javarushVkGroupUrl3Child = new URL("https://twitter.com/javarush_ru");

        urlsForProcessing.add(javarushUrl);
        urlsForProcessing.add(javarushVkGroupUrl);
    }

    public synchronized void start() {
        executorService = Executors.newCachedThreadPool();
        for (URL url : urlsForProcessing) {
            submitUrlTask(url);
        }
        urlsForProcessing.clear();
    }

    public synchronized void stop() throws InterruptedException {
        try {
            saveUnprocessedUrls(executorService.shutdownNow());
            if (executorService.awaitTermination(1_000, TimeUnit.MILLISECONDS)) {
                saveUnprocessedUrls(getCancelledTasksFromExecutor());
            }
        } finally {
            executorService = null;
        }
    }

    private List<Runnable> getCancelledTasksFromExecutor() {
        return Collections.EMPTY_LIST;
    }

    protected List<URL> processPage(URL url) {
        System.out.println(url + " will be processed");
        return getChildUrlByParent(url);
    }

    private List<URL> getChildUrlByParent(URL url) {
        List<URL> result = new ArrayList<>();

        if (javarushUrl.equals(url)) {
            result.add(javarushUrl1Child);
        } else if (javarushVkGroupUrl.equals(url)) {
            result.add(javarushVkGroupUrl1Child);
            result.add(javarushVkGroupUrl2Child);
            result.add(javarushVkGroupUrl3Child);
        }
        return result;
    }

    private void saveUnprocessedUrls(List<Runnable> unprocessed) {
        for (Runnable task : unprocessed) {
            urlsForProcessing.add(((UrlTask) task).getPage());
        }
    }

    private void submitUrlTask(URL url) {
        executorService.execute(new UrlTask(url));
    }

    public class UrlTask implements Runnable {
        private final URL url;

        private UrlTask(URL url) {
            this.url = url;
        }

        public void run() {
            for (URL link : processPage(url)) {
                if (Thread.currentThread().isInterrupted()) return;
                submitUrlTask(link);
            }
        }

        public URL getPage() {
            return url;
        }
    }
}
