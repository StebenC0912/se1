package week8_TranKhacLinh_200140121.stocktrader.repositories;

import java.util.ArrayList;

import week8_TranKhacLinh_200140121.stocktrader.entities.StockInformation;

public class StockCommandRepository {
    private ArrayList<StockInformation> userHistory;

    public ArrayList<StockInformation> getStockCommands() {
        return userHistory;
    }

    public boolean StoreStockCommands() {
        if (userHistory.isEmpty())
            return false;
        return true;
    }
}
