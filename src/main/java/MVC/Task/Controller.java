package MVC.Task;

import java.util.List;

public class Controller {


    public List<String> onShowDataList() {
        return new Model().getStringDataList();
    }

    /*
        MVC - простая версия
        */
    public static class Solution {
        public static void main(String[] args) {
            new View().fireShowDataEvent();
        }


        }
}
