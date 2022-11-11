package week8_TranKhacLinh_200140121.stocktrader.repositories;

import java.util.ArrayList;

import week8_TranKhacLinh_200140121.stocktrader.model.entities.Stock;
import week8_TranKhacLinh_200140121.stocktrader.model.entities.StockInformation;

public class UserRepository {
    private Double userMoney;
    private ArrayList<StockInformation> userStock;
    public ArrayList<StockInformation> getUserInfo(){
        return userStock;
    }
    public boolean storeUserInfo(){
        return !userStock.isEmpty() && userStock != null;
    }
    public double getUserMoney(){
        return userMoney;
    }
}
