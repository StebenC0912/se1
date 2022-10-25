package week8_TranKhacLinh_200140121;

import java.time.LocalDate;
import java.time.LocalTime;

public class StockInformation {
    private Stock stock;
    private int commandType;
    private LocalTime purchaseDate;

    public StockInformation(Stock stock, int commandType, LocalTime purchaseDate) {
        this.stock = stock;
        this.commandType = commandType;
        this.purchaseDate = purchaseDate;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public int getCommandType() {
        return commandType;
    }

    public void setCommandType(int commandType) {
        this.commandType = commandType;
    }

    public LocalTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    
}
