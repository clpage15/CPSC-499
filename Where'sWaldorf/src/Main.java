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

    private Scanner scan = new Scanner(System.in);
    private char[][] letter;
    private String[] Words;
    private ArrayList<Integer> location;
    private int height, width, numOfWords, runs, runCount;

    public void run()
    {

        // Take in number for program loop count
        Scanner findInt = new Scanner(scan.nextLine());

        runs = findInt.nextInt();

        for(runCount = 0; runCount < runs; runCount++)
        {
            // Makes new location table
            location = new ArrayList<Integer>();

            // Skips a blank line
            scan.nextLine();

            // Takes in the grid size and make a grid of that size
            Scanner GridSize = new Scanner(scan.nextLine());

            height = GridSize.nextInt();

            width = GridSize.nextInt();

            //System.out.println(height + " " + width);

            letter = new char[height][width];


            // Fills the grid it all of the letters
            fillTable();

            // Take in number to tell the program on how many words to look for
            findInt = new Scanner(scan.nextLine());
            numOfWords = findInt.nextInt();

            // Fills table with word to look for
            getWords();

            // Finds the word within the table
            findWords();

            // Prints out the locations
            printLocations();



        }

    }

    public void fillTable()
    {

        String Gridline;

        for(int h = 0; h < height; h++)
        {

            Gridline = scan.nextLine().toLowerCase();

            for(int w = 0; w < width; w++)
            {

                letter[h][w] = Gridline.charAt(w);

            }

        }

    }

    public void getWords()
    {

        Words = new String[numOfWords];

        for(int i = 0; i < numOfWords; i++)
        {

            Words[i] = scan.nextLine().toLowerCase();

        }

    }

    public void findWords()
    {

        boolean found = false;

        for(String Word : Words)
        {

            for(int h = 0; h < height; h++)
            {

                for(int w = 0; w < width; w++)
                {

                    if(Word.charAt(0) == letter[h][w])
                    {

                        found = findNextLetters(Word, 1, h, w);

                    }
                    if(found)
                    {

                        location.add(h+1);
                        location.add(w+1);

                        //System.out.println(h+1 + " " + w+1);

                        break;

                    }

                }
                if(found) break;

            }

            found = false;

        }


    }

    public boolean findNextLetters(String Word, int nextCharSpot, int h, int w)
    {

        boolean test = false;

        // Found the word
        if(nextCharSpot == Word.length())  return true;

        else
        {

            if(test == false)
            {

                test = findUp(Word, nextCharSpot, h, w);

            }

            if(test == false)
            {

                test = findRightUp(Word, nextCharSpot, h, w);

            }

            if(test == false)
            {

                test = findRight(Word, nextCharSpot, h, w);

            }

            if(test == false)
            {

                test = findRightDown(Word, nextCharSpot, h, w);

            }

            if(test == false)
            {

                test = findDown(Word, nextCharSpot, h, w);

            }

            if(test == false)
            {

                test = findLeftDown(Word, nextCharSpot, h, w);

            }

            if(test == false)
            {

                test = findLeft(Word, nextCharSpot, h, w);

            }

            if(test == false)
            {

                test = findLeftUp(Word, nextCharSpot, h, w);

            }

            return test;

        }



    }

    public boolean findLeft(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of bounds
        else if(w-1 < 0) return false;

            // Check left
        else if(Word.charAt(nextCharSpot) == letter[h][w-1])
        {
            return findLeft(Word, nextCharSpot + 1, h, w-1);
        }

        else return false;
    }

    public boolean findLeftUp(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of range
        else if(w-1 < 0 || h-1 < 0) return false;

            // Check leftup
        else if(Word.charAt(nextCharSpot) == letter[h-1][w-1])
        {
            return findLeftUp(Word, nextCharSpot + 1, h-1, w-1);
        }

        else return false;
    }

    public boolean findUp(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of range
        else if(h-1 < 0) return false;

            // Check up
        else if(Word.charAt(nextCharSpot) == letter[h-1][w])
        {
            return findUp(Word, nextCharSpot + 1, h-1, w);
        }

        else return false;
    }

    public boolean findRightUp(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of range
        else if(h-1 < 0 || w+1 >= width) return false;

            // Check Rightup
        else if(Word.charAt(nextCharSpot) == letter[h-1][w+1])
        {
            return findRightUp(Word, nextCharSpot + 1, h-1, w+1);
        }

        else return false;
    }

    public boolean findRight(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of range
        else if(w+1 == width) return false;

            // Check right
        else if(Word.charAt(nextCharSpot) == letter[h][w+1])
        {
            return findRight(Word, nextCharSpot + 1, h, w+1);
        }

        else return false;
    }

    public boolean findRightDown(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of range
        else if(h+1 >= height || w+1 >= width) return false;

            // Check rightdown
        else if(Word.charAt(nextCharSpot) == letter[h+1][w+1])
        {
            return findRightDown(Word, nextCharSpot + 1, h+1, w+1);
        }

        else return false;
    }

    public boolean findDown(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of range
        else if(h+1 >= height) return false;

            // Check down
        else if(Word.charAt(nextCharSpot) == letter[h+1][w])
        {
            return findDown(Word, nextCharSpot + 1, h+1, w);
        }

        else return false;
    }

    public boolean findLeftDown(String Word, int nextCharSpot, int h, int w)
    {
        // Found the word
        if(nextCharSpot == Word.length())  return true;

            // Out of range
        else if(h+1 >= height || w-1 < 0) return false;

            // Check leftdown
        else if(Word.charAt(nextCharSpot) == letter[h+1][w-1])
        {
            return findLeftDown(Word, nextCharSpot + 1, h+1, w-1);
        }

        else return false;
    }

    public void printLocations()
    {

        StringBuilder sb;

        for(int i = 0; i < location.size()/2; i++)
        {
            sb = new StringBuilder();

            sb.append(location.get(i*2));
            sb.append(' ');
            sb.append(location.get((i*2)+1));

            System.out.println(sb.toString());

        }

        if(runCount + 1 < runs)
        {
            System.out.println();
        }

    }
}

