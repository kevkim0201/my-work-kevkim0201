package week05$arraylists;


public class ArrayListTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t M Y   A R R A Y   L I S T ");
        System.out.println(" \t \t T E S T   P R O G R A M");
        System.out.println();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println();
        System.out.println();
    }

    public static void libraryVersionTest(){
        java.util.ArrayList<String> list = new java.util.ArrayList<String>();
        list.add("Tom");
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        list.add("Tim");
        list.add(3, "Ken");
        System.out.println(list.size());
        System.out.println(list);
        list.remove(1);
        System.out.println(list.size());
        System.out.println(list);
        System.out.println("Item Removed : " + list.remove("John"));
        System.out.println("Item Removed : " + list.remove("Henry"));
        System.out.println(list.size());
        System.out.println(list);
    }

    public static void myVersionTest(){
        //TODO : Create println tests for each of your ArrayList methods
        java.util.ArrayList<String> list = new java.util.ArrayList<String>();
        list.add("Tom");
        list.add("Ben");
        list.add("Sam");
        list.add("John");
        list.add("Tim");
        System.out.println(list.size());
        System.out.println(list);
    }

    public static void main(String[] args) {
        intro();
        libraryVersionTest();
        myVersionTest();
    }
}
