/**
 * Created with IntelliJ IDEA.
 * User: Curtis
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
        String nextLine = null;
        StringBuilder output = new StringBuilder();

        Scanner scan = new Scanner(System.in);

        while(scan.hasNextLine())
        {
            nextLine  = scan.nextLine();

            Scanner line = new Scanner(nextLine);

            double squareRadius = line.nextDouble();

            // We will need the area of the square later, let's store this value for now
            double squareArea = squareRadius * squareRadius;

            // See this link to understand circular cutouts...http://skepticsplay.blogspot.ca/2011/02/solutions-to-circular-cutouts.html
            // Using the diagram and rational in above link, we can calculate the center.
            double center = (Math.PI / 3 + 1 - Math.sqrt(3)) * squareArea;
            double leaves = (Math.PI / 3 - 4 + 2 * Math.sqrt(3)) * squareArea;
            double square = (4 - (2 * Math.PI) / 3 - Math.sqrt(3)) * squareArea;

            System.out.print(String.format("%.3f %.3f %.3f\n", center,leaves,square));
        }
    }
}