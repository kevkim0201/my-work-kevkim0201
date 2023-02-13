package modules;

import functions.Fib;

import java.sql.Array;

/****************************************************************
 * This module is included for the Fibonacci Recursion Exercise
 ****************************************************************/

public class FibModule {

    public static long fib(int n) {
        //TODO : COMPLETE BODY OF RECURSIVE METHOD

        if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }
        else{
            return fib(n-1) + fib(n-2);
        }

    }


    public static long ifib(int n) {
        //TODO : COMPLETE BODY OF ITERATIVE METHOD

        if (n <= 1){
            return n;
        }

        int fib = 1;
        int prevNumber = 1;

        for (int i = 2; i<n; i++){
            int temp = fib;
            fib = fib + prevNumber;
            prevNumber = temp;
        }
        return fib;

    }



    public static long mfib(int n) {
        //TODO : COMPLETE BODY OF MEMOIZATION METHOD

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            long[] x = new long[n];
            x[0] = 0;
            x[1] = 1;

            if (n != 2){
                x[n-1] = memo(n-1, x);
            }

            return x[n-1] + x[n-2];
        }
    }

    private static long memo(int n, long[] x) {
        //TODO : COMPLETE BODY OF MEMOIZATION HELPER METHOD

        if (x[n] == 0){
            x[n] = memo(n-1,x) + x[n-2];
        }
        return x[n];
    }


    /****************************************************************
     * prints large value sequence in lines. This uses a functional
     * programming approach to print out the data.
     ****************************************************************/
    public static void largePrint(Fib f, int n){
        System.out.println("============ R E S U L T S  ============");
        System.out.println();
        System.out.println();
        System.out.println("====== Large Value Printing Ahead ====== ");
        System.out.println();

        //PRINTS : value for nth factorial
        System.out.println("\t \t n \t \t value");
        for (int i = 0; i <= n; i++ ) {
            String str1 = String.format("\t \t %d \t \t %d \n", i, f.fib(i));
            String str2 = String.format("\t \t %d \t %d \n", i, f.fib(i));

            //TERNARY OPERATOR
            String fString = (i < 10) ? str1 : str2;
            System.out.print(fString);
        }

        System.out.println();
    }


    /****************************************************************
     * prints nth Fibonacci. This uses a functional programming
     * approach to print out the data.
     ****************************************************************/
    public static void print(Fib f, int n){
        System.out.println("============== nth Fibonacci ============");

        // PRINTS : count of nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", i);
        }
        System.out.println();

        //PRINTS : value for nth factorial
        for (int i = 0; i <= n; i++ ) {
            System.out.printf("%d \t", f.fib(i));
        }
        System.out.println();
    }

}
