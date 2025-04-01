package pl.tmobile.utils;

public class PriceConverter {
    public double convertPrice(String priceString) {
        priceString = priceString.replaceAll("[^\\d.]+", "");
        return Double.parseDouble(priceString);
    }
}
