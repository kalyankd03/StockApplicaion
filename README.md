# StockApplicaion
Simple Stock market trading application.


Stock Exchange
--------------

Implement an order matching system for a stock exchange.

Traders place Buy or Sell orders for a stock indicating the quantity and price.

These orders get entered into the exchange’s order-book and remain there until they are matched or until the trading day ends.

The exchange follows a FirstInFirstOut Price-Time order-matching rule, which states that: “The first order in the order-book at a price level is the first order matched. All orders at the same price level are filled according to time priority”.

The exchange works like a market, lower selling prices and higher buying prices get priority.

A trade is executed when a buy price is greater than or equal to a sell price. The trade is recorded at the price of the sell order regardless of the price of the buy order.

Write a program that accepts a list of orders from standard input and writes out to standard output the trades that were executed as shown below.

e.g. The following input (format:<order-id> <time> <stock> <buy/sell> <qty> <price>):


#1 09:45 BAC sell 100 240.10
#2 09:45 BAC sell 90 237.45
#3 09:47 BAC buy 80 238.10
#5 09:48 BAC sell 220 241.50
#6 09:49 BAC buy 50 238.50
#7 09:52 TCS buy 10 1001.10
#8 10:01 BAC sell 20 240.10
#9 10:02 BAC buy 150 242.70

Should produce the following output to the console: (format:<sell-order-id> <qty> <sell-price> <buy-order-id>):

#2 80 237.45 #3
#2 10 237.45 #6
#1 100 240.10 #9
#8 20 240.10 #9
#5 30 241.50 #9

