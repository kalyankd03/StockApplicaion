package model;

import java.util.Comparator;

public class SellPriority implements Comparator<TradeOrder> {
@Override
public int compare(TradeOrder o1, TradeOrder o2) {
        if (o1.getPrice().compareTo(o2.getPrice()) > 0) {
        return 1;
        }
        if (o1.getPrice().compareTo(o2.getPrice()) < 0) {
        return -1;
        } else return 0;
        }
        }
