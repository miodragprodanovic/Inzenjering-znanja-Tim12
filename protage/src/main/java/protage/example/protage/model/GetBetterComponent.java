package protage.example.protage.model;
import java.util.ArrayList;


public class GetBetterComponent {
    private ArrayList<Adapter> Adapters;
    private Camera Camera;
    private Case Case;
    private Display Display;
    private ArrayList<Driver> Drivers;
    private Fan Fan;
    private Dedicated Dedicated;
    private Integrated Integrated;
    private Headphones Headphones;
    private Keyboard Keyboard;
    private Microphone Microphone;
    private Mouse Mouse;
    private Joystick Joystick;
    private Motherboard Motherboard;
    private ArrayList<MultimediaSoftware> MultimediaSoftwares;
    private OperatingSystem OperatingSystem;
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

    public GetBetterComponent(ArrayList<Adapter> adapters, Camera camera, Case aCase, Display display, ArrayList<Driver> drivers,
                              Fan fan, Dedicated dedicated, Integrated integrated, Headphones headphones, Joystick joystick,
                              Keyboard keyboard, Microphone microphone, Motherboard motherboard, Mouse mouse,
                              ArrayList<MultimediaSoftware> multimediaSoftwares, OperatingSystem operatingSystem,
                              ArrayList<Port> ports, PowerSupply powerSupply, ArrayList<PresentationSoftware> presentationSoftwares,
                              Processor processor, ProgramTranslator programTranslator, RAM RAM, SoundCard soundCard,
                              Speakers speakers, ArrayList<SpreadsheetSoftware> spreadsheetSoftwares, ArrayList<Storage> storages,
                              ArrayList<Utility> utilities, String whatToUpgrade) {
        Adapters = adapters;
        Camera = camera;
        Case = aCase;
        Display = display;
        Drivers = drivers;
        Fan = fan;
        Dedicated = dedicated;
        Integrated = integrated;
        Headphones = headphones;
        Joystick = joystick;
        Keyboard = keyboard;
        Microphone = microphone;
        Motherboard = motherboard;
        Mouse = mouse;
        MultimediaSoftwares = multimediaSoftwares;
        OperatingSystem = operatingSystem;
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

    public Camera getCamera() {
        return Camera;
    }

    public void setCamera(Camera camera) {
        Camera = camera;
    }

    public Case getCase() {
        return Case;
    }

    public void setCase(Case aCase) {
        Case = aCase;
    }

    public Display getDisplay() {
        return Display;
    }

    public void setDisplay(Display display) {
        Display = display;
    }

    public ArrayList<Driver> getDrivers() {
        return Drivers;
    }

    public void setDrivers(ArrayList<Driver> drivers) {
        Drivers = drivers;
    }

    public Fan getFan() {
        return Fan;
    }

    public void setFan(Fan fan) {
        Fan = fan;
    }

    public Dedicated getDedicated() {
        return Dedicated;
    }

    public void setDedicated(Dedicated dedicated) {
        Dedicated = dedicated;
    }

    public Integrated getIntegrated() {
        return Integrated;
    }

    public void setIntegrated(Integrated integrated) {
        Integrated = integrated;
    }

    public Headphones getHeadphones() {
        return Headphones;
    }

    public void setHeadphones(Headphones headphones) {
        Headphones = headphones;
    }

    public Joystick getJoystick() {
        return Joystick;
    }

    public void setJoystick(Joystick joystick) {
        Joystick = joystick;
    }

    public Keyboard getKeyboard() {
        return Keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        Keyboard = keyboard;
    }

    public Microphone getMicrophone() {
        return Microphone;
    }

    public void setMicrophone(Microphone microphone) {
        Microphone = microphone;
    }

    public Motherboard getMotherboard() {
        return Motherboard;
    }

    public void setMotherboard(Motherboard motherboard) {
        Motherboard = motherboard;
    }

    public Mouse getMouse() {
        return Mouse;
    }

    public void setMouse(Mouse mouse) {
        Mouse = mouse;
    }

    public ArrayList<MultimediaSoftware> getMultimediaSoftwares() {
        return MultimediaSoftwares;
    }

    public void setMultimediaSoftwares(ArrayList<MultimediaSoftware> multimediaSoftwares) {
        MultimediaSoftwares = multimediaSoftwares;
    }

    public OperatingSystem getOperatingSystem() {
        return OperatingSystem;
    }

    public void setOperatingSystem(OperatingSystem operatingSystem) {
        OperatingSystem = operatingSystem;
    }

    public ArrayList<Port> getPorts() {
        return Ports;
    }

    public void setPorts(ArrayList<Port> ports) {
        Ports = ports;
    }

    public PowerSupply getPowerSupply() {
        return PowerSupply;
    }

    public void setPowerSupply(PowerSupply powerSupply) {
        PowerSupply = powerSupply;
    }

    public ArrayList<PresentationSoftware> getPresentationSoftwares() {
        return PresentationSoftwares;
    }

    public void setPresentationSoftwares(ArrayList<PresentationSoftware> presentationSoftwares) {
        PresentationSoftwares = presentationSoftwares;
    }

    public Processor getProcessor() {
        return Processor;
    }

    public void setProcessor(Processor processor) {
        Processor = processor;
    }

    public ProgramTranslator getProgramTranslator() {
        return ProgramTranslator;
    }

    public void setProgramTranslator(ProgramTranslator programTranslator) {
        ProgramTranslator = programTranslator;
    }

    public RAM getRAM() {
        return RAM;
    }

    public void setRAM(RAM RAM) {
        this.RAM = RAM;
    }

    public SoundCard getSoundCard() {
        return SoundCard;
    }

    public void setSoundCard(SoundCard soundCard) {
        SoundCard = soundCard;
    }

    public Speakers getSpeakers() {
        return Speakers;
    }

    public void setSpeakers(Speakers speakers) {
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
