package week3_TranKhacLinh_2001040121;

import java.util.Scanner;

public class MissingElementException extends Exception {
    public MissingElementException() {
        super("The array is missing the element");
    }

	public void printInfo() {
        System.out.print("the array is missing the element. \n1. Enter the number\n2.quit\nEnter the choice: ");
    }
}
