/**
 * Created with IntelliJ IDEA.
 * User: curtis
 * Date: 2013-02-07
 * Time: 6:03 PM
 * To change this template use File | Settings | File Templates.
 */

/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.util.Scanner;

class Main implements Runnable {

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // Construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}

class myStuff implements Runnable {

    private StringBuilder output = new StringBuilder();

    public void run() {

        Scanner scan = new Scanner(System.in);
        Scanner lineReader;
        int number;


        // Take in first line to be tested
        lineReader = new Scanner(scan.nextLine());

        // Gets integer from first line
        number = lineReader.nextInt();

        // Does the main program as long as the next number is not 0
        while(number != 0)
        {

            // Find If number is Carmichael
            findCarmichael(number);

            // Take in next line to be tested
            lineReader = new Scanner(scan.nextLine());

            // Gets integer from next line
            number = lineReader.nextInt();

            if(number != 0)
                output.append("\n");

        }

        System.out.print(output.toString());
    }

    private void findCarmichael(int num)
    {
        // This tells us whether it passed the loop test or breaks out with a false
        boolean pass = true;
        boolean prime, gotPerfectSquare;
        double temp;

        for( int a = 2; a <= (num - 1); a++)
        {

            temp = Math.pow(a,num);

            if(( temp ) != a % num)
            {
                pass = false;
                break;
            }

        }

        //gotPerfectSquare = gotPerfectSquare(num);

        prime = isPrime(num);

        if(pass )
        {
            output.append("num " + num + " is a Prime");
        }
        else
            output.append("num " + num + " is normal");

    }

    private boolean isPrime(int num)
    {

        if(num <= 1)
            return false;
        if(num == 2)
            return true;
        if(num % 2 == 0)
            return false;

        int sRoot = (int)Math.sqrt(num * 1.0);

        for(int i = 3; i < sRoot; i+=2)
        {
            if(num % i == 0)
                return  false;
        }

        return true;

    }

    private boolean gotPerfectSquare(int num)
    {

        for(int i = 2; i < num; i++)
        {

            if(num % i == 0)
            {

                if(Math.sqrt(i) * Math.sqrt(i) == i)
                    return true;

            }

        }

        return  false;

    }
}
