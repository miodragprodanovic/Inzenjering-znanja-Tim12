package protage.example.protage.controller;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import protage.example.protage.Jena.Jena;
import protage.example.protage.model.*;
import unbbayes.io.NetIO;
import unbbayes.prs.Node;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.ProbabilisticNode;
import unbbayes.util.extension.bn.inference.IInferenceAlgorithm;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;


@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ControllerForApp {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    @PostMapping("/getBetterComponent")
    public ResponseEntity<ArrayList<String>> getBetterComponent(@RequestBody GetBetterComponent getBetterComponentBody) {

        if (getBetterComponentBody.getWhatToUpgrade().equals("ethernetCard")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("wirelessCard")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("camera")) {
            ArrayList<String> better = makeQuery("isCameraBetterThan", getBetterComponentBody.getCamera().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<>();
            result.add("----BETTER CAMERA----");
            result.addAll(better);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("case")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("display")) {
            ArrayList<String> preferable = makeQuery("isDisplayMorePreferableThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> bigger = makeQuery("isDisplayBiggerThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> refreshRate = makeQuery("isDisplayRefreshRateMoreThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> resolution = makeQuery("isDisplayResolutionMoreThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<>();
            result.add("----MORE PREFERABLE----");
            result.addAll(preferable);
            result.add("----BIGGER----");
            result.addAll(bigger);
            result.add("----BETTER REFRESH RATE----");
            result.addAll(refreshRate);
            result.add("----BETTER RESOLUTION----");
            result.addAll(resolution);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("fan")) {
            ArrayList<String> powerful = makeQuery("isFanMorePowerfulThan", getBetterComponentBody.getFan().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<>();
            result.add("----MORE POWERFUL----");
            result.addAll(powerful);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("dedicated")) {
            ArrayList<String> faster = makeQuery("isGraphicsCardFasterThan",getBetterComponentBody.getDedicated().toString(),"isMotherboardAndDedicatedGraphicsCardCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible",getBetterComponentBody.getPowerSupply().toString());
            ArrayList<String> preferable = makeQuery("isGraphicsCardPreferableThan",getBetterComponentBody.getDedicated().toString(),"isMotherboardAndDedicatedGraphicsCardCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible",getBetterComponentBody.getPowerSupply().toString());
            ArrayList<String> memory = makeQuery("isGraphicsCardMemoryMoreThan",getBetterComponentBody.getDedicated().toString(),"isMotherboardAndDedicatedGraphicsCardCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible",getBetterComponentBody.getPowerSupply().toString());
            ArrayList<String> result = new ArrayList<>();
            result.add("----FASTER----");
            result.addAll(faster);
            result.add("----PREFERABLE----");
            result.addAll(preferable);
            result.add("----MORE MEMORY----");
            result.addAll(memory);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("integrated")) {
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isGraphicsCardFasterThan ins:"+getBetterComponentBody.getIntegrated()+". ?x a kls:Integrated }";
            ArrayList<String> faster = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isGraphicsCardPreferableThan ins:"+getBetterComponentBody.getIntegrated()+". ?x a kls:Integrated }";
            ArrayList<String> preferable = Jena.execQuery(queryString);
            ArrayList<String> result = new ArrayList<>();
            result.add("----FASTER----");
            result.addAll(faster);
            result.add("----PREFERABLE----");
            result.addAll(preferable);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("headphones")) {
            ArrayList<String> comfortable = makeQuery("areHeadphonesMoreComfortableThan", getBetterComponentBody.getHeadphones().toString(),"","","","");
            ArrayList<String> betterFrequencyResponse = makeQuery("hasBetterHeadphonesFrequencyResponseRangeThan", getBetterComponentBody.getHeadphones().toString(),"","","","");
            ArrayList<String> betterNoiseIsolation = makeQuery("hasBetterNoiseIsolationThan", getBetterComponentBody.getHeadphones().toString(),"","","","");
            ArrayList<String> result = new ArrayList<>();
            result.add("----COMFORTABLE----");
            result.addAll(comfortable);
            result.add("----BETTER FREQUENCY RESPONSE----");
            result.addAll(betterFrequencyResponse);
            result.add("----BETTER NOISE ISOLATION----");
            result.addAll(betterNoiseIsolation);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("joystick")) {
            ArrayList<String> better = makeQuery("isJoystickBetterThan", getBetterComponentBody.getJoystick().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<>();
            result.add("----BETTER JOYSTICK----");
            result.addAll(better);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("keyboard")) {
            ArrayList<String> betterKeystroke = makeQuery("hasBetterKeystrokeThan", getBetterComponentBody.getKeyboard().toString(),"","","","");
            ArrayList<String> comfortable = makeQuery("isKeyboardMoreComfortableThan", getBetterComponentBody.getKeyboard().toString(),"","","","");
            ArrayList<String> durable = makeQuery("isKeyboardMoreDurableThan", getBetterComponentBody.getKeyboard().toString(),"","","","");
            ArrayList<String> result = new ArrayList<>();
            result.add("----BETTER KEYSTROKE----");
            result.addAll(betterKeystroke);
            result.add("----MORE COMFORTABLE----");
            result.addAll(comfortable);
            result.add("----MORE DURABLE----");
            result.addAll(durable);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("microphone")) {
            ArrayList<String> silent = makeQuery("isMicrophoneBetterRegistringSilentVoicesThan", getBetterComponentBody.getMicrophone().toString(),"","","","");
            ArrayList<String> differentVolumes = makeQuery("isMicrophoneBetterRegistringDifferentVolumesOfSoundsThan", getBetterComponentBody.getMicrophone().toString(),"","","","");
            ArrayList<String> result = new ArrayList<>();
            result.add("----BETTER REGISTRING SILENT VOICES----");
            result.addAll(silent);
            result.add("----BETTER REGISTRING DIFFERENT VOLUMES----");
            result.addAll(differentVolumes);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("motherboard")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("mouse")) {
            ArrayList<String> betterPollingRate = makeQuery("hasBetterPollingRateThan", getBetterComponentBody.getMouse().toString(),"","","","");
            ArrayList<String> comfortable = makeQuery("isMouseMoreComfortableThan", getBetterComponentBody.getMouse().toString(),"","","","");
            ArrayList<String> sensitive = makeQuery("isMouseMoreSensitiveThan", getBetterComponentBody.getMouse().toString(),"","","","");
            ArrayList<String> result = new ArrayList<>();
            result.add("----BETTER POLLING RATE----");
            result.addAll(betterPollingRate);
            result.add("----MORE SENSITIVE----");
            result.addAll(sensitive);
            result.add("----MORE COMFORTABLE----");
            result.addAll(comfortable);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("powerSupply")) {
            ArrayList<String> stronger = makeQuery("isPowerSupplyStrongerThan", getBetterComponentBody.getPowerSupply().toString(),"isMotherboardAndPowerSupplyCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible", getBetterComponentBody.getDedicated().toString());
            ArrayList<String> result = new ArrayList<>();
            result.add("----STRONGER----");
            result.addAll(stronger);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("processor")) {
            ArrayList<String> faster = makeQuery("isProcessorFasterThan", getBetterComponentBody.getProcessor().toString(), "isMotherboardAndProcessorCompatible", getBetterComponentBody.getMotherboard().toString(), "","");
            ArrayList<String> result = new ArrayList<>();
            result.add("----FASTER----");
            result.addAll(faster);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("port")) {
            String queryString = "";
            for (int i = 0; i < getBetterComponentBody.getPorts().size(); i++) {
                ArrayList<String> list = makeQuery("isUSBPortMorePreferedThan", getBetterComponentBody.getPorts().get(i).toString(),"","","","");
                if (list.size() != 0) {
                    break;
                }
            }
            ArrayList<String> prefered = Jena.execQuery(queryString);
            ArrayList<String> result = new ArrayList<>();
            result.add("----PREFERRED----");
            result.addAll(prefered);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("ram")) {
            ArrayList<String> preferable = makeQuery("isRAMMorePreferableThan", getBetterComponentBody.getRAM().toString(),"isMotherboardAndRAMCompatible", getBetterComponentBody.getMotherboard().toString(), "","");
            ArrayList<String> storage = makeQuery("isRAMStorageMoreThan", getBetterComponentBody.getRAM().toString(),"isMotherboardAndRAMCompatible", getBetterComponentBody.getMotherboard().toString(), "","");
            ArrayList<String> result = new ArrayList<>();
            result.addAll(preferable);
            result.add("----MORE CAPACITY----");
            result.addAll(storage);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("soundCard")) {
            ArrayList<String> better = makeQuery("isSoundCardBetterThan", getBetterComponentBody.getSoundCard().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<>();
            result.add("----BETTER SOUND CARD----");
            result.addAll(better);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("speakers")) {
            ArrayList<String> powerful = makeQuery("areSpeakersMorePowerfulThan", getBetterComponentBody.getSpeakers().toString(),"","","","");
            ArrayList<String> result = new ArrayList<>();
            result.add("----MORE POWERFUL----");
            result.addAll(powerful);

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("storage")) {
            ArrayList<String> capacity = makeQuery("isStorageCapacityMoreThan", getBetterComponentBody.getStorages().get(0).toString(),"","","","");
            ArrayList<String> preferable = makeQuery("isStorageCapacityPreferableThan", getBetterComponentBody.getStorages().get(0).toString(),"","","","");

            ArrayList<String> result = new ArrayList<>();
            result.add("----FOR " + getBetterComponentBody.getStorages().get(0) + "----");
            result.add("----MORE CAPACITY----");
            result.addAll(capacity);
            result.add("----MORE PREFERABLE----");
            result.addAll(preferable);
            if (getBetterComponentBody.getStorages().size() > 1) {
                ArrayList<String> capacity1 = makeQuery("isStorageCapacityMoreThan", getBetterComponentBody.getStorages().get(1).toString(),"","","","");
                ArrayList<String> preferable1 = makeQuery("isStorageCapacityPreferableThan", getBetterComponentBody.getStorages().get(1).toString(),"","","","");
                result.add("----FOR " + getBetterComponentBody.getStorages().get(1) + "----");
                result.add("----MORE CAPACITY----");
                result.addAll(capacity1);
                result.add("----MORE PREFERABLE----");
                result.addAll(preferable1);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("multimediaSoftwares")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("presentationSoftware")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("spreadsheetSoftware")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("webBrowser")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("operatingSystem")) {

        }
        else if (getBetterComponentBody.getWhatToUpgrade().equals("systemSoftware")) {

        }

        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
    }

    private ArrayList<String> makeQuery(String objectProperty, String component, String compatibleObjectProperty, String compatibleComponent, String compatibleObjectProperty1, String compatibleComponent1){
        if (Objects.equals(compatibleObjectProperty, "")) {
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                    "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                    "SELECT ?x WHERE { ?x kls:" + objectProperty + " ins:" + component + ".}";

            return Jena.execQuery(queryString);
        }
        else {
            String queryString;
            if (Objects.equals(compatibleObjectProperty1, "")) {
                queryString =
                        "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                        "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                        "SELECT ?x WHERE { ?x kls:" + objectProperty + " ins:" + component + "." +
                        "?x kls:" + compatibleObjectProperty + " ins:" + compatibleComponent + "." + "}";

            }
            else {
                queryString =
                        "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                        "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                        "SELECT ?x WHERE { ?x kls:" + objectProperty + " ins:" + component + "." +
                        "?x kls:" + compatibleObjectProperty + " ins:" + compatibleComponent + "." +
                        "?x kls:" + compatibleObjectProperty1 + " ins:" + compatibleComponent1 + "." + "}";

            }

            return Jena.execQuery(queryString);
        }
    }

    @PostMapping("/getBetterComponentJsonBody")
    public ResponseEntity<GetBetterComponent> getBetterComponentJsonBody() {
        GetBetterComponent body = new GetBetterComponent();
        ArrayList<Adapter> adapters = new ArrayList<>();
        ArrayList<Driver> drivers = new ArrayList<>();
        ArrayList<MultimediaSoftware> multimediaSoftwares = new ArrayList<>();
        ArrayList<Port> ports = new ArrayList<>();
        ArrayList<PresentationSoftware> presentationSoftwares = new ArrayList<>();
        ArrayList<SpreadsheetSoftware> spreadsheetSoftwares = new ArrayList<>();
        ArrayList<Storage> storages = new ArrayList<>();
        ArrayList<Utility> utilities = new ArrayList<>();
        adapters.add(Adapter.WiFi_BluetoothCard_AX210);
        adapters.add(Adapter.EthernetCard_BCM5719_4P);
        ports.add(Port.USBPort_2x2);
        ports.add(Port.HDMIPort);
        ports.add(Port.HeadphonesPort);
        ports.add(Port.MicrophonePort);
        storages.add(Storage.HDD_256GB);
        storages.add(Storage.SSD_256GB);
        utilities.add(Utility.CCleaner);
        body.setAdapters(adapters);
        body.setCamera(Camera.Camera_Logitech_C505e);
        body.setCase(Case.Case_3040);
        body.setDisplay(Display.Display_Sceptre);
        body.setDrivers(drivers);
        body.setFan(Fan.Fan_CP3);
        body.setDedicated(Dedicated.GraphicsCard_NVIDIA_GeForce_GTX_950);
        body.setIntegrated(Integrated.GraphicsCard_Intel_HD_Graphics_530);
        body.setHeadphones(Headphones.Headphones_On_Ear_AKG_Y400);
        body.setJoystick(Joystick.Joystick_Logitech_943);
        body.setKeyboard(Keyboard.Keyboard_Ergonomic_Logitech_Ergo_K860);
        body.setMicrophone(Microphone.Microphone_Boya_BY_PM300);
        body.setMotherboard(Motherboard.Motherboard_B365M);
        body.setMouse(Mouse.Mouse_Logitech_MX_Master_3);
        body.setMultimediaSoftwares(multimediaSoftwares);
        body.setOperatingSystem(OperatingSystem.OperatingSystem_Windows_10_Pro);
        body.setPorts(ports);
        body.setPowerSupply(PowerSupply.PowerSupply_HU180);
        body.setPresentationSoftwares(presentationSoftwares);
        body.setProcessor(Processor.Processor_i5_6400);
        body.setProgramTranslator(ProgramTranslator.ProgramTranslator_Asembler);
        body.setRAM(RAM.DDR3_16GB);
        body.setSoundCard(SoundCard.SoundCard_FAST_ASIA_USB_7_1);
        body.setSpeakers(Speakers.Speakers_Z313);
        body.setSpreadsheetSoftwares(spreadsheetSoftwares);
        body.setStorages(storages);
        body.setUtilities(utilities);

        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    private String getComponentDataTypes(String component, String what) {
        String queryString =
                "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                "SELECT ?param WHERE { ?x kls:Name \"" + component + "\"^^<http://www.w3.org/2001/XMLSchema#string>." +
                "?x kls:" + what + " ?param .}" +
                "LIMIT 1";

        return Jena.execQuery2(queryString, "param");
    }

    @PostMapping("/getComputerPurpose")
    public ResponseEntity<ArrayList<String>> getComputerPurpose(@RequestBody GetBetterComponent getBetterComponentBody) {
        int RAMCapacity = 0;
        int StorageCapacity = 0;
        int GraphicsCardSpeed = 0;
        int PowerSupplyWattPower = 0;
        int FanAirFlowCapacity = 0;
        int SpeakersWattPower = 0;
        int Price = 0;

        int ramPrice = 0;
        int graphicsCardPrice = 0;
        int storagePrice = 0;
        int powerSupplyPrice = 0;
        int fanPrice = 0;
        int speakersPrice = 0;

        if (getBetterComponentBody.getRAM() != null) {
             RAMCapacity = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getRAM().toString(),"RAMCapacityString").split("G")[0]);
             ramPrice = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getRAM().toString(),"Price"));
             Price += ramPrice;
        }
        if (getBetterComponentBody.getDedicated() == null) {
            if (getBetterComponentBody.getIntegrated() != null) {
                GraphicsCardSpeed = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getIntegrated().toString(),"GraphicsCardSpeedString").split("M")[0]);
                Price += 0;
            }
        }
        else if (getBetterComponentBody.getDedicated() != null) {
            GraphicsCardSpeed = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getDedicated().toString(),"GraphicsCardSpeedString").split("M")[0]);
            graphicsCardPrice = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getDedicated().toString(),"Price"));
            Price += graphicsCardPrice;
        }
        if (getBetterComponentBody.getStorages() != null) {
            for (Storage s: getBetterComponentBody.getStorages()) {
                StorageCapacity  += Integer.parseInt(getComponentDataTypes(s.toString(), "StorageCapacityString").split("G")[0]);
                storagePrice = Integer.parseInt(getComponentDataTypes(s.toString(), "Price"));
                Price += storagePrice;
            }
        }
        if (getBetterComponentBody.getPowerSupply() != null) {
            PowerSupplyWattPower = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getPowerSupply().toString(),"PowerSupplyWattPower"));
            powerSupplyPrice = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getPowerSupply().toString(),"Price"));
            Price += powerSupplyPrice;
        }
        if (getBetterComponentBody.getFan() != null) {
            FanAirFlowCapacity = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getFan().toString(),"FanAirFlowCapacityString").split("C")[0]);
            fanPrice = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getFan().toString(),"Price"));
            Price += fanPrice;
        }
        if (getBetterComponentBody.getSpeakers() != null) {
            SpeakersWattPower = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getSpeakers().toString(),"SpeakersWattPower"));
            speakersPrice = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getSpeakers().toString(),"Price"));
            Price += speakersPrice;
        }

        FIS fis = FIS.load("fl.fcl", true);

        if (fis == null) {
            System.err.println("Can't load file");
            System.exit(1);
        }
        FunctionBlock fb = fis.getFunctionBlock("sablon");
        JFuzzyChart.get().chart(fb);

        if (RAMCapacity != 0) {
            fis.setVariable("RAMCapacity", RAMCapacity);
        }
        if (StorageCapacity != 0) {
            fis.setVariable("StorageCapacity", StorageCapacity);
        }
        else {
            fis.setVariable("StorageCapacity", 1);
        }
        if (GraphicsCardSpeed != 0) {
            fis.setVariable("GraphicsCardSpeed", GraphicsCardSpeed);
        }
        else {
            fis.setVariable("GraphicsCardSpeed", 50);
        }
        if (PowerSupplyWattPower != 0) {
            fis.setVariable("PowerSupplyWattPower", PowerSupplyWattPower);
        }
        else {
            fis.setVariable("PowerSupplyWattPower", 50);
        }
        if (FanAirFlowCapacity != 0) {
            fis.setVariable("FanAirFlowCapacity", FanAirFlowCapacity);
        }
        else {
            fis.setVariable("FanAirFlowCapacity", 6);
        }
        if (SpeakersWattPower != 0) {
            fis.setVariable("SpeakersWattPower", SpeakersWattPower);
        }
        else {
            fis.setVariable("SpeakersWattPower", 1);
        }
        if (Price != 0) {
            fis.setVariable("Price", Price);
        }
        if (ramPrice != 0) {
            fis.setVariable("RamPrice", ramPrice);
        }
        if (graphicsCardPrice != 0) {
            fis.setVariable("GraphicsCardPrice", graphicsCardPrice);
        }
        if (storagePrice != 0) {
            fis.setVariable("StoragePrice", storagePrice);
        }
        if (powerSupplyPrice != 0) {
            fis.setVariable("PowerSupplyPrice", powerSupplyPrice);
        }
        if (fanPrice != 0) {
            fis.setVariable("FanPrice", fanPrice);
        }
        if (speakersPrice != 0) {
            fis.setVariable("SpeakersPrice", speakersPrice);
        }

        fis.evaluate();

        Variable Home = fis.getFunctionBlock("sablon").getVariable("Home");
        JFuzzyChart.get().chart(Home, Home.getDefuzzifier(), true);
        Variable Work = fis.getFunctionBlock("sablon").getVariable("Work");
        JFuzzyChart.get().chart(Work, Work.getDefuzzifier(), true);
        Variable Gaming = fis.getFunctionBlock("sablon").getVariable("Gaming");
        JFuzzyChart.get().chart(Gaming, Gaming.getDefuzzifier(), true);
        Variable Hosting = fis.getFunctionBlock("sablon").getVariable("Hosting");
        JFuzzyChart.get().chart(Hosting, Hosting.getDefuzzifier(), true);
        Variable Mining = fis.getFunctionBlock("sablon").getVariable("Mining");
        JFuzzyChart.get().chart(Mining, Mining.getDefuzzifier(), true);
        System.out.println("Home: " + Home.getValue()/100);
        System.out.println("Work: " + Work.getValue()/100);
        System.out.println("Gaming: " + Gaming.getValue()/100);
        System.out.println("Hosting: " + Hosting.getValue()/100);
        System.out.println("Mining: " + Mining.getValue()/100);

        ArrayList<String> response = new ArrayList<>();
        response.add("Home: " + df.format(Home.getValue()/100));
        response.add("Work: " + df.format(Work.getValue()/100));
        response.add("Gaming: " + df.format(Gaming.getValue()/100));
        response.add("Hosting: " + df.format(Hosting.getValue()/100));
        response.add("Mining: " + df.format(Mining.getValue()/100));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/getComputerError")
    public ResponseEntity<ArrayList<String>> getComputerError(@RequestBody GetBetterComponent getBetterComponentBody) throws IOException {
        List<String> simptomi = new ArrayList<>();

        Collections.addAll(simptomi, getBetterComponentBody.getWhatToUpgrade().split(";"));

        int RAMCapacity = 0;
        int StorageCapacity = 0;
        int GraphicsCardSpeed = 0;
        int PowerSupplyWattPower = 0;
        int FanAirFlowCapacity = 0;
        int SpeakersWattPower = 0;
        String DisplayResolution = "";

        if (getBetterComponentBody.getRAM() != null) {
            RAMCapacity = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getRAM().toString(),"RAMCapacityString").split("G")[0]);
        }
        if (getBetterComponentBody.getDedicated() == null) {
            if (getBetterComponentBody.getIntegrated() != null) {
                GraphicsCardSpeed = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getIntegrated().toString(),"GraphicsCardSpeedString").split("M")[0]);
            }
        }
        else if (getBetterComponentBody.getDedicated() != null) {
            GraphicsCardSpeed = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getDedicated().toString(),"GraphicsCardSpeedString").split("M")[0]);
        }
        if (getBetterComponentBody.getStorages() != null) {
            for (Storage s: getBetterComponentBody.getStorages()) {
                StorageCapacity  += Integer.parseInt(getComponentDataTypes(s.toString(), "StorageCapacityString").split("G")[0]);
            }
        }
        if (getBetterComponentBody.getPowerSupply() != null) {
            PowerSupplyWattPower = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getPowerSupply().toString(),"PowerSupplyWattPower"));
        }
        if (getBetterComponentBody.getFan() != null) {
            FanAirFlowCapacity = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getFan().toString(),"FanAirFlowCapacityString").split("C")[0]);
        }
        if (getBetterComponentBody.getSpeakers() != null) {
            SpeakersWattPower = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getSpeakers().toString(),"SpeakersWattPower"));
        }
        if (getBetterComponentBody.getDisplay() != null) {
            DisplayResolution = getComponentDataTypes(getBetterComponentBody.getDisplay().toString(),"DisplayResolution");
        }

        ProbabilisticNetwork net = null;
        try {
            net = (ProbabilisticNetwork)new NetIO().load(new File("bajes.net"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        ProbabilisticNode Nece_da_se_upali = (ProbabilisticNode)net.getNode("Nece_da_se_upali");
        ProbabilisticNode Upali_se_ali_ne_radi = (ProbabilisticNode)net.getNode("Upali_se_ali_ne_radi");
        ProbabilisticNode Display_se_zamrzne = (ProbabilisticNode)net.getNode("Display_se_zamrzne");
        ProbabilisticNode Nema_dovoljno_memorije = (ProbabilisticNode)net.getNode("Nema_dovoljno_memorije");
        ProbabilisticNode Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan = (ProbabilisticNode)net.getNode("Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan");
        ProbabilisticNode Blue_screen = (ProbabilisticNode)net.getNode("Blue_screen");
        ProbabilisticNode Motherboard = (ProbabilisticNode)net.getNode("Motherboard");
        ProbabilisticNode Power_supply = (ProbabilisticNode)net.getNode("Power_supply");
        ProbabilisticNode RAM = (ProbabilisticNode)net.getNode("RAM");
        ProbabilisticNode Graphics_card = (ProbabilisticNode)net.getNode("Graphics_card");
        ProbabilisticNode Storage = (ProbabilisticNode)net.getNode("Storage");
        ProbabilisticNode Fan = (ProbabilisticNode)net.getNode("Fan");
        ProbabilisticNode Display = (ProbabilisticNode)net.getNode("Display");
        ProbabilisticNode Slika_je_mutna = (ProbabilisticNode)net.getNode("Slika_je_mutna");
        ProbabilisticNode Nema_slike = (ProbabilisticNode)net.getNode("Nema_slike");
        ProbabilisticNode Speakers = (ProbabilisticNode)net.getNode("Speakers");
        ProbabilisticNode Nema_zvuka = (ProbabilisticNode)net.getNode("Nema_zvuka");
        ProbabilisticNode Javljaju_se_sumovi = (ProbabilisticNode)net.getNode("Javljaju_se_sumovi");

        Motherboard.getProbabilityFunction().setValue(0,0);
        Motherboard.getProbabilityFunction().setValue(1,1);
        Motherboard.getProbabilityFunction().setValue(2,0);
        if (PowerSupplyWattPower <= 325) {
            Power_supply.getProbabilityFunction().setValue(0,1);
            Power_supply.getProbabilityFunction().setValue(1,0);
            Power_supply.getProbabilityFunction().setValue(2,0);
        }
        else if (PowerSupplyWattPower >= 326 && PowerSupplyWattPower <= 625) {
            Power_supply.getProbabilityFunction().setValue(0,0);
            Power_supply.getProbabilityFunction().setValue(1,1);
            Power_supply.getProbabilityFunction().setValue(2,0);
        }
        else if (PowerSupplyWattPower >= 626) {
            Power_supply.getProbabilityFunction().setValue(0,0);
            Power_supply.getProbabilityFunction().setValue(1,0);
            Power_supply.getProbabilityFunction().setValue(2,1);
        }
        if (RAMCapacity <= 21) {
            RAM.getProbabilityFunction().setValue(0,1);
            RAM.getProbabilityFunction().setValue(1,0);
            RAM.getProbabilityFunction().setValue(2,0);
        }
        else if (RAMCapacity >= 22 && RAMCapacity <= 46) {
            RAM.getProbabilityFunction().setValue(0,0);
            RAM.getProbabilityFunction().setValue(1,1);
            RAM.getProbabilityFunction().setValue(2,0);
        }
        else if (RAMCapacity >= 47) {
            RAM.getProbabilityFunction().setValue(0,0);
            RAM.getProbabilityFunction().setValue(1,0);
            RAM.getProbabilityFunction().setValue(2,1);
        }
        if (GraphicsCardSpeed <= 700) {
            Graphics_card.getProbabilityFunction().setValue(0,1);
            Graphics_card.getProbabilityFunction().setValue(1,0);
            Graphics_card.getProbabilityFunction().setValue(2,0);
        }
        else if (GraphicsCardSpeed >= 701 && GraphicsCardSpeed <= 1400) {
            Graphics_card.getProbabilityFunction().setValue(0,0);
            Graphics_card.getProbabilityFunction().setValue(1,1);
            Graphics_card.getProbabilityFunction().setValue(2,0);
        }
        else if (GraphicsCardSpeed >= 1401) {
            Graphics_card.getProbabilityFunction().setValue(0,0);
            Graphics_card.getProbabilityFunction().setValue(1,0);
            Graphics_card.getProbabilityFunction().setValue(2,1);
        }
        if (StorageCapacity <= 325) {
            Storage.getProbabilityFunction().setValue(0,1);
            Storage.getProbabilityFunction().setValue(1,0);
            Storage.getProbabilityFunction().setValue(2,0);
        }
        else if (StorageCapacity >= 326 && StorageCapacity <= 625) {
            Storage.getProbabilityFunction().setValue(0,0);
            Storage.getProbabilityFunction().setValue(1,1);
            Storage.getProbabilityFunction().setValue(2,0);
        }
        else if (StorageCapacity >= 626) {
            Storage.getProbabilityFunction().setValue(0,0);
            Storage.getProbabilityFunction().setValue(1,0);
            Storage.getProbabilityFunction().setValue(2,1);
        }
        if (FanAirFlowCapacity <= 22) {
            Fan.getProbabilityFunction().setValue(0,1);
            Fan.getProbabilityFunction().setValue(1,0);
            Fan.getProbabilityFunction().setValue(2,0);
        }
        else if (FanAirFlowCapacity >= 23 && FanAirFlowCapacity <= 42) {
            Fan.getProbabilityFunction().setValue(0,0);
            Fan.getProbabilityFunction().setValue(1,1);
            Fan.getProbabilityFunction().setValue(2,0);
        }
        else if (FanAirFlowCapacity >= 43) {
            Fan.getProbabilityFunction().setValue(0,0);
            Fan.getProbabilityFunction().setValue(1,0);
            Fan.getProbabilityFunction().setValue(2,1);
        }
        if(DisplayResolution.equals("1920 x 1080")) {
            Display.getProbabilityFunction().setValue(0,1);
            Display.getProbabilityFunction().setValue(1,0);
            Display.getProbabilityFunction().setValue(2,0);
        }
        else if(DisplayResolution.equals("2560 x 1440"))
        {
            Display.getProbabilityFunction().setValue(0,0);
            Display.getProbabilityFunction().setValue(1,1);
            Display.getProbabilityFunction().setValue(2,0);
        }
        else if(DisplayResolution.equals("3440 x 1440"))
        {
            Display.getProbabilityFunction().setValue(0,0);
            Display.getProbabilityFunction().setValue(1,0);
            Display.getProbabilityFunction().setValue(2,1);
        }
        if(SpeakersWattPower <= 30) {
            Speakers.getProbabilityFunction().setValue(0,1);
            Speakers.getProbabilityFunction().setValue(1,0);
            Speakers.getProbabilityFunction().setValue(2,0);
        }
        else if(SpeakersWattPower > 30 && SpeakersWattPower <= 60) {
            Speakers.getProbabilityFunction().setValue(0,0);
            Speakers.getProbabilityFunction().setValue(1,1);
            Speakers.getProbabilityFunction().setValue(2,0);
        }
        else if(SpeakersWattPower > 60) {
            Speakers.getProbabilityFunction().setValue(0,0);
            Speakers.getProbabilityFunction().setValue(1,0);
            Speakers.getProbabilityFunction().setValue(2,1);
        }

        Nece_da_se_upali.getProbabilityFunction().setValue(0,0);
        Nece_da_se_upali.getProbabilityFunction().setValue(1,1);
        Upali_se_ali_ne_radi.getProbabilityFunction().setValue(0,0);
        Upali_se_ali_ne_radi.getProbabilityFunction().setValue(1,1);
        Display_se_zamrzne.getProbabilityFunction().setValue(0,0);
        Display_se_zamrzne.getProbabilityFunction().setValue(1,1);
        Nema_dovoljno_memorije.getProbabilityFunction().setValue(0,0);
        Nema_dovoljno_memorije.getProbabilityFunction().setValue(1,1);
        Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan.getProbabilityFunction().setValue(0,0);
        Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan.getProbabilityFunction().setValue(1,1);
        Upali_se_ali_ne_radi.getProbabilityFunction().setValue(0,0);
        Upali_se_ali_ne_radi.getProbabilityFunction().setValue(1,1);
        Blue_screen.getProbabilityFunction().setValue(0,0);
        Blue_screen.getProbabilityFunction().setValue(1,1);
        Slika_je_mutna.getProbabilityFunction().setValue(0,0);
        Slika_je_mutna.getProbabilityFunction().setValue(1, 1);
        Nema_slike.getProbabilityFunction().setValue(0,0);
        Nema_slike.getProbabilityFunction().setValue(1,1);
        Nema_zvuka.getProbabilityFunction().setValue(0,0);
        Nema_zvuka.getProbabilityFunction().setValue(1,1);
        Javljaju_se_sumovi.getProbabilityFunction().setValue(0,0);
        Javljaju_se_sumovi.getProbabilityFunction().setValue(1,1);

        for (String ss: simptomi) {
            switch (ss) {
                case "Nece_da_se_upali":
                    Nece_da_se_upali.getProbabilityFunction().setValue(0, 1);
                    Nece_da_se_upali.getProbabilityFunction().setValue(1, 0);
                    break;
                case "Upali_se_ali_ne_radi":
                    Upali_se_ali_ne_radi.getProbabilityFunction().setValue(0, 1);
                    Upali_se_ali_ne_radi.getProbabilityFunction().setValue(1, 0);
                    break;
                case "Display_se_zamrzne":
                    Display_se_zamrzne.getProbabilityFunction().setValue(0, 1);
                    Display_se_zamrzne.getProbabilityFunction().setValue(1, 0);
                    break;
                case "Nema_dovoljno_memorije":
                    Nema_dovoljno_memorije.getProbabilityFunction().setValue(0, 1);
                    Nema_dovoljno_memorije.getProbabilityFunction().setValue(1, 0);
                    break;
                case "Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan":
                    Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan.getProbabilityFunction().setValue(0, 1);
                    Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan.getProbabilityFunction().setValue(1, 0);
                    break;
                case "Blue_screen":
                    Blue_screen.getProbabilityFunction().setValue(0, 1);
                    Blue_screen.getProbabilityFunction().setValue(1, 0);
                    break;
                case "Slika_je_mutna":
                    Slika_je_mutna.getProbabilityFunction().setValue(0,1);
                    Slika_je_mutna.getProbabilityFunction().setValue(1,0);
                    break;
                case "Nema_slike":
                    Nema_slike.getProbabilityFunction().setValue(0,1);
                    Nema_slike.getProbabilityFunction().setValue(1,0);
                    break;
                case "Nema_zvuka":
                    Nema_zvuka.getProbabilityFunction().setValue(0,1);
                    Nema_zvuka.getProbabilityFunction().setValue(1,0);
                    break;
                case "Javljaju_se_sumovi":
                    Javljaju_se_sumovi.getProbabilityFunction().setValue(0,1);
                    Javljaju_se_sumovi.getProbabilityFunction().setValue(1,0);
                    break;
            }
        }

        IInferenceAlgorithm algorithm = new JunctionTreeAlgorithm();
        algorithm.setNetwork(net);
        algorithm.run();

        try {
            net.updateEvidences();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Float> procenti = new ArrayList<Float>();
        ArrayList<String> respo = new ArrayList<>();
        for (Node node : net.getNodes()) {
            if (node.getName().equals("Motherboard_error")
                    || node.getName().equals("Power_supply_error")
                    || node.getName().equals("RAM_error")
                    || node.getName().equals("Graphics_card_error")
                    || node.getName().equals("Storage_error")
                    || node.getName().equals("Fan_error")
                    || node.getName().equals("Display_error")
                    || node.getName().equals("Speaker_error")) {
                System.out.println(node.getName());
                for (int i = 0; i < node.getStatesSize(); i++) {
                    if (node.getStateAt(i).contains("Da")) {
                        System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode) node).getMarginalAt(i));
                        procenti.add(((ProbabilisticNode) node).getMarginalAt(i)*100);
                    }
                }
            }
            else {
                System.out.println(node.getName());
                for (int i = 0; i < node.getStatesSize(); i++) {
                    System.out.println(node.getStateAt(i) + ": " + ((ProbabilisticNode) node).getMarginalAt(i));
                }
            }
        }
        float ukupno = 0;
        for(Float a: procenti){
            ukupno += a;
        }
        int wa = 0;
        for (Float a: procenti) {
            float novo = a*100/ukupno;
            procenti.set(wa, novo);
            wa = wa + 1;
        }
        int pro = 0;
        for (int i = 0; i < net.getNodes().size(); i++) {
            if (net.getNodes().get(i).getName().equals("Motherboard_error")
                    || net.getNodes().get(i).getName().equals("Power_supply_error")
                    || net.getNodes().get(i).getName().equals("RAM_error")
                    || net.getNodes().get(i).getName().equals("Graphics_card_error")
                    || net.getNodes().get(i).getName().equals("Storage_error")
                    || net.getNodes().get(i).getName().equals("Fan_error")
                    || net.getNodes().get(i).getName().equals("Display_error")
                    || net.getNodes().get(i).getName().equals("Speaker_error")) {
                respo.add(net.getNodes().get(i).getName());
                respo.add(procenti.get(pro) + "%");
                pro = pro + 1;
            }
        }

        return new ResponseEntity<>(respo, HttpStatus.OK);
    }

}
