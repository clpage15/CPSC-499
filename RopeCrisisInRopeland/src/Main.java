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

    String OrigLine = null;

    public void run()
    {


        Scanner scan = new Scanner(System.in);
        StringBuilder output = new StringBuilder();
        Scanner lineReader;
        float x1 = 0, x2 = 0, y1 = 0, y2 = 0, r = 0;

        lineReader = new Scanner(Scanner.nextLine());

        int testCases = lineReader.nextInt();

        for(int i = 0; i <= testCases; i++)
        {
            x1 = lineReader.nextFloat();
            y1 = lineReader.nextFloat();
            x2 = lineReader.nextFloat();
            y2 = lineReader.nextFloat();
            r = lineReader.nextFloat();
        }

        calculateLengthOfRope(x1, y1, x2, y2, r);
    }

    private void calculateLengthOfRope(float x1, float x2, float y1, float y2, float r)
    {

         double a =
         double b =
         double c =

         double C




    }

    private void calculateTangentsAndArc()
    {



    }

}