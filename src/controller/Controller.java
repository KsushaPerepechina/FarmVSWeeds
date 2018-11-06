package controller;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private Info info;

    public Controller(Info info){
        this.info = info;
    }

    public void getNewGardenBed(GardenBed gb){
        info.addNewGardenBed(gb);
    }

    public ArrayList<GardenBed> getData(){
        return info.getGardenBedData();
    }

    public int getGardenBedDataSize(List<GardenBed> data){
        return data.size();
    }

    public void purchase(SeedsAndHarvest seedsAndHarvest, Coins coins){
        seedsAndHarvest.increaseQuantity();
        coins.decreaseAmount(seedsAndHarvest.getPurchasePrise());
    }

    public void sale(SeedsAndHarvest seedsAndHarvest, Coins coins){
        seedsAndHarvest.decreaseQuantity();
        coins.increaseAmount(seedsAndHarvest.getSalePrise());
    }

    public boolean purchaseIsAvailable(SeedsAndHarvest seedsAndHarvest, Coins coins){
        if (coins.getAmount()-seedsAndHarvest.getPurchasePrise() >= 0) return true;
        else return false;
    }

    public boolean saleIsAvailable(SeedsAndHarvest seedsAndHarvest, Coins coins){
        if (seedsAndHarvest.getQuantity() > 0) return true;
        else return false;
    }

  /*  public void waterSupply(GardenBed gb){
        gb.setLackOfMoisture(false);
        bucketOn = false;
        bucketIsFullLabel.setVisible(false);
        bucketIcon.setVisible(false);
        bucketButton.setVisible(true);
    }*/
}
