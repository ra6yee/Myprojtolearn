package MVC.Task;

public class View {
    public void fireShowDataEvent() {
        System.out.println(new Controller().onShowDataList());
    }
}
