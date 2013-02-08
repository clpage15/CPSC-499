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
import java.util.List;
import java.util.ArrayList;

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
    private List<Integer> primes = new ArrayList<Integer>();
    private List<Integer> carmichael = new ArrayList<Integer>();

    public void run() {

        Scanner scan = new Scanner(System.in);
        Scanner lineReader;
        int number;

        genPrimes(65000);

        // Take in first line to be tested
        lineReader = new Scanner(scan.nextLine());

        // Gets integer from first line
        number = lineReader.nextInt();

        // Does the main program as long as the next number is not 0
        while(number != 0)
        {
            //do work here
            if(isCarmicheal(number))
            {
                 output.append("The number " + number + " is a Carmichael number.");
            }
            else
            {
                output.append(number + " is normal.");
            }

            // Take in next line to be tested
            lineReader = new Scanner(scan.nextLine());

            // Gets integer from next line
            number = lineReader.nextInt();

            if(number != 0)
                output.append("\n");

        }

        System.out.print(output.toString());
    }

    //Generate all the prime numbers between 0 and n
    private void genPrimes(int n)
    {
        boolean[] compositeNum = new boolean[n];

        for (int i = 2; i < compositeNum.length; ++i)
        {
            if (!compositeNum[i])
            {
                primes.add(i);

                for (int j = i; j < compositeNum.length; j += i)
                {
                    compositeNum[j] = true;
                }
            }
        }
    }

    private boolean isCarmicheal(int number)
    {
       if(primes.contains(number))
       {
           return false;
       }

       return fermatTest(number);
    }

    private boolean fermatTest(int testPrimeNancy)
    {
        int randomNumberAlpha;

        for(randomNumberAlpha = 2; randomNumberAlpha < testPrimeNancy; randomNumberAlpha++)
        {
            if(squareAndMultiply(randomNumberAlpha,testPrimeNancy) != randomNumberAlpha)
            {
                return false;
            }
        }

        return true;
    }

    private int squareAndMultiply(int randomNumberAlpha, int testPrimeNancy)
    {
        int result = randomNumberAlpha;

        for(int i = 1; i < testPrimeNancy; i++)
        {
            result *= randomNumberAlpha;
            result %= testPrimeNancy;
        }

        return result;

    }
}
