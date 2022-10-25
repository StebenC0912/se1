package week3_TranKhacLinh_2001040121;

import java.util.Scanner;

public class DivideZeroException extends Exception{
    public DivideZeroException() {
        super("The element in array is 0");
    }
    public void printInfo(){
        System.out.println("The element in array is 0 \n1. Enter other number\n2.quit\nEnter the choice: ");
    }
}
