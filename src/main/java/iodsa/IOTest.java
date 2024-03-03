package iodsa;

import java.nio.file.*;
import java.util.*;


public class IOTest {
    public static void consoleInputTest(){
        Scanner sc = new Scanner(System.in);

        String readString = sc.next();

        System.out.println(readString);

        String readLine = (new Scanner(System.in)).nextLine();

        System.out.println(readLine);




//        int readInt = sc.nextInt(); // same fr next float, byte etc
//        System.out.println(readInt);
    }

    public static void main(String[] args) {
        IOTest.consoleInputTest();
    }
}
