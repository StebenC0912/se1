package week8_TranKhacLinh_200140121.stocktrader.client;

import week8_TranKhacLinh_200140121.stocktrader.server.StockServer;

import java.nio.file.AccessDeniedException;
import java.util.Scanner;

public class Menu {
    public static void printOutMenu() {
        System.out.println(
                "1. Log in \n2. List all stock\n3.Buy stock\n4. list owned stock\n5. Sell stock\n6. Check balance\n7. Log out.");

    }

    public static void main(String[] args) throws AccessDeniedException {
        printOutMenu();
        StockServer server = new StockServer(null, null, null, null, null, false, null, null);
        Scanner sc = new Scanner(System.in);
        int user = sc.nextInt();
        boolean isLogged = false;
        switch (user) {
            case 1:
                System.out.print("ENTER THE USERNAME: ");
                String userName = sc.next();
                System.out.println("ENTER THE PASSWORD: ");
                String pass = sc.next();
                isLogged = server.login(userName, pass);
                break;
        }
        while (isLogged == true) {
            printOutMenu();
            user = sc.nextInt();
            switch (user) {
                case 1:
                    System.out.print("ENTER THE USERNAME: ");
                    String userName = sc.next();
                    System.out.println("ENTER THE PASSWORD: ");
                    String pass = sc.next();
                    isLogged = server.login(userName, pass);
                    break;
                case 2:
                    server.listAllStocks();
                    break;
                case 3:
                    System.out.println("ENTER THE STOCK ID: ");
                    int stockId = sc.nextInt();
                    System.out.println("ENTER THE QUANTITY: ");
                    int quantity = sc.nextInt();
                    boolean buySuccess = server.purchase(stockId, quantity);
                    if (buySuccess) {
                        System.out.println("PURCHASE SUCCESSFULLY");
                    } else {
                        System.out.println("PURCHASE FAILED");
                    }
                    break;
                case 4:
                    String allOwned = server.listOwnStocks();
                    System.out.println(allOwned);
                    break;
                case 5:
                    System.out.println("ENTER THE STOCK ID: ");
                    int stockId1 = sc.nextInt();
                    System.out.println("ENTER THE QUANTITY: ");
                    int quantity1 = sc.nextInt();
                    boolean sellSuccess = server.sellStock(stockId1, quantity1);
                    if (sellSuccess) {
                        System.out.println("SELL SUCCESSFULLY");
                    } else {
                        System.out.println("SELL FAILED");
                    }
                    break;
                case 6:
                    System.out.println("YOUR BALANCE IS: " + server.checkBalance());
                    break;
                case 7:
                    isLogged = false;
                    break;
                default:
                    System.out.println("INVALID INPUT");
                    break;
            }
        }
    }
}
