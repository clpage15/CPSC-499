/**
 * Created with IntelliJ IDEA.
 * User: curtis
 * Date: 2013-01-22
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.util.*;

class Main implements Runnable{


    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{



    public void run()
    {



    }
}
