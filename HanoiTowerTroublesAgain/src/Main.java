/**
 * User: Alex Reed
 * Date: 2013-01-22
 * Time: 1:35 PM
 *
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

    private ArrayList<Integer> stack = new ArrayList();
    private ArrayList<Integer> flipLocations = new ArrayList();
    String OrigLine = null;

    public void run()
    {

        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine())
        {

        }
    }
}