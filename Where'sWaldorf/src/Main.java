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

import java.security.PrivateKey;
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

    private Scanner scan = new Scanner(System.in);
    private char[][] letter;
    private int height, width, numOfWords;

    public void run()
    {

        // Take in number for program loop count
        int runs = scan.nextInt();

        for(int i = 0; i < runs; i++)
        {
           scan = new Scanner(System.in);

            // Skips a blank line
            scan.skip("\n");

            // Takes in the grid size and make a grid of that size
            Scanner GridSize = new Scanner(scan.nextLine());

            height = GridSize.nextInt();

            width = GridSize.nextInt();

            //System.out.println(height + " " + width);

            letter = new char[height][width];


            // Fills the grid it all of the letters
            fillTable();

            // Take in number to tell the program on how many words to look for
            numOfWords = scan.nextInt();

            // Fills table with word to look for
            getWords();


        }

    }

    public void fillTable()
    {

        String Gridline;

        for(int h = 0; h < height; h++)
        {

            Gridline = scan.nextLine();

            for(int w = 0; w < width; w++)
            {

                letter[h][w] = Gridline.charAt(w);

            }

        }

    }

    public void getWords()
    {

        String[] Words = new String[numOfWords];

        scan = new Scanner(System.in);

        for(int i = 0; i < numOfWords; i++)
        {

            Words[i] = scan.nextLine();

        }

    }
}
