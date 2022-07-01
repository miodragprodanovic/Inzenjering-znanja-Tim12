package protage.example.protage.similarity.model;

import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CaseComponent;

public class ComputerCaseDescription implements CaseComponent {
    private int ramCapacity;
    private int storageCapacity;
    private int graphicsCardSpeed;
    private int powerSupplyWattPower;
    private int fanAirFlowCapacity;
    private int speakersWattPower;
    private int processorCores;
    private int price;

    public int getRamCapacity() {
        return ramCapacity;
    }

    public void setRamCapacity(int ramCapacity) {
        this.ramCapacity = ramCapacity;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }

    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public int getGraphicsCardSpeed() {
        return graphicsCardSpeed;
    }

    public void setGraphicsCardSpeed(int graphicsCardSpeed) {
        this.graphicsCardSpeed = graphicsCardSpeed;
    }

    public int getPowerSupplyWattPower() {
        return powerSupplyWattPower;
    }

    public void setPowerSupplyWattPower(int powerSupplyWattPower) {
        this.powerSupplyWattPower = powerSupplyWattPower;
    }

    public int getFanAirFlowCapacity() {
        return fanAirFlowCapacity;
    }

    public void setFanAirFlowCapacity(int fanAirFlowCapacity) {
        this.fanAirFlowCapacity = fanAirFlowCapacity;
    }

    public int getSpeakersWattPower() {
        return speakersWattPower;
    }

    public void setSpeakersWattPower(int speakersWattPower) {
        this.speakersWattPower = speakersWattPower;
    }

    public int getProcessorCores() {
        return processorCores;
    }

    public void setProcessorCores(int processorCores) {
        this.processorCores = processorCores;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Computer { " +
                "ramCapacity = " + ramCapacity +
                ", storageCapacity = " + storageCapacity +
                ", graphicsCardSpeed = " + graphicsCardSpeed +
                ", powerSupplyWattPower = " + powerSupplyWattPower +
                ", fanAirFlowCapacity = " + fanAirFlowCapacity +
                ", speakersWattPower = " + speakersWattPower +
                ", processorCores = " + processorCores +
                ", price = " + price +
                " }";
    }

    @Override
    public Attribute getIdAttribute() {
        return new Attribute("id", this.getClass());
    }
}

