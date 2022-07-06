import java.util.ArrayList;
import java.util.Collection;

public class MarketOrderTest {
    public static void main(String[] args) {
        ArrayList<MarketOrder> orders = new ArrayList<>();

        MarketOrder order1 = new MarketOrder(MarketOrder.OrderType.Buy,1,100);
        MarketOrder order2 = new MarketOrder(MarketOrder.OrderType.Buy,2,100);
        MarketOrder order3 = new MarketOrder(MarketOrder.OrderType.Buy,3,100);
        MarketOrder order4 = new MarketOrder(MarketOrder.OrderType.SELL,6,500);

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);

        orders.stream()
                .filter(order -> order.type.equals(MarketOrder.OrderType.Buy))
                .forEach(data->System.out.println(data.type +":"+ data.amount+":"+data.money));

        System.out.println(calculateProfit(orders));

    }
    public static double calculateProfit(Collection<MarketOrder> orders){

        if(orders == null){
            throw new NullPointerException("orders are null");

        }

        int totalNumberOfBuy=0, totalNumberOfSell=0, buyMoney=0, sellMoney=0;

        for(MarketOrder order:orders){
            if(order.type == MarketOrder.OrderType.Buy){
                totalNumberOfBuy +=order.amount;
                buyMoney +=order.money * order.amount;

            }else{
                totalNumberOfSell += order.amount;
                sellMoney += order.money * order.amount;
            }

        }

        System.out.println("totalBuy:"+totalNumberOfBuy+ " totalSell:"+totalNumberOfSell);

        if(totalNumberOfBuy != totalNumberOfSell){
            throw new IllegalArgumentException("TotalBuy is not equal to Total Sell");

        }
        return (double)sellMoney/(double)buyMoney;
    }
}
