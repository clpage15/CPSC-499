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


    public void run() {

        Scanner scan = new Scanner(System.in);
        Scanner lineReader;
        int runs;
        StringBuilder output = new StringBuilder();

        //The first line of the input contains a single integer T indicating the number of test cases (1 ≤ T ≤ 50).
        lineReader = new Scanner(scan.nextLine());
        runs = lineReader.nextInt();

        for (int runCount = 0; runCount < runs; runCount++)
        {
            //Each test case contains a single integer N (1 ≤ N ≤ 50) indicating the number of pegs available.
            lineReader = new Scanner(scan.nextLine());
            int pegs = lineReader.nextInt();

            int[] hanoiTowers = new int[pegs];

            //Start with ball No. 1
            int ball = 1;

            boolean wasPlaced = false;

            int ballCount = 0;

            //This version consists of N pegs and one ball containing each number from 1, 2, 3, . . . , ∞.
            while (true)
            {
                //System.out.println(hanoiTowers.length);

                for (int currentPeg = 0; currentPeg < hanoiTowers.length; currentPeg++)
                {
                    wasPlaced = false;
                    if (hanoiTowers[currentPeg] == 0 || isPerfectSquare(hanoiTowers[currentPeg] + ball))
                    {
                        //Add ball to empty peg
                        hanoiTowers[currentPeg] = ball;

                        //Indicate ball was placed and count
                        wasPlaced = true;
                        ballCount++;

                        //Move on to next ball
                        break;
                    }

                }

                //Ball wasn't placed; break out of loop and print
                if (!wasPlaced) {
                    output.append(ballCount);

                    if(runCount < runs)
                        output.append("\n");

                    break;
                }
                //Ball was placed; continue loop and grab next ball
                else
                {
                    //Grab next ball
                    ball++;
                }
            }
        }

        System.out.print(output.toString());
    }

    public final static boolean isPerfectSquare(int n) {
        if (n < 0)
            return false;

        int tst = (int) Math.sqrt(n);
        return tst * tst == n;
    }
}