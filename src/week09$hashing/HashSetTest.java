//package week09$hashing;
//
//import utils.Set;
//import utils.HashSet;
//
//public class HashSetTest {
//
//    public static void intro(){
//        System.out.println();
//        System.out.println();
//        System.out.println(" \t \t \t   W E L C O M E  ");
//        System.out.println();
//        System.out.println(" \t \t \t  H A S H   S E T ");
//        System.out.println(" \t \t T E S T   P R O G R A M");
//        System.out.println();
//        System.out.println();
//
//    }
//
//    public static void main(String[] args) {
//        intro();
//
//        Set<String> set = new HashSet<>();
//
//        System.out.println("====================  A  D   D   ======================");
//        System.out.println();
//        //test your add method
//        set.add("Orange");
//        set.add("Peach");
//        set.add("Mango");
//        set.add("Apple");
//        set.add("Banana");
//        System.out.println(set);
//        System.out.println();
//        System.out.println();
//
//        // test for size
//        System.out.println("====================  S  I Z  E  ======================");
//        System.out.println();
//        set.add("Kiwi");
//        System.out.println(set);
//        System.out.println("Size = " + set.size());
//        System.out.println();
//        set.add("Plum");
//        System.out.println(set);
//        System.out.println("Size = " + set.size());
//        System.out.println();
//        System.out.println();
//
//        // test our "remove" method
//        System.out.println("====================  R E M O V E  ======================");
//        System.out.println();
//        set.remove("Raisin");
//        System.out.println(set);
//        System.out.println("Size of container: " + set.size());
//        System.out.println();
//
//        //test for our "contains" method
//        System.out.println("====================  C O N T A I N S  ======================");
//        System.out.println();
//        System.out.println("RModule for Bart: \t" + set.contains("Apple"));
//        System.out.println("RModule for Bob: \t" + set.contains("Orange"));
//        System.out.println("RModule for Bob: \t" + set.contains("Prune"));
//        System.out.println();
//
//
//        // test for the "clear" method
//        System.out.println("====================  C L E A R  ======================");
//        System.out.println();
//        set.clear();
//        System.out.println(set);
//        System.out.println("Size of container: " + set.size());
//        System.out.println();
//
//        // test for the "isEmpty" method
//        System.out.println("====================  I S   E M P T Y  ======================");
//        System.out.println();
//        System.out.println("Is the set empty? " + set.isEmpty());
//        System.out.println();
//
//    }
//
//}
//
//
//
