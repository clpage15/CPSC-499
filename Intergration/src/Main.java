/**
 * Created with IntelliJ IDEA.
 * User: curtis
 * Date: 2013-01-22
 * Time: 1:35 PM
 * To change this template use File | Settings | File Templates.
 */


/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.util.*;

class Main implements Runnable{


    public static void main(String args[])
    {
        Main myWork = new Main();
        myWork.run();
    }

    public void run() {
        new myStuff().run();
    }
}
class myStuff implements Runnable{

    public void run()
    {
        Scanner scan = new Scanner(System.in);
        StringBuilder output = new StringBuilder();

        while(scan.hasNextDouble())
        {
            double squareRadius = scan.nextDouble();
            double squareArea = squareRadius * squareRadius;
            double center = (Math.PI / 3 + 1 - Math.sqrt(3)) * squareArea;
            double leaves = (Math.PI / 3 - 4 + 2 * Math.sqrt(3)) * squareArea;
            double square = (4 - (2 * Math.PI) / 3 - Math.sqrt(3)) * squareArea;

            output.append(String.format("%.3f %.3f %.3f\n", center,leaves,square));
        }

        System.out.println(output.toString());
    }
}