package week8_TranKhacLinh_200140121.stocktrader.repositories;
import java.util.ArrayList;

import week8_TranKhacLinh_200140121.stocktrader.model.entities.Stock;
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
