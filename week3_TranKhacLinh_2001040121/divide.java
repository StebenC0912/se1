package week3_TranKhacLinh_2001040121;

import java.util.Scanner;

public class divide {
    public static void divide(int[] a, int[] b){
        for(int i = 0; i < a.length; i++){
            try {
                a[i] /= b[i];
            } catch (IndexOutOfBoundsException e) {
                // TODO: handle exception
                System.out.print("The array is missing the element. \n1. Enter the number\n2.quit\nEnter the choice: ");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                System.out.println("");
                if (choice == 1) {
                    System.out.print("Enter the number: ");
                    int userIn = sc.nextInt();
                    a[i] /= userIn;
                } else{
                    break;
                }
            } catch (ArithmeticException e){
                System.out.print("The element in array is 0 \n1. Enter other number\n2.quit\nEnter the choice: ");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                System.out.println("");
                if (choice == 1) {
                    System.out.print("Enter new number: ");
                    int userIn = sc.nextInt();
                    while(userIn == 0){
                        System.out.print("Enter new number not 0: ");
                        userIn = sc.nextInt();
                    }
                    a[i] /= userIn;
                } else{
                    break;
                }
                sc.close();
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    
}
