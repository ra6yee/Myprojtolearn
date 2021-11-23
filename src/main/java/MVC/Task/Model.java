package MVC.Task;

import java.util.List;

public class Model {
    public List<String> getStringDataList() {
        return new Service().getData();
    }
}
