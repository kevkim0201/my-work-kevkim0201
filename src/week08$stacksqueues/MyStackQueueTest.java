package week08$stacksqueues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import utils.MyQueue;
import utils.MyStack;

public class MyStackQueueTest {

    public static void intro(){
        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println(" \t \t \t \t  W E L C O M E  ");
        System.out.println();
        System.out.println(" \t S T A C K    Q U E U E");
        System.out.println(" \t T E S T    P R O G R A M");
        System.out.println();
        System.out.println("----------------------------------------------------");
        System.out.println();
        System.out.println();
    }

    public static void libraryQueueVersionTest(){
        System.out.println();
        System.out.println("<-----\t  L  I  B  R  A  R  Y  \t\t  Q  U  E  U  E \t ----->");
        System.out.println();

        Queue<String> queue  = new LinkedList<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();

        queue.add("Red");
        queue.add("Orange");
        queue.add("Yellow");
        queue.add("Green");
        queue.add("Blue");
        queue.add("Indigo");
        queue.add("Violet");
        System.out.println(queue);
        System.out.println();
        System.out.println();
        System.out.println();

        //test remove
        System.out.println("----------- Test remove/ size /isEmpty -----------");
        System.out.println();
        System.out.println("----------original-----------");
        System.out.println("size: " + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println();
        System.out.println("----------1st remove-----------");
        System.out.println("Remove element: " + queue.remove());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------2nd remove-----------");
        System.out.println("Remove element: " + queue.remove());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------3rd remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------4th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------5th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------6th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------7th remove-----------");
        System.out.println("Remove element: "   + queue.remove());
        System.out.println("isEmpty? "          + queue.isEmpty());
        System.out.println("size: "             + queue.size());
        System.out.println(queue);
        System.out.println();
        System.out.println("----------isEmpty() peek -----------");
        System.out.println("Remove element: " + queue.peek());
        System.out.println("isEmpty? "        + queue.isEmpty());
        System.out.println("size: "           + queue.size());
        System.out.println(queue);
        System.out.println();

        //test peek
        System.out.println("----------- Test peek -----------");
        queue1.add("Red");
        queue1.add("Orange");
        queue1.add("Yellow");
        System.out.println(queue1);
        System.out.println(queue1.peek());
        System.out.println();

        //test add
        System.out.println("----------- Test add and print front and back -----------");
        queue2.add("Red");
        queue2.add("Orange");
        queue2.add("Yellow");
        System.out.print("Front ");
        System.out.print(queue2);
        System.out.println("Back");
        System.out.println();
        System.out.println();
    }

    public static void libraryStackVersionTest(){
        System.out.println();
        System.out.println("<------- \t L I B R A R Y \t\t S T A C K \t ------->");
        Stack<String> stack = new Stack<>();
        Stack<String> stack1 = new Stack<>();

        System.out.println();
        System.out.println();

        //test push
        System.out.println("----------- \t Test push \t -----------");
        System.out.println(stack.push("Red"));
        System.out.println(stack.push("Orange"));
        System.out.println(stack.push("Yellow"));
        System.out.println(stack.push("Green"));
        System.out.println(stack.push("Blue"));
        System.out.println(stack.push("Indigo"));
        System.out.println(stack.push("Violet"));
        System.out.println(stack);
        System.out.println();
        System.out.println();
        System.out.println();


        // test pop
        System.out.println("----------- \t Test pop \t -----------");
        System.out.println();
        System.out.println("----------original-----------");
        System.out.println("size: " + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------1st pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------2nd pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------3rd pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------4th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------5th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------6th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println("----------7th pop-----------");
        System.out.println("Pop element: "  + stack.pop());
        System.out.println("isEmpty? "      + stack.isEmpty());
        System.out.println("size: "         + stack.size());
        System.out.println(stack);
        System.out.println();
        System.out.println();

        //test peek
        System.out.println("----------- \t Test peek \t -----------");
        stack1.push("Red");
        stack1.push("Orange");
        stack1.push("Yellow");
        System.out.println(stack1);
        System.out.println("peek element: " + stack1.peek());
        System.out.println();
        System.out.println();
    }


    public static void myQueueVersionTest(){
        //TODO : Create println tests for each of your MyQueue methods
        System.out.println();
        System.out.println("==========  M Y   Q U E U E  ==========");
    }

    public static void myStackVersionTest(){
        //TODO : Create println tests for each of your MyStack methods
        System.out.println();
        System.out.println("==========  M Y   S T A C K  ==========");
    }

    public static void main(String[] args) {
        intro();
        libraryStackVersionTest();
        libraryQueueVersionTest();
    }

}
