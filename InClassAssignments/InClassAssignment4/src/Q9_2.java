public class Q9_2 {
    public static void main(String[] args) {
        Stock stock = new Stock("ORCL", "Oracle Corporation");
        stock.previousClosingPrice = 34.5;
        stock.currentPrice = 34.35;
        System.out.println("Percent Change: " + stock.getChangePercent() + "%");
    }
}

class Stock {
    String symbol;
    String name;
    double previousClosingPrice;
    double currentPrice;

    Stock(String symbol, String name) {
        this.symbol = symbol;
        this.name = name;
    }

    double getChangePercent() {
        return ((this.currentPrice - this.previousClosingPrice) / Math.abs(this.previousClosingPrice)) * 100;
    }
}
