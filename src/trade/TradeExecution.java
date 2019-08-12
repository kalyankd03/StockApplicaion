package trade;

import model.BuyPriority;
import model.OrderType;
import model.SellPriority;
import model.TradeOrder;

import java.util.HashMap;
import java.util.PriorityQueue;

public class TradeExecution {

    private static HashMap<String , PriorityQueue<TradeOrder>> BuyRequests = new HashMap<String, PriorityQueue<TradeOrder>>() ;
    private static HashMap<String , PriorityQueue<TradeOrder>> SellRequests = new HashMap<String, PriorityQueue<TradeOrder>>() ;

/*
* Inserts TradeOrder Object into the respective Priority Queue
*/
public static void addToQueue(TradeOrder newOrder){
    String StockName = newOrder.getStock();
    OrderType otype = newOrder.getType();

    if(otype == OrderType.BUY ){
        if(!BuyRequests.containsKey(StockName)) {
            BuyRequests.put(StockName, new PriorityQueue<>(new BuyPriority()));
        }
        PriorityQueue<TradeOrder> newBuyEntry = BuyRequests.get(StockName);
        newBuyEntry.add(newOrder);
        BuyRequests.put(StockName , newBuyEntry);
    }
    else if(otype == OrderType.SELL){
        if(!SellRequests.containsKey(StockName)) {
            SellRequests.put(StockName, new PriorityQueue<>(new SellPriority()));
        }
        PriorityQueue<TradeOrder> newSellEntry = SellRequests.get(StockName);
        newSellEntry.add(newOrder);
        SellRequests.put(StockName , newSellEntry);
    }


}

/*
* Retrieves respective priority queues from Hashmap using new tradeorder object and executes trade operation
 */
public static void Execute(TradeOrder newOrder){
    String StockName =newOrder.getStock();
    if(BuyRequests.containsKey(StockName) && SellRequests.containsKey(StockName)){
        ExecuteTrade(BuyRequests.get(StockName) , SellRequests.get(StockName));
    }

}

/*
* Executes Trade Operation by comparing buy requests and sell requests from priority queues
*/
    public static void ExecuteTrade(PriorityQueue<TradeOrder> Buy , PriorityQueue<TradeOrder> Sell){
        TradeOrder BuyOrder , SellOrder;
        while((Buy.peek()!=null) && (Sell.peek()!=null) && (Buy.peek().getPrice().compareTo(Sell.peek().getPrice()) >0 )){
            BuyOrder = Buy.peek();
            SellOrder = Sell.peek();
            int quantitySold = 0;

            if(  BuyOrder.getQuantity() > SellOrder.getQuantity()){
                Sell.poll();
                quantitySold = SellOrder.getQuantity();
                BuyOrder.setQuantity(BuyOrder.getQuantity() - SellOrder.getQuantity());
            }
            else if(  BuyOrder.getQuantity() < SellOrder.getQuantity()){
                Buy.poll();
                quantitySold = BuyOrder.getQuantity();
                SellOrder.setQuantity(SellOrder.getQuantity() - BuyOrder.getQuantity());
            }
            else{
                Sell.poll();
                Buy.poll();
                quantitySold = BuyOrder.getQuantity();
            }
            System.out.println(SellOrder.getId()+ " "+quantitySold +" "+SellOrder.getPrice()+" "+BuyOrder.getId());
        }

    }
}