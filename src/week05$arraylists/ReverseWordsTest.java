package week05$arraylists;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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

    public static void read(String inputLocation, List<String> list) throws IOException {
        //TODO: READ IN DATA FROM INPUT FILE LOCATION
        File file = new File(inputLocation);
        Scanner scanner = new Scanner(file);

        ArrayList<String> line = new ArrayList<>();



        //TODO: REVERSE LINES

        //TODO: REVERSE WORDS

        while (scanner.hasNext()) {
            String name = scanner.next();
            line.add(name);
        }

        for (int i = line.size() - 1; i >= 0; i--) {
            list.add(line.get(i));
        }


        scanner.close();
    }


    public static void write(String outputLocation, List<String> list) throws FileNotFoundException {
        //TODO : WRITE TO OUTPUT FILE LOCATION
        File file = new File("reverse_words.txt");
        PrintStream writer = new PrintStream(outputLocation);

        if (file.exists()) {
            for (int i = 0; i < list.size(); i++) {
                writer.println(list.get(i) + "\n");
            }
        }
        writer.close(); //close output stream

    }


    /*    public static void removeBookEnd(ArrayList<String> list){
            for (int i=0; i<list.size();i++){
                String word = list.get(i);
                if (word.endsWith("BookEnd")){
                    list.remove(i);
                    i--;
                }
            }
        }
    */
    public static void main(String[] args) throws IOException {
        String inputLocation = "." + File.separator + "data"
                + File.separator + "words.txt";

        String outputLocation = "." + File.separator + "src" + File.separator + "results"
                + File.separator + "reverse_words.txt";

        //TODO: update program to use an Array List

        ArrayList<String> list = new ArrayList<>();

        File inputFile = new File(inputLocation);
        File outputFile = new File(outputLocation);

        Scanner input = new Scanner(inputFile);
        PrintStream output = new PrintStream(outputFile);

        System.out.println();

        //TODO: process items in file

        read(inputLocation, list);


//        if (inputFile.exists()){
//            while (input.hasNext()){
//                list.add(input.nextLine());
//           }
//        }


//        removeBookEnd(list);

        write(outputLocation, list);

        for (String word : list) {
            output.print(word + " ");
        }


        System.out.println();
        input.close();
        output.close();

    }
}