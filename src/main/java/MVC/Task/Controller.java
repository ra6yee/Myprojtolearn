package MVC.Task;

import java.util.List;

public class Controller {


    public List<String> onShowDataList() {
        return new Model().getStringDataList();
    }
}
