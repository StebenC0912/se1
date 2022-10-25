package week8_TranKhacLinh_200140121.stocktrader.server;

import java.io.File;
import java.nio.file.AccessDeniedException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import week8_TranKhacLinh_200140121.stocktrader.entities.Stock;
import week8_TranKhacLinh_200140121.stocktrader.entities.StockInformation;
import week8_TranKhacLinh_200140121.stocktrader.entities.User;

public class StockServer {
    private Map<Integer, Stock> map;
    private ArrayList<User> users;
    private ArrayList<Stock> stocks;
    private ArrayList<StockInformation> userStocks;
    private ArrayList<StockInformation> userHistory;
    private Double userMoney;
    private boolean isLoggedin;
    private LocalTime currentDate;

    public StockServer(ArrayList<User> users, ArrayList<Stock> stocks, ArrayList<StockInformation> userStocks,
            ArrayList<StockInformation> userHistory, Double userMoney, boolean isLoggedin, LocalTime currentDate,
            Map<Integer, Stock> map) {
        this.users = users;
        this.stocks = stocks;
        this.userStocks = userStocks;
        this.userHistory = userHistory;
        this.userMoney = userMoney;
        this.isLoggedin = isLoggedin;
        this.currentDate = currentDate;
        this.map = map;
    }

    public boolean login(String username, String password) throws AccessDeniedException {

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                this.isLoggedin = true;

            } else {
                this.isLoggedin = false;
                throw new AccessDeniedException("Wrong username or password");
            }
        }
        return this.isLoggedin;

    }

    public String listAllStocks() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stocks.size(); i++) {
            map.put(i + 1, stocks.get(i));
        }
        for (Map.Entry<Integer, Stock> entry : map.entrySet()) {
            sb.append(String.format("%d. %s"), entry.getKey(), entry.getValue().getQuantity());

        }
        return sb.toString();
    }

    public boolean purchase(int stockNo, int quantity) {
        listAllStocks();
        boolean Success = false;
        for (Map.Entry<Integer, Stock> stockMap : map.entrySet()) {
            if (stockMap.getKey() == stockNo) {
                if (stockMap.getValue().getQuantity() >= quantity) {
                    StockInformation stockInfo = new StockInformation(stockMap.getValue(), 1, currentDate);
                    userStocks.add(stockInfo);
                    userMoney -= stockMap.getValue().getPrice() * quantity;
                    stockMap.getValue().setQuantity(stockMap.getValue().getQuantity() - quantity);
                    Success = true;
                } else {
                    System.out.println("Not enough stock");
                    Success = false;
                }
            } else {
                System.out.println("Invalid stock number");
                Success = false;
            }
        }
        return Success;
    }

    public String listOwnStocks() {
        String result = "";
        int stockNo = 1;
        for (StockInformation stock : userStocks) {
            result += stockNo + " " + stock.getStock().getName() + " " + stock.getStock().getPrice() + " "
                    + stock.getStock().getQuantity() + "\n";
            stockNo++;
        }
        System.out.print(result);
        return result;
    }

    public boolean sellStock(int stockNo, int quantity) {
        int sellStock = new Scanner(System.in).nextInt();
        int sellQuantity = new Scanner(System.in).nextInt();
        boolean Success = false;
        listOwnStocks();
        for (StockInformation stock : userStocks) {
            if (stockNo == sellStock) {
                if (stock.getStock().getQuantity() >= sellQuantity) {
                    userMoney += stock.getStock().getPrice() * sellQuantity;
                    stock.getStock().setQuantity(stock.getStock().getQuantity() - sellQuantity);
                    userHistory.add(stock);
                    Success = true;
                } else {
                    System.out.println("Not enough stock");
                    Success = false;
                }
            } else {
                System.out.println("Invalid stock number");
                Success = false;
            }
        }
        return Success;
    }

    // Randomly change all stock prices as if a day has passed.
    public void nextDay() {
        for (Map.Entry<Integer, Stock> stocksMap : map.entrySet()) {
            stocksMap.getValue().setQuantity(stocksMap.getValue().getQuantity() + 1);
        }
    }

    public Double checkBalance() {
        return userMoney;
    }

    public String getPrice() {
        String result = "";
        int stockNo = 1;
        for (Stock stock : stocks) {
            result += stockNo + stock.getName() + " " + stock.getPrice() + " " + stock.getQuantity() + "\n";
            stockNo++;

        }
        System.out.print(result);
        return result;
    }

    private ArrayList<Stock> getCurrentPrice() {
        ArrayList<Stock> currentPrice = new ArrayList<>();
        for (Stock stock : stocks) {
            if (stock.getPrice() > 0) {
                currentPrice.add(stock);
            }
        }
        return currentPrice;
    }

    private boolean storeInformation(StockInformation info) {
        try {
            File file = new File("stocks.txt");
            Scanner sc = new Scanner(file);
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] split = line.split(" ");
                String name = split[0];
                Double price = Double.parseDouble(split[1]);
                Integer quantity = Integer.parseInt(split[2]);
                Stock stock = new Stock(name, price, quantity);
                stocks.add(stock);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
