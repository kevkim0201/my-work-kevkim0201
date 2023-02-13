package modules;

public class RecModule {

    public static int fac(int n) {
        //TODO: COMPLETE BODY

        int facNum; // value that holds the factorial of a number

        if (n <= 1){
            facNum = 1;
        }
        else {
            facNum = n * fac(n-1);
        }
        return facNum;
    }

    public static boolean isPalindrome(String s) {
        //TODO : COMPLETE BODY

        if (s.length() == 1 || s.length() == 0){
            return true;
        }
        else if (s.charAt(0) == s.charAt(s.length()-1)) {
            return (isPalindrome(s.substring(1,s.length()-1)));
        }

        return false;
    }

    public static double pow(double x, int n) {
        //TODO: COMPLETE BODY

        double answer;

        if (n == 0){
            answer = 1;
            return answer;
        }
        else if (n == 1){
            answer = x;
            return answer;
        }
        else {
            answer = x * pow(x, n-1);
        }

        return answer;
    }

    public static int sum(int n) {
        //TODO : COMPLETE BODY

        int totalSum;

        if (n == 0){
            totalSum = 0;
            return totalSum;
        }
        else if (n == 1){
            totalSum = 1;
            return totalSum;
        }
        else {
            totalSum = n + sum(n-1);
        }
        
        return totalSum;
    }

}
