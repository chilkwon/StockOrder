public class MarketOrder {
    public static enum OrderType{
        Buy,
        SELL
    }

    final MarketOrder.OrderType type;
    final int amount;
    final int money;


    public MarketOrder(OrderType type, int amount, int money) {

        if(amount <1 || money < 1) {
            throw new IllegalArgumentException();
        }

        this.type = type;
        this.amount = amount;
        this.money = money;

    }
}
