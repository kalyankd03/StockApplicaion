package model;

public enum OrderType {
        BUY("buy") , SELL("sell");

        String type;
        OrderType(String type) {
        this.type = type;
        }
}
