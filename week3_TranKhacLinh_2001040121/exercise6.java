package week3_TranKhacLinh_2001040121;

import java.util.Scanner;

public class exercise6 {
    public static void divide(int[] a, int[] b) throws MissingElementException, DivideZeroException{
        for(int i = 0; i < a.length; i++){
            try {
                if (i >= b.length) {
                    throw new MissingElementException();
                }
                if (b[i] == 0) {
                    throw new DivideZeroException();
                }
            } catch (MissingElementException e) {
                e.printInfo();
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
            } catch (DivideZeroException e) {
                e.printInfo();
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
            }
        }
        for (int i = 0; i < b.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
    
}
