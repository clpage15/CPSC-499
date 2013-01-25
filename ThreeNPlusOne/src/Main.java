/*
 * Main.java
 *  java program model for www.programming-challenges.com
 */

import java.io.*;
import java.util.*;

class Main implements Runnable {

    public static void main(String args[])  // entry point from OS
    {
        Main myWork = new Main();  // construct the bootloader
        myWork.run();            // execute
    }

    public void run() {
        new myStuff().run();
    }
}

class myStuff implements Runnable {
    public void run() {


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int largeNum = -1;
            int smallNum = -1;

            if (a > b) {
                largeNum = a;
                smallNum = b;
            } else {
                smallNum = a;
                largeNum = b;
            }

            int[] nums = new int[largeNum - smallNum + 1];


            for (int i = 0; i < nums.length; i++) {
                nums[i] = smallNum + i;
            }

            int largest = 0;

            for (int x : nums) {
                int temp = calcLength(x);
                if (temp > largest)
                    largest = temp;

            }
            System.out.println(a + " " + b + " " + largest);
        }
    }

    public static int calcLength(int num) {
        int iterations = 1;

        while (num > 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }

            iterations++;
        }

        return iterations;
    }
}

