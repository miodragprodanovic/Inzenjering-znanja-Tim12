package protage.example.protage.model;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name="getBetterComponent")
public class GetBetterComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private ArrayList<Adapter> Adapters;
    private Camera Camera;
    private Case Case;
    private Display Display;
    private ArrayList<Driver> Drivers;
    private Fan Fan;
    private ArrayList<GraphicsCard> GraphicsCards;
    private Headphones Headphones;
    private Keyboard Keyboard;
    private Microphone Microphone;
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

    public GetBetterComponent(long id, ArrayList<Adapter> adapters, protage.example.protage.model.Camera camera, protage.example.protage.model.Case aCase, protage.example.protage.model.Display display, ArrayList<Driver> drivers, protage.example.protage.model.Fan fan, ArrayList<GraphicsCard> graphicsCards, protage.example.protage.model.Headphones headphones, protage.example.protage.model.Keyboard keyboard, protage.example.protage.model.Microphone microphone, protage.example.protage.model.Motherboard motherboard, ArrayList<MultimediaSoftware> multimediaSoftwares, protage.example.protage.model.OperatingSystem operatingSystem, protage.example.protage.model.PointingDevice pointingDevice, ArrayList<Port> ports, protage.example.protage.model.PowerSupply powerSupply, ArrayList<PresentationSoftware> presentationSoftwares, protage.example.protage.model.Processor processor, protage.example.protage.model.ProgramTranslator programTranslator, protage.example.protage.model.RAM RAM, protage.example.protage.model.SoundCard soundCard, protage.example.protage.model.Speakers speakers, ArrayList<SpreadsheetSoftware> spreadsheetSoftwares, ArrayList<Storage> storages, ArrayList<Utility> utilities, String whatToUpgrade) {
        this.id = id;
        Adapters = adapters;
        Camera = camera;
        Case = aCase;
        Display = display;
        Drivers = drivers;
        Fan = fan;
        GraphicsCards = graphicsCards;
        Headphones = headphones;
        Keyboard = keyboard;
        Microphone = microphone;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Adapter> getAdapters() {
        return Adapters;
    }

    public void setAdapters(ArrayList<Adapter> adapters) {
        Adapters = adapters;
    }

    public protage.example.protage.model.Camera getCamera() {
        return Camera;
    }

    public void setCamera(protage.example.protage.model.Camera camera) {
        Camera = camera;
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

    public ArrayList<GraphicsCard> getGraphicsCards() {
        return GraphicsCards;
    }

    public void setGraphicsCards(ArrayList<GraphicsCard> graphicsCards) {
        GraphicsCards = graphicsCards;
    }

    public protage.example.protage.model.Headphones getHeadphones() {
        return Headphones;
    }

    public void setHeadphones(protage.example.protage.model.Headphones headphones) {
        Headphones = headphones;
    }

    public protage.example.protage.model.Keyboard getKeyboard() {
        return Keyboard;
    }

    public void setKeyboard(protage.example.protage.model.Keyboard keyboard) {
        Keyboard = keyboard;
    }

    public protage.example.protage.model.Microphone getMicrophone() {
        return Microphone;
    }

    public void setMicrophone(protage.example.protage.model.Microphone microphone) {
        Microphone = microphone;
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
