package model;

public class SeedsAndHarvest {
    private double salePrise;
    private double purchasePrise;
    private int quantity;
    private String name;

    public SeedsAndHarvest(String name, double salePrise, double purchasePrise, int quantity){
        this.name = name;
        this.salePrise = salePrise;
        this.purchasePrise = purchasePrise;
        this.quantity = quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

    public void decreaseQuantity(){
        quantity--;
    }

    public double getPurchasePrise(){
        return purchasePrise;
    }

    public String getName(){
        return name;
    }

    public double getSalePrise() {
        return salePrise;
    }

    public int getQuantity(){
        return quantity;
    }

    public String getPurchasePriseToString(){
        return Double.toString(purchasePrise);
    }

    public String getSalePriseToString(){
        return Double.toString(salePrise);
    }
}
