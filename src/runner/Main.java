package runner;

import controller.Controller;
import model.Info;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Info info = new Info();
        Controller ctr = new Controller(info);
        new MainFrame(ctr);
    }

}
//TODO переписать контроллер и MainFrame в соответствии с mvc-моделью
//gardenBeds в лист