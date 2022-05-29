package protage.example.protage.controller;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.FunctionBlock;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import protage.example.protage.Jena.Jena;
import protage.example.protage.model.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.text.DecimalFormat;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerForApp {

    private static final DecimalFormat df = new DecimalFormat("0.00");


    @PostMapping("/getBetterComponent")
    public ResponseEntity<ArrayList<String>> getBetterComponent(@RequestBody GetBetterComponent getBetterComponentBody) {

        if(getBetterComponentBody.getWhatToUpgrade().equals("ethernetCard")){        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("wirelessCard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("camera")){
            ArrayList<String> better = makeQuery("isCameraBetterThanThan", getBetterComponentBody.getCamera().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----BETTER CAMERA----");
            result.addAll(better);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("case")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("display")){
            ArrayList<String> preferable = makeQuery("isDisplayMorePreferableThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> bigger = makeQuery("isDisplayBiggerThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> refreshRate = makeQuery("isDisplayRefreshRateMoreThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> resolution = makeQuery("isDisplayResolutionMoreThan", getBetterComponentBody.getDisplay().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----MORE PREFERABLE----");
            result.addAll(preferable);
            result.add("----BIGGER----");
            result.addAll(bigger);
            result.add("----BETTER REFRESH RATE----");
            result.addAll(refreshRate);
            result.add("----BETTER RESOLUTION----");
            result.addAll(resolution);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("fan")){
            ArrayList<String> powerful = makeQuery("isFanMorePowerfulThan", getBetterComponentBody.getFan().toString(), "", "", "", "");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----MORE POWERFUL----");
            result.addAll(powerful);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("dedicated")){
            ArrayList<String> faster = makeQuery("isGraphicsCardFasterThan",getBetterComponentBody.getDedicated().toString(),"isMotherboardAndDedicatedGraphicsCardCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible",getBetterComponentBody.getPowerSupply().toString());
            ArrayList<String> preferable = makeQuery("isGraphicsCardPreferableThan",getBetterComponentBody.getDedicated().toString(),"isMotherboardAndDedicatedGraphicsCardCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible",getBetterComponentBody.getPowerSupply().toString());
            ArrayList<String> memory = makeQuery("isGraphicsCardMemoryMoreThan",getBetterComponentBody.getDedicated().toString(),"isMotherboardAndDedicatedGraphicsCardCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible",getBetterComponentBody.getPowerSupply().toString());
            ArrayList<String> result = new ArrayList<String>();
            result.add("----FASTER----");
            result.addAll(faster);
            result.add("----PREFERABLE----");
            result.addAll(preferable);
            result.add("----MORE MEMORY----");
            result.addAll(memory);

            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("integrated")){
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
            ArrayList<String> result = new ArrayList<String>();
            result.add("----FASTER----");
            result.addAll(faster);
            result.add("----PREFERABLE----");
            result.addAll(preferable);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("headphones")){
            ArrayList<String> comfortable = makeQuery("areHeadphonesMoreComfortableThan", getBetterComponentBody.getHeadphones().toString(),"","","","");
            ArrayList<String> betterFrequencyResponse = makeQuery("hasBetterHeadphonesFrequencyResponseRangeThan", getBetterComponentBody.getHeadphones().toString(),"","","","");
            ArrayList<String> betterNoiseIsolation = makeQuery("hasBetterNoiseIsolationThan", getBetterComponentBody.getHeadphones().toString(),"","","","");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----COMFORTABLE----");
            result.addAll(comfortable);
            result.add("----BETTER FREQUENCY RESPONSE----");
            result.addAll(betterFrequencyResponse);
            result.add("----BETTER NOISE ISOLATION----");
            result.addAll(betterNoiseIsolation);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("keyboard")){
            ArrayList<String> betterKeystroke = makeQuery("hasBetterKeystrokeThan", getBetterComponentBody.getKeyboard().toString(),"","","","");
            ArrayList<String> comfortable = makeQuery("isKeyboardMoreComfortableThan", getBetterComponentBody.getKeyboard().toString(),"","","","");
            ArrayList<String> durable = makeQuery("isKeyboardMoreDurableThan", getBetterComponentBody.getKeyboard().toString(),"","","","");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----BETTER KEYSTROKE----");
            result.addAll(betterKeystroke);
            result.add("----MORE COMFORTABLE----");
            result.addAll(comfortable);
            result.add("----MORE DURABLE----");
            result.addAll(durable);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("microphone")){
            ArrayList<String> silent = makeQuery("isMicrophoneBetterRegistringSilentVoicesThan", getBetterComponentBody.getMicrophone().toString(),"","","","");
            ArrayList<String> differentVolumes = makeQuery("isMicrophoneBetterRegistringDifferentVolumesOfSoundsThan", getBetterComponentBody.getMicrophone().toString(),"","","","");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----BETTER REGISTRING SILENT VOICES----");
            result.addAll(silent);
            result.add("----BETTER REGISTRING DIFFERENT VOLUMES----");
            result.addAll(differentVolumes);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("motherboard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("pointingDevice")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("powerSupply")){
            ArrayList<String> stronger = makeQuery("isPowerSupplyStrongerThan", getBetterComponentBody.getPowerSupply().toString(),"isMotherboardAndPowerSupplyCompatible",getBetterComponentBody.getMotherboard().toString(),"isPowerSupplyAndGraphicsCardCompatible", getBetterComponentBody.getDedicated().toString());
            ArrayList<String> result = new ArrayList<String>();
            result.add("----STRONGER----");
            result.addAll(stronger);

            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("processor")){
            ArrayList<String> faster = makeQuery("isProcessorFasterThan", getBetterComponentBody.getProcessor().toString(), "isMotherboardAndProcessorCompatible", getBetterComponentBody.getMotherboard().toString(), "","");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----FASTER----");
            result.addAll(faster);

            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("port")){
            String queryString = "";
            for(int i = 0;i < getBetterComponentBody.getPorts().size();i++) {
                ArrayList<String> list = makeQuery("isUSBPortMorePreferedThan", getBetterComponentBody.getPorts().get(i).toString(),"","","","");
                if(list.size()!=0){
                    break;
                }
            }
            ArrayList<String> prefered = Jena.execQuery(queryString);
            ArrayList<String> result = new ArrayList<String>();
            result.add("----PREFERRED----");
            result.addAll(prefered);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("ram")){
            ArrayList<String> preferable = makeQuery("isRAMMorePreferableThan", getBetterComponentBody.getRAM().toString(),"isMotherboardAndRAMCompatible", getBetterComponentBody.getMotherboard().toString(), "","");
            ArrayList<String> storage = makeQuery("isRAMStorageMoreThan", getBetterComponentBody.getRAM().toString(),"isMotherboardAndRAMCompatible", getBetterComponentBody.getMotherboard().toString(), "","");
            ArrayList<String> result = new ArrayList<String>();
            result.addAll(preferable);
            result.add("----MORE CAPACITY----");
            result.addAll(storage);

            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("soundCard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("speakers")){
            ArrayList<String> powerful = makeQuery("areSpeakersMorePowerfulThan", getBetterComponentBody.getSpeakers().toString(),"","","","");
            ArrayList<String> result = new ArrayList<String>();
            result.add("----MORE POWERFUL----");
            result.addAll(powerful);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("storage")){
            ArrayList<String> capacity = makeQuery("isStorageCapacityMoreThan", getBetterComponentBody.getStorages().get(0).toString(),"","","","");
            ArrayList<String> preferable = makeQuery("isStorageCapacityPreferableThan", getBetterComponentBody.getStorages().get(0).toString(),"","","","");

            ArrayList<String> result = new ArrayList<String>();
            result.add("----FOR "+getBetterComponentBody.getStorages().get(0)+"----");
            result.add("----MORE CAPACITY----");
            result.addAll(capacity);
            result.add("----MORE PREFERABLE----");
            result.addAll(preferable);
            if(getBetterComponentBody.getStorages().size()>1) {
                ArrayList<String> capacity1 = makeQuery("isStorageCapacityMoreThan", getBetterComponentBody.getStorages().get(1).toString(),"","","","");
                ArrayList<String> preferable1 = makeQuery("isStorageCapacityPreferableThan", getBetterComponentBody.getStorages().get(1).toString(),"","","","");
                result.add("----FOR " + getBetterComponentBody.getStorages().get(1) + "----");
                result.add("----MORE CAPACITY----");
                result.addAll(capacity1);
                result.add("----MORE PREFERABLE----");
                result.addAll(preferable1);
            }
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("multimediaSoftwares")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("presentationSoftware")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("spreadsheetSoftware")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("webBrowser")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("operatingSystem")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("systemSoftware")){}


        return new ResponseEntity<ArrayList<String>>(new ArrayList<String>(), HttpStatus.OK);

    }

    private ArrayList<String> makeQuery(String objectProperty, String component, String compatibleObjectProperty, String compatibleComponent, String compatibleObjectProperty1, String compatibleComponent1){
        if(compatibleObjectProperty == "") {
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                            "SELECT ?x WHERE { ?x kls:" + objectProperty + " ins:" + component + ".}";
            ArrayList<String> better = Jena.execQuery(queryString);
            return better;
        }
        else {
            if(compatibleObjectProperty1 == "") {
                String queryString =
                        "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                                "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                                "SELECT ?x WHERE { ?x kls:" + objectProperty + " ins:" + component + "." +
                                "?x kls:" + compatibleObjectProperty + " ins:" + compatibleComponent + "." + "}";
                ArrayList<String> better = Jena.execQuery(queryString);
                return better;
            }
            else{
                String queryString =
                        "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                                "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                                "SELECT ?x WHERE { ?x kls:" + objectProperty + " ins:" + component + "." +
                                "?x kls:" + compatibleObjectProperty + " ins:" + compatibleComponent + "." +
                                "?x kls:" + compatibleObjectProperty1 + " ins:" + compatibleComponent1 + "." + "}";
                ArrayList<String> better = Jena.execQuery(queryString);
                return better;
            }
        }
    }

    @PostMapping("/getBetterComponentJsonBody")
    public ResponseEntity<GetBetterComponent> getBetterComponentJsonBody() {
        GetBetterComponent body = new GetBetterComponent();
        ArrayList<Adapter> adapters = new ArrayList<Adapter>();
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        ArrayList<MultimediaSoftware> multimediaSoftwares = new ArrayList<MultimediaSoftware>();
        ArrayList<Port> ports = new ArrayList<Port>();
        ArrayList<PresentationSoftware> presentationSoftwares = new ArrayList<PresentationSoftware>();
        ArrayList<SpreadsheetSoftware> spreadsheetSoftwares = new ArrayList<SpreadsheetSoftware>();
        ArrayList<Storage> storages = new ArrayList<Storage>();
        ArrayList<Utility> utilities = new ArrayList<Utility>();
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
        body.setKeyboard(Keyboard.Keyboard_Ergonomic_Logitech_Ergo_K860);
        body.setMicrophone(Microphone.Microphone_Boya_BY_PM300);
        body.setMotherboard(Motherboard.Motherboard_B365M);
        body.setMultimediaSoftwares(multimediaSoftwares);
        body.setOperatingSystem(OperatingSystem.OperatingSystem_Windows_10_Pro);
        body.setPointingDevice(PointingDevice.Mouse_Pro_X);
        body.setPorts(ports);
        body.setPowerSupply(PowerSupply.PowerSupply_HU180);
        body.setPresentationSoftwares(presentationSoftwares);
        body.setProcessor(Processor.Processor_i5_6400);
        body.setProgramTranslator(ProgramTranslator.ProgramTranslator_Asembler);
        body.setRAM(RAM.DDR3_64GB);
        body.setSoundCard(null);
        body.setSpeakers(Speakers.Speakers_Tytan21);
        body.setSpreadsheetSoftwares(spreadsheetSoftwares);
        body.setStorages(storages);
        body.setUtilities(utilities);


        return new ResponseEntity<GetBetterComponent>(body, HttpStatus.OK);

    }

    private String getComponentDataTypes(String component, String what){
        String queryString =
                "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                        "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                        "SELECT ?param WHERE { ?x kls:Name \""+component+"\"^^<http://www.w3.org/2001/XMLSchema#string>." +
                        "?x kls:"+what+" ?param .}" +
                        "LIMIT 1";
        String com = Jena.execQuery2(queryString, "param");
        return com;
    }

    @PostMapping("/getComputerPurpose")
    public ResponseEntity<ArrayList<String>> getComputerPurpose(@RequestBody GetBetterComponent getBetterComponentBody){
        int RAMCapacity = 0;
        int StorageCapacity = 0;
        int GraphicsCardSpeed = 0;
        int PowerSupplyWattPower = 0;
        int FanAirFlowCapacity = 0;
        int SpeakersWattPower = 0;
        int Price = 0;
        if(getBetterComponentBody.getRAM() != null){
             RAMCapacity = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getRAM().toString(),"RAMCapacityString").split("G")[0]);
             Price += Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getRAM().toString(),"Price"));
        }
        if(getBetterComponentBody.getDedicated() == null){
            if(getBetterComponentBody.getIntegrated() != null){
                GraphicsCardSpeed = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getIntegrated().toString(),"GraphicsCardSpeedString").split("M")[0]);
                Price += 0;
            }
        }
        else if(getBetterComponentBody.getDedicated() != null){
            GraphicsCardSpeed = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getDedicated().toString(),"GraphicsCardSpeedString").split("M")[0]);
            Price += Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getDedicated().toString(),"Price"));
        }
        if(getBetterComponentBody.getStorages() != null){
            for(Storage s: getBetterComponentBody.getStorages()) {
                StorageCapacity  += Integer.parseInt(getComponentDataTypes(s.toString(), "StorageCapacityString").split("G")[0]);
                Price += Integer.parseInt(getComponentDataTypes(s.toString(), "Price"));
            }
        }
        if(getBetterComponentBody.getPowerSupply() != null){
            PowerSupplyWattPower = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getPowerSupply().toString(),"PowerSupplyWattPower"));
            Price += Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getPowerSupply().toString(),"Price"));
        }
        if(getBetterComponentBody.getFan() != null){
            FanAirFlowCapacity = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getFan().toString(),"FanAirFlowCapacityString").split("C")[0]);
            Price += Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getFan().toString(),"Price"));
        }
        if(getBetterComponentBody.getSpeakers() != null){
            SpeakersWattPower = Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getSpeakers().toString(),"SpeakersWattPower"));
            Price += Integer.parseInt(getComponentDataTypes(getBetterComponentBody.getSpeakers().toString(),"Price"));
        }

        FIS fis = FIS.load("fl.fcl", true);

        if (fis == null) {
            System.err.println("Can't load file");
            System.exit(1);
        }
        FunctionBlock fb = fis.getFunctionBlock("sablon");
        JFuzzyChart.get().chart(fb);

        if(RAMCapacity!=0){
            fis.setVariable("RAMCapacity", RAMCapacity);
        }
        if(StorageCapacity!=0){
            fis.setVariable("StorageCapacity", StorageCapacity);
        }
        else{
            fis.setVariable("StorageCapacity", 1);
        }
        if(GraphicsCardSpeed!=0){
            fis.setVariable("GraphicsCardSpeed", GraphicsCardSpeed);
        }
        else{
            fis.setVariable("GraphicsCardSpeed", 50);
        }
        if(PowerSupplyWattPower!=0){
            fis.setVariable("PowerSupplyWattPower", PowerSupplyWattPower);
        }
        else{
            fis.setVariable("PowerSupplyWattPower", 50);
        }
        if(FanAirFlowCapacity!=0){
            fis.setVariable("FanAirFlowCapacity", FanAirFlowCapacity);
        }
        else{
            fis.setVariable("FanAirFlowCapacity", 6);
        }
        if(SpeakersWattPower!=0){
            fis.setVariable("SpeakersWattPower", SpeakersWattPower);
        }
        else{
            fis.setVariable("SpeakersWattPower", 1);
        }
        if(Price!=0){
            fis.setVariable("Price", Price);
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
        System.out.println("Home: "+ Home.getValue()/100);
        System.out.println("Work: "+ Work.getValue()/100);
        System.out.println("Gaming: "+ Gaming.getValue()/100);
        System.out.println("Hosting: "+ Hosting.getValue()/100);
        System.out.println("Mining: "+ Mining.getValue()/100);

        ArrayList<String> respo = new ArrayList<String>();
        respo.add("Home: "+ df.format(Home.getValue()/100));
        respo.add("Work: "+ df.format(Work.getValue()/100));
        respo.add("Gaming: "+ df.format(Gaming.getValue()/100));
        respo.add("Hosting: "+ df.format(Hosting.getValue()/100));
        respo.add("Mining: "+ df.format(Mining.getValue()/100));

        return new ResponseEntity<ArrayList<String>>(respo,HttpStatus.OK);
    }
}
