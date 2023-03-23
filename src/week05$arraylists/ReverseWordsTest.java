package week05$arraylists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseWordsTest {
    public static void intro() {
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t \t  R  E  V  E  R  S  E    F  I  L  E    T  E  S  T");
        System.out.println(" \t \t      T E S T    P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("========================================================");
        System.out.println();
        System.out.println();
    }

    public static void read(String inputLocation, List<String> list) throws FileNotFoundException {
        //TODO: READ IN DATA FROM INPUT FILE LOCATION
        File file = new File(inputLocation);

        // open up an input file stream
        Scanner scanner = new Scanner(file);

        // store words in reverse for each line
        ArrayList<String> reverseList = new ArrayList<>();

        // read in data with scanner
        while (scanner.hasNextLine()) {

            // grab the next line in file
            String line = scanner.nextLine();

            // break up words in line and put them in index
            String[] array = line.split(" ");

        //TODO: REVERSE WORDS
            // reverse the words and store them the arrayList
            for (String word : array) {
                reverseList.add(0, word);
            }

            StringBuilder string = new StringBuilder();

            // add line back to the overall list in reverse
            for (String word : reverseList) {
                string.append(word).append(" ");
            }

        //TODO: REVERSE LINES
            // add each line in reverse to list
            list.add(0, string.toString());

            // clear words in each line
            reverseList.clear();
        }

        // close input stream
        scanner.close();
    }


    public static void write(String outputLocation, List<String> list) throws FileNotFoundException {

        //TODO : WRITE TO OUTPUT FILE LOCATION
        PrintStream writer = new PrintStream(outputLocation);

        // traverse the list and get each item at each index
        for (String line : list) {
            writer.println(line);
        }

        writer.close(); //close output stream

    }

    public static void main(String[] args) throws FileNotFoundException {
        String inputLocation = "." + File.separator + "data"
                + File.separator + "words.txt";

        String outputLocation = "." + File.separator + "src" + File.separator + "results"
                + File.separator + "reverse_words.txt";

        //TODO: update program to use an Array List

        ArrayList<String> list = new ArrayList<>();

        //TODO: process items in file
        read(inputLocation, list);
        write(outputLocation, list);

    }
}