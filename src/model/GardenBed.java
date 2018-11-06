package model;

public class GardenBed{
    private boolean emptiness;
    private boolean readiness;
    private boolean beetleAttack;
    private boolean weedAttack;
    private boolean lackOfMoisture;
    private String nameOfPlant;

    public GardenBed(){
        emptiness = true;
        readiness = false;
        beetleAttack = false;
        weedAttack = false;
        lackOfMoisture = false;
        nameOfPlant = "";
    }

    public boolean isEmpty() {
        return emptiness;
    }

    public boolean isReady() {
        return readiness;
    }

    public boolean isBeetleAttacked() {
        return beetleAttack;
    }

    public boolean isWeedAttacked() {
        return weedAttack;
    }

    public boolean isLackedOfMoisture() {
        return lackOfMoisture;
    }

    public String getNameOfPlant() {
        return nameOfPlant;
    }

    public void setEmptiness(boolean emptiness) {
        this.emptiness = emptiness;
    }

    public void setReadiness(boolean readiness) {
        this.readiness = readiness;
    }

    public void setBeetleAttack(boolean beetleAttack) {
        this.beetleAttack = beetleAttack;
    }

    public void setWeedAttack(boolean weedAttack) {
        this.weedAttack = weedAttack;
    }

    public void setLackOfMoisture(boolean lackOfMoisture) {
        this.lackOfMoisture = lackOfMoisture;
    }

    public void setNameOfPlant(String nameOfPlant) {
        this.nameOfPlant = nameOfPlant;
    }
}
