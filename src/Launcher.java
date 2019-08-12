import trade.TradeExecution;
import parser.InputParser;
import model.TradeOrder;

import java.io.*;
import java.text.ParseException;
import java.util.*;

public class Launcher {
    private static HashMap<String, PriorityQueue<TradeOrder>> BuyRequests = new HashMap<String, PriorityQueue<TradeOrder>>();
    private static HashMap<String, PriorityQueue<TradeOrder>> SellRequests = new HashMap<String, PriorityQueue<TradeOrder>>();

    public static void main(String args[]) throws IOException, ParseException {
//        System.out.println("welcome");
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(input);
        String lineInput;

        while ((lineInput = br.readLine()) != null) {

            InputParser parser = new InputParser();
            TradeOrder newOrder = parser.processLineInput(lineInput);
            TradeExecution.addToQueue(newOrder);
            TradeExecution.Execute(newOrder);
        }
    }
}