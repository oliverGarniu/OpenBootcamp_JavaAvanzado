package org.ob.factory;

public class Main {
    public static void main(String[] args) {

        PriceFactory priceFactory1 = new PriceFactory("Spain");
        System.out.println(priceFactory1.getPrice());

        PriceFactory priceFactory2 = new PriceFactory("USA");
        System.out.println(priceFactory2.getPrice());
    }
}
