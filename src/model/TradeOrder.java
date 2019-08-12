package model;

import java.math.BigDecimal;
import java.util.Date;


public class TradeOrder {

    private String id;
    private Date PurchaseTime;
    private String stock;
    private OrderType type;
    private  int quantity;
    private BigDecimal price;

    public TradeOrder( String id, Date PurchaseTime, String stock, OrderType type, int quantity, BigDecimal price ){
        this.id = id;
        this.PurchaseTime =PurchaseTime;
        this.stock = stock;
        this.type = type;
        this.quantity =quantity;
        this.price = price;
    }
    public String getId(){
        return this.id;
    }

    public void setId (String id){
        this.id = id;
    }

    public Date getPurchaseTime(){
        return this.PurchaseTime;
    }

    public void setPurchaseTime (Date time){
        this.PurchaseTime = time;
    }
    public String getStock(){
        return this.stock;
    }

    public void setStock (String stock){
        this.stock = stock;
    }

    public OrderType getType (){
        return this.type;
    }

    public void setType (OrderType type){
        this.type = type;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    public BigDecimal getPrice  (){
        return this.price;
    }


    public void setPrice (BigDecimal price){
        this.price = price;
    }

    @Override
    public String toString(){
        return this.id+ "  " +this.price.toString();
    }


}
