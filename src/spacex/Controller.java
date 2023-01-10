package spacex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    static String csvFileHeader;

    private static Mission parse(String line) throws IllegalArgumentException {
        String[]    str	    = line.split(",");
        String[]	column	= new String[16];

        //copy data into larger array to fix issues with splitting
        for (int i = 0; i < str.length; i++)
            column[i] = str[i];


        // null values at the end set to empty
        if(str.length < column.length) {
            for (int i = str.length; i < column.length; i++) {
                column[i] = "";
            }
        }

        //TODO : Update the data with the values in the CSV file
        String	    flightNumber    = "";
        Date        launchDate		= new Date();
        Time        launchTime		= new Time();
        String      launchSite    	= "";
        String      vehicleType  	= "";
        double      mass			= 0.0;
        Payload     payload			= new Payload();
        Customer    customer		= new Customer();
        String		missionOutcome  = "";
        String		failureReason  	= "";
        String		landingType  	= "";
        String		landingOutcome  = "";

        //TODO: return Mission object using the builder pattern
        return null;
    }


    public static void read(List<Mission> list, String inputLocation) throws FileNotFoundException {
        File 	file	= new File(inputLocation);
        Scanner input	= new Scanner(file);

        Mission missionData;

        //TODO: read in mission data and table header
        input.close();
    }



    public static void writeCustomersInOrder(List<Mission> list, String customer, String outputLocation)
            throws FileNotFoundException{
        String 		csvLocation	= outputLocation + File.separator + customer + ".csv";
        String 		txtLocation	= outputLocation + File.separator + customer + ".txt";
        File   		csvFile		= new File(csvLocation);
        File   		txtFile		= new File(txtLocation);
        PrintStream csvStream 	= new PrintStream(csvFile);
        PrintStream txtStream 	= new PrintStream(txtFile);

        Customer  missionCustomer;
        Mission	  mission;

        //TODO: get mission data with customer name.

        csvStream.close();
        txtStream.close();

    }

    public static void writePayloadsByOrder(List<Mission> list, String outputLocation) throws FileNotFoundException {
        String 		csvLocation	= outputLocation + File.separator + "ordered_payload.csv";
        String 		txtLocation	= outputLocation + File.separator + "ordered_payload.txt";
        File   		csvFile		= new File(csvLocation);
        File   		txtFile		= new File(txtLocation);
        PrintStream csvStream 	= new PrintStream(csvFile);
        PrintStream txtStream 	= new PrintStream(txtFile);

        //TODO: sort payloads and order in a separate output file.

        csvStream.close();
        txtStream.close();
    }

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t  S P A C E   X    T E S T    P R O G R A M");
        System.out.println();
        System.out.println(" \t    S    T    A    R    T    I    N    G");
        System.out.println();
        System.out.println("==================================================");
        System.out.println();
        System.out.println();
    }


    public static void main(String[] args) throws FileNotFoundException {

        String outputLocation  = "." + File.separator + "results";

        String inputLocation    = "." + File.separator + "data"
                                      + File.separator + "spacex_mission_data.csv";


//        System.out.println();
//        //TODO: print intro to console
//        intro();
//
//        //TODO: set list for data entry
//        List<Mission> list     = new ArrayList<>();
//
//
//        //TODO: set locations, read and write files


        System.out.println();


    }
}
