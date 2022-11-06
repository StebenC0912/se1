package week8_TranKhacLinh_200140121.stocktrader.repositories;
import week8_TranKhacLinh_200140121.stocktrader.entities.Stock;

import java.util.ArrayList;
public class StockRepository {
    private ArrayList<Stock> stocks;

    public ArrayList<Stock> getStocks() {
        return stocks;
    }

    public boolean StoreStocks() {
        if (stocks.isEmpty()) return false;
        return true;
    }
}
