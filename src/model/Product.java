package model;

public class Product {
    private double salePrice;
    private double purchasePrice;
    private int quantity;
    private String name;
    private boolean exploitation;

    public Product(String name, double salePrice, double purchasePrice, int quantity){
        this.name = name;
        this.salePrice = salePrice;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public Product(){
    }

    public void increaseQuantity(){
        quantity++;
    }

    public void decreaseQuantity(){
        quantity--;
    }

    public double getPurchasePrice(){
        return purchasePrice;
    }

    public String getName(){
        return name;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getQuantityToString(){
        return Integer.toString(quantity);
    }

    public String getPurchasePriceToString(){
        return Double.toString(purchasePrice);
    }

    public String getSalePriceToString(){
        return Double.toString(salePrice);
    }

    public boolean getExploitation(){
        return exploitation;
    }

    public void setExploitation(boolean exploitation){
        this.exploitation = exploitation;
    }
}
