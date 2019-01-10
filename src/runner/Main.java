package runner;

import controller.Controller;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Controller ctr = new Controller();
        new MainFrame(ctr);
    }
}
//убрать в конструкторах bool smth = false;