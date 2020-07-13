package by.yuntsevich.proj;

import by.yuntsevich.proj.controller.Controller;
import by.yuntsevich.proj.service.ServiceException;

/**
 * class Application
 */
public class Application {

    //run application
    public static void main(String[] args) {
        Controller controller = new Controller();
        try {
            controller.executeTask();
        } catch (ServiceException e) {
            System.out.println("exception  + " + e);
        }

    }

}


