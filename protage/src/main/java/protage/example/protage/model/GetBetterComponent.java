package protage.example.protage.model;
import java.util.ArrayList;


public class GetBetterComponent {
    private ArrayList<Adapter> Adapters;
    private ArrayList<Camera> Cameras;
    private Case Case;
    private Display Display;
    private ArrayList<Driver> Drivers;
    private Fan Fan;
    private Dedicated Dedicated;
    private Integrated Integrated;
    private ArrayList<Headphones> Headphones;
    private ArrayList<Keyboard> Keyboards;
    private ArrayList<Microphone> Microphones;
    private Motherboard Motherboard;
    private ArrayList<MultimediaSoftware> MultimediaSoftwares;
    private OperatingSystem OperatingSystem;
    private PointingDevice PointingDevice;
    private ArrayList<Port> Ports;
    private PowerSupply PowerSupply;
    private ArrayList<PresentationSoftware> PresentationSoftwares;
    private Processor Processor;
    private ProgramTranslator ProgramTranslator;
    private RAM RAM;
    private SoundCard SoundCard;
    private Speakers Speakers;
    private ArrayList<SpreadsheetSoftware> SpreadsheetSoftwares;
    private ArrayList<Storage> Storages;
    private ArrayList<Utility> Utilities;
    private String WhatToUpgrade;

    public GetBetterComponent(){}

    public GetBetterComponent(ArrayList<Adapter> adapters, ArrayList<Camera> cameras, protage.example.protage.model.Case aCase, protage.example.protage.model.Display display, ArrayList<Driver> drivers, protage.example.protage.model.Fan fan, protage.example.protage.model.Dedicated dedicated, protage.example.protage.model.Integrated integrated, ArrayList<Headphones> headphones, ArrayList<Keyboard> keyboards, ArrayList<Microphone> microphones, protage.example.protage.model.Motherboard motherboard, ArrayList<MultimediaSoftware> multimediaSoftwares, protage.example.protage.model.OperatingSystem operatingSystem, protage.example.protage.model.PointingDevice pointingDevice, ArrayList<Port> ports, protage.example.protage.model.PowerSupply powerSupply, ArrayList<PresentationSoftware> presentationSoftwares, protage.example.protage.model.Processor processor, protage.example.protage.model.ProgramTranslator programTranslator, protage.example.protage.model.RAM RAM, protage.example.protage.model.SoundCard soundCard, protage.example.protage.model.Speakers speakers, ArrayList<SpreadsheetSoftware> spreadsheetSoftwares, ArrayList<Storage> storages, ArrayList<Utility> utilities, String whatToUpgrade) {
        Adapters = adapters;
        Cameras = cameras;
        Case = aCase;
        Display = display;
        Drivers = drivers;
        Fan = fan;
        Dedicated = dedicated;
        Integrated = integrated;
        Headphones = headphones;
        Keyboards = keyboards;
        Microphones = microphones;
        Motherboard = motherboard;
        MultimediaSoftwares = multimediaSoftwares;
        OperatingSystem = operatingSystem;
        PointingDevice = pointingDevice;
        Ports = ports;
        PowerSupply = powerSupply;
        PresentationSoftwares = presentationSoftwares;
        Processor = processor;
        ProgramTranslator = programTranslator;
        this.RAM = RAM;
        SoundCard = soundCard;
        Speakers = speakers;
        SpreadsheetSoftwares = spreadsheetSoftwares;
        Storages = storages;
        Utilities = utilities;
        WhatToUpgrade = whatToUpgrade;
    }

    public ArrayList<Adapter> getAdapters() {
        return Adapters;
    }

    public void setAdapters(ArrayList<Adapter> adapters) {
        Adapters = adapters;
    }

    public ArrayList<Camera> getCamera() {
        return Cameras;
    }

    public void setCameras(ArrayList<Camera> cameras) {
        Cameras = cameras;
    }

    public protage.example.protage.model.Case getCase() {
        return Case;
    }

    public void setCase(protage.example.protage.model.Case aCase) {
        Case = aCase;
    }

    public protage.example.protage.model.Display getDisplay() {
        return Display;
    }

    public void setDisplay(protage.example.protage.model.Display display) {
        Display = display;
    }

    public ArrayList<Driver> getDrivers() {
        return Drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        Drivers = drivers;
    }

    public protage.example.protage.model.Fan getFan() {
        return Fan;
    }

    public void setFan(protage.example.protage.model.Fan fan) {
        Fan = fan;
    }

    public protage.example.protage.model.Dedicated getDedicated() {
        return Dedicated;
    }

    public void setDedicated(protage.example.protage.model.Dedicated dedicated) {
        Dedicated = dedicated;
    }

    public protage.example.protage.model.Integrated getIntegrated() {
        return Integrated;
    }

    public void setIntegrated(protage.example.protage.model.Integrated integrated) {
        Integrated = integrated;
    }

    public ArrayList<Headphones> getHeadphones() {
        return Headphones;
    }

    public void setHeadphones(ArrayList<Headphones> headphones) {
        Headphones = headphones;
    }

    public ArrayList<Keyboard> getKeyboard() {
        return Keyboards;
    }

    public void setKeyboard(ArrayList<Keyboard> keyboards) {
        Keyboards = keyboards;
    }

    public ArrayList<Microphone> getMicrophone() {
        return Microphones;
    }

    public void setMicrophone(ArrayList<Microphone> microphones) {
        Microphones = microphones;
    }

    public protage.example.protage.model.Motherboard getMotherboard() {
        return Motherboard;
    }

    public void setMotherboard(protage.example.protage.model.Motherboard motherboard) {
        Motherboard = motherboard;
    }

    public ArrayList<MultimediaSoftware> getMultimediaSoftwares() {
        return MultimediaSoftwares;
    }

    public void setMultimediaSoftwares(ArrayList<MultimediaSoftware> multimediaSoftwares) {
        MultimediaSoftwares = multimediaSoftwares;
    }

    public protage.example.protage.model.OperatingSystem getOperatingSystem() {
        return OperatingSystem;
    }

    public void setOperatingSystem(protage.example.protage.model.OperatingSystem operatingSystem) {
        OperatingSystem = operatingSystem;
    }

    public protage.example.protage.model.PointingDevice getPointingDevice() {
        return PointingDevice;
    }

    public void setPointingDevice(protage.example.protage.model.PointingDevice pointingDevice) {
        PointingDevice = pointingDevice;
    }

    public ArrayList<Port> getPorts() {
        return Ports;
    }

    public void setPorts(ArrayList<Port> ports) {
        Ports = ports;
    }

    public protage.example.protage.model.PowerSupply getPowerSupply() {
        return PowerSupply;
    }

    public void setPowerSupply(protage.example.protage.model.PowerSupply powerSupply) {
        PowerSupply = powerSupply;
    }

    public ArrayList<PresentationSoftware> getPresentationSoftwares() {
        return PresentationSoftwares;
    }

    public void setPresentationSoftwares(ArrayList<PresentationSoftware> presentationSoftwares) {
        PresentationSoftwares = presentationSoftwares;
    }

    public protage.example.protage.model.Processor getProcessor() {
        return Processor;
    }

    public void setProcessor(protage.example.protage.model.Processor processor) {
        Processor = processor;
    }

    public protage.example.protage.model.ProgramTranslator getProgramTranslator() {
        return ProgramTranslator;
    }

    public void setProgramTranslator(protage.example.protage.model.ProgramTranslator programTranslator) {
        ProgramTranslator = programTranslator;
    }

    public protage.example.protage.model.RAM getRAM() {
        return RAM;
    }

    public void setRAM(protage.example.protage.model.RAM RAM) {
        this.RAM = RAM;
    }

    public protage.example.protage.model.SoundCard getSoundCard() {
        return SoundCard;
    }

    public void setSoundCard(protage.example.protage.model.SoundCard soundCard) {
        SoundCard = soundCard;
    }

    public protage.example.protage.model.Speakers getSpeakers() {
        return Speakers;
    }

    public void setSpeakers(protage.example.protage.model.Speakers speakers) {
        Speakers = speakers;
    }

    public ArrayList<SpreadsheetSoftware> getSpreadsheetSoftwares() {
        return SpreadsheetSoftwares;
    }

    public void setSpreadsheetSoftwares(ArrayList<SpreadsheetSoftware> spreadsheetSoftwares) {
        SpreadsheetSoftwares = spreadsheetSoftwares;
    }

    public ArrayList<Storage> getStorages() {
        return Storages;
    }

    public void setStorages(ArrayList<Storage> storages) {
        Storages = storages;
    }

    public ArrayList<Utility> getUtilities() {
        return Utilities;
    }

    public void setUtilities(ArrayList<Utility> utilities) {
        Utilities = utilities;
    }

    public String getWhatToUpgrade() {
        return WhatToUpgrade;
    }

    public void setWhatToUpgrade(String whatToUpgrade) {
        WhatToUpgrade = whatToUpgrade;
    }
}
