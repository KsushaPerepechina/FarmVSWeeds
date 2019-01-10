package controller;

import model.*;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    private Coins coins;
    private ArrayList<GardenBed> gardenBedArray;

    private Inventory hoe;
    private Inventory bucket;
    private Inventory poison;
    private Inventory waterStation;

    private Product strawSeeds;
    private Product strawHarvest;
    private Product cabbageSeeds;
    private Product cabbageHarvest;

    private Timer moistureTimer;
    private Timer weedAttackTimer;
    private Timer beetleAttackTimer;
    private Timer readinessTimer;

    public Controller(){
        coins = new Coins(50.00);
        gardenBedArray = new ArrayList<GardenBed>();

        GardenBed gb1 = new GardenBed();
        gardenBedArray.add(gb1);
        GardenBed gb2 = new GardenBed();
        gardenBedArray.add(gb2);
        GardenBed gb3 = new GardenBed();
        gardenBedArray.add(gb3);

        strawSeeds = new Product("strawberry",0.55, 0.61, 5);
        cabbageSeeds = new Product("cabbage",0.48, 0.60, 3);
        strawHarvest = new Product("strawberry",3.31, 5.64, 4);
        cabbageHarvest = new Product("cabbage",2.98, 4.84, 6);
        hoe = new Inventory();
        bucket = new Inventory();
        poison = new Inventory();
        waterStation = new Inventory();

        activateLackOfMoistureTimer(gb1);
        activateLackOfMoistureTimer(gb2);
        activateLackOfMoistureTimer(gb3);
        activateWeedAttackTimer(gb1);
        activateWeedAttackTimer(gb2);
        activateWeedAttackTimer(gb3);
        activateBeetleAttackTimer(gb1);
        activateBeetleAttackTimer(gb2);
        activateBeetleAttackTimer(gb3);
    }

    public void solveWeedAttack(int gb_num) {
        if (hoe.getExploitation() && gardenBedArray.get(gb_num).isWeedAttacked()) {
            gardenBedArray.get(gb_num).setWeedAttacked(false);
            hoe.setExploitation(false);
            activateWeedAttackTimer(gardenBedArray.get(gb_num));
        }
    }

    public void solveLackOfMoisture(int gb_num) {
        if (bucket.getExploitation() && gardenBedArray.get(gb_num).isLackedOfMoisture()) {
            gardenBedArray.get(gb_num).setLackOfMoisture(false);
            bucket.setExploitation(false);
            activateLackOfMoistureTimer(gardenBedArray.get(gb_num));
        }
    }

    public void solveBeetleAttack(int gb_num) {
        if (poison.getExploitation() && gardenBedArray.get(gb_num).isBeetleAttacked()) {
            gardenBedArray.get(gb_num).setBeetleAttacked(false);
            poison.setExploitation(false);
            activateBeetleAttackTimer(gardenBedArray.get(gb_num));
        }
    }

    public void solveGardenBedEmptiness(int gb_num) {
        Product seeds = new Product();
        if (strawSeeds.getExploitation()) seeds = strawSeeds;
        else seeds = cabbageSeeds;
        if (seeds.getExploitation() && gardenBedArray.get(gb_num).isEmpty()) {
            gardenBedArray.get(gb_num).setEmptiness(false);
            seeds.setExploitation(false);
            gardenBedArray.get(gb_num).setNameOfPlant(seeds.getName());
            activateHarvestReadinessTimer(gardenBedArray.get(gb_num), seeds);
        }
    }

    public void solveHarvestReadiness(int gb_num) {
        Product harvest = new Product();
        if (gardenBedArray.get(gb_num).getNameOfPlant().equals("strawberry")) harvest = strawHarvest;
        else harvest = cabbageHarvest;
        if (gardenBedArray.get(gb_num).isReady()) {
            gardenBedArray.get(gb_num).setEmptiness(true);
            gardenBedArray.get(gb_num).setReadiness(false);
            harvest.increaseQuantity();
        }
    }

    public void activateWeedAttackTimer(GardenBed gb) {
        weedAttackTimer = new Timer();
        weedAttackTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                gb.setWeedAttacked(true);
                weedAttackTimer.cancel();
            }
        }, 2 * 60 * 1000);
    }

    public void activateBeetleAttackTimer(GardenBed gb) {
        beetleAttackTimer = new Timer();
        beetleAttackTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                gb.setBeetleAttacked(true);
                beetleAttackTimer.cancel();
            }
        }, 5 * 30 * 1000);
    }

    public void activateLackOfMoistureTimer(GardenBed gb) {
        moistureTimer = new Timer();
        moistureTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                gb.setLackOfMoisture(true);
                moistureTimer.cancel();
            }
        }, 8 * 1000);
    }

    public void activateHarvestReadinessTimer(GardenBed gb, Product seeds) {
        readinessTimer = new Timer();
        readinessTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                gb.setReadiness(true);
                readinessTimer.cancel();
            }
        }, 15 * 1000);
    }

    public boolean getHoeExploitation(){
        return hoe.getExploitation();
    }

    public boolean getBucketExploitation(){
        return bucket.getExploitation();
    }

    public boolean getPoisonExploitation(){
        return poison.getExploitation();
    }

    public boolean getWaterStationExploitation(){
        return waterStation.getExploitation();
    }

    public boolean getStrawSeedsExploitation(){
        return strawSeeds.getExploitation();
    }

    public boolean getCabbageSeedsExploitation(){
        return cabbageSeeds.getExploitation();
    }

    public void setHoeExploitation(boolean exploitation){
        hoe.setExploitation(exploitation);
    }

    public void setBucketExploitation(boolean exploitation){
        bucket.setExploitation(exploitation);
    }

    public void setPoisonExploitation(boolean exploitation){
        poison.setExploitation(exploitation);
    }

    public void setWaterStationExploitation(boolean exploitation){
        waterStation.setExploitation(exploitation);
    }

    public void setStrawSeedsExploitation(boolean exploitation){
        strawSeeds.setExploitation(exploitation);
    }

    public void setCabbageSeedsExploitation(boolean exploitation){
        cabbageSeeds.setExploitation(exploitation);
    }

    public void increaseStrawSeedsQuantity(){
        strawSeeds.increaseQuantity();
    }

    public void increaseCabbageSeedsQuantity(){
        cabbageSeeds.increaseQuantity();
    }

    public void decreaseStrawSeedsQuantity(){
        strawSeeds.decreaseQuantity();
    }

    public void decreaseCabbageSeedsQuantity(){
        cabbageSeeds.decreaseQuantity();
    }

    public boolean purchaseOfStrawSeedsIsAvailable(){
        return (coins.getAmount()- strawSeeds.getPurchasePrice() >= 0);
    }

    public boolean purchaseOfStrawHarvestIsAvailable(){
        return (coins.getAmount()- strawHarvest.getPurchasePrice() >= 0);
    }

    public boolean purchaseOfCabbageSeedsIsAvailable(){
        return (coins.getAmount()- cabbageSeeds.getPurchasePrice() >= 0);
    }

    public boolean purchaseOfCabbageHarvestIsAvailable(){
        return (coins.getAmount()- cabbageHarvest.getPurchasePrice() >= 0);
    }

    public boolean saleOfStrawSeedsIsAvailable(){
        return (strawSeeds.getQuantity() > 0);
    }

    public boolean saleOfStrawHarvestIsAvailable(){
        return (strawHarvest.getQuantity() > 0);
    }

    public boolean saleOfCabbageSeedsIsAvailable(){
        return (cabbageSeeds.getQuantity() > 0);
    }

    public boolean saleOfCabbageHarvestIsAvailable(){
        return (cabbageHarvest.getQuantity() > 0);
    }

    public void purchaseStrawSeeds(){
        strawSeeds.increaseQuantity();
        coins.decreaseAmount(strawSeeds.getPurchasePrice());
    }

    public void saleStrawSeeds(){
        strawSeeds.decreaseQuantity();
        coins.increaseAmount(strawSeeds.getSalePrice());
    }

    public void purchaseStrawHarvest(){
        strawHarvest.increaseQuantity();
        coins.decreaseAmount(strawHarvest.getPurchasePrice());
    }

    public void saleStrawHarvest(){
        strawHarvest.decreaseQuantity();
        coins.increaseAmount(strawHarvest.getSalePrice());
    }

    public void purchaseCabbageSeeds(){
        cabbageSeeds.increaseQuantity();
        coins.decreaseAmount(cabbageSeeds.getPurchasePrice());
    }

    public void saleCabbageSeeds(){
        cabbageSeeds.decreaseQuantity();
        coins.increaseAmount(cabbageSeeds.getSalePrice());
    }

    public void purchaseCabbageHarvest(){
        cabbageHarvest.increaseQuantity();
        coins.decreaseAmount(cabbageHarvest.getPurchasePrice());
    }

    public void saleCabbageHarvest(){
        cabbageHarvest.decreaseQuantity();
        coins.increaseAmount(cabbageHarvest.getSalePrice());
    }

    public boolean getGardenBedEmptiness(int gb_num){
        return gardenBedArray.get(gb_num).isEmpty();
    }

    public boolean getGardenBedReadiness(int gb_num){
        return gardenBedArray.get(gb_num).isReady();

    }

    public boolean getGardenBedLackOfMoisture(int gb_num){
        return gardenBedArray.get(gb_num).isLackedOfMoisture();
    }

    public boolean getGardenBedBeetleAttack(int gb_num){
        return gardenBedArray.get(gb_num).isBeetleAttacked();
    }

    public boolean getGardenBedWeedAttack(int gb_num){
        return gardenBedArray.get(gb_num).isWeedAttacked();
    }

    public String getStrawSeedsQuantity(){
        return strawSeeds.getQuantityToString();
    }

    public String getStrawHarvestQuantity(){
        return strawHarvest.getQuantityToString();
    }

    public String getCabbageSeedsQuantity(){
        return cabbageSeeds.getQuantityToString();
    }

    public String getCabbageHarvestQuantity(){
        return cabbageHarvest.getQuantityToString();
    }

    public String getCoinsAmount(){
        return coins.getAmountToString();
    }

    public String getSaleStrawSeedsPrice(){
        return strawSeeds.getSalePriceToString();
    }

    public String getSaleStrawHarvestPrice(){
        return strawHarvest.getSalePriceToString();
    }

    public String getSaleCabbageSeedsPrice(){
        return cabbageSeeds.getSalePriceToString();
    }

    public String getSaleCabbageHarvestPrice(){
        return cabbageHarvest.getSalePriceToString();
    }

    public String getPurchaseStrawSeedsPrice(){
        return strawSeeds.getPurchasePriceToString();
    }

    public String getPurchaseStrawHarvestPrice(){
        return strawHarvest.getPurchasePriceToString();
    }

    public String getPurchaseCabbageSeedsPrice(){
        return cabbageSeeds.getPurchasePriceToString();
    }

    public String getPurchaseCabbageHarvestPrice(){
        return cabbageHarvest.getPurchasePriceToString();
    }
}
