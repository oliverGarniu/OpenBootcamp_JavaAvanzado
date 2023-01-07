package org.ob.factory;

public class PriceFactory {

    Price price;

    /*
    "Ocultamos" el constructor con private, de esta
    manera solo se podría instanciar desde aquí.
    */
    private PriceFactory() {
    }

    public PriceFactory(String country) {
        if (country.equalsIgnoreCase("Spain")) {
            price = new PriceEUR();
            System.out.println("Spain, price in EURO");
        } else {
            price = new PriceUSD();
            System.out.println("Other country, price in USD");
        }
    }

    /*
    Creamos este método para "adornar" y evitar
    tener que poner priceFactory1.price.getPrice()
    De esta manera nos valdrá con anotar priceFactory1.getPrice()
     */
    public double getPrice() {
        return price.getPrice();
    }
}
