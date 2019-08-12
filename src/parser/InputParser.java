package parser;

import model.OrderType;
import model.TradeOrder;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InputParser {

    /*
    *  Reads stdin string input and creates a TradeOrder object
     */
    public TradeOrder processLineInput(String lineInput) throws ParseException {
        String space= " ";
        String inputArr[] = lineInput.split(space);
        String id = inputArr[0];
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm");
        Date PurchaseTime = formatter.parse(inputArr[1]);
        String stock = inputArr[2];
        OrderType otype = inputArr[3].equals("buy")? OrderType.BUY : OrderType.SELL;
        int quantity = Integer.parseInt(inputArr[4]);
        BigDecimal price = new BigDecimal(inputArr[5]);
        TradeOrder newOrder = new TradeOrder(id, PurchaseTime, stock, otype, quantity, price);
        return newOrder;
    }
}