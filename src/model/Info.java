package model;

import java.util.ArrayList;

public class Info {
    private ArrayList<GardenBed> gardenBedData;

    public Info() {
        gardenBedData = new ArrayList();
    }

    public void setGardenBedData(ArrayList<GardenBed> gardenBeds) {
        gardenBedData = gardenBeds;
    }

    public ArrayList<GardenBed> getGardenBedData(){
        return gardenBedData;
    }

    public void addNewGardenBed(GardenBed gb){
        gardenBedData.add(gb);
    }
}
