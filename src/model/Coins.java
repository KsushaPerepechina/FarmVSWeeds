package model;

public class Coins {
    private double amount;

    public Coins(double amount){
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public String getAmountToString(){
        return Double.toString(amount);
    }

    public void increaseAmount(double amount){
        this.amount += amount;
    }

    public void decreaseAmount(double amount){
        this.amount -= amount;
    }
}
