package protage.example.protage.controller;

import jdk.javadoc.internal.doclets.formats.html.markup.Head;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import protage.example.protage.Jena.Jena;
import protage.example.protage.model.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerForApp {
    @PostMapping("/getBetterComponent")
    public ResponseEntity<ArrayList<String>> getBetterComponent(@RequestBody GetBetterComponent getBetterComponentBody) {

        if(getBetterComponentBody.getWhatToUpgrade().equals("ethernetCard")){        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("wirelessCard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("camera")){
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isCameraBetterThanThan ins:"+getBetterComponentBody.getCamera()+".}";
            ArrayList<String> better = Jena.execQuery(queryString);
            ArrayList<String> result = new ArrayList<String>();
            result.add("----BETTER CAMERA----");
            result.addAll(better);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("case")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("display")){
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isDisplayMorePreferableThan ins:"+getBetterComponentBody.getDisplay()+".}";
            ArrayList<String> preferable = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isDisplayBiggerThan ins:"+getBetterComponentBody.getDisplay()+".}";
            ArrayList<String> bigger = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isDisplayRefreshRateMoreThan ins:"+getBetterComponentBody.getDisplay()+".}";
            ArrayList<String> refreshRate = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isDisplayResolutionMoreThan ins:"+getBetterComponentBody.getDisplay()+".}";
            ArrayList<String> resolution = Jena.execQuery(queryString);
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
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isFanMorePowerfulThan ins:"+getBetterComponentBody.getFan()+".}";
            ArrayList<String> powerful = Jena.execQuery(queryString);
            ArrayList<String> result = new ArrayList<String>();
            result.add("----MORE POWERFUL----");
            result.addAll(powerful);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("dedicated")){
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isMotherboardAndDedicatedGraphicsCardCompatible ins:"+getBetterComponentBody.getMotherboard()+".}";
            ArrayList<String> compatible = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isPowerSupplyAndGraphicsCardCompatible ins:"+getBetterComponentBody.getPowerSupply()+".}";
            ArrayList<String> compatiblePowerSupply = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isGraphicsCardFasterThan ins:"+getBetterComponentBody.getDedicated()+".}";
            ArrayList<String> faster = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isGraphicsCardPreferableThan ins:"+getBetterComponentBody.getDedicated()+".}";
            ArrayList<String> preferable = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isGraphicsCardMemoryMoreThan ins:"+getBetterComponentBody.getDedicated()+".}";
            ArrayList<String> memory = Jena.execQuery(queryString);
            ArrayList<String> result = new ArrayList<String>();
            result.add("----FASTER----");

            for (String s: faster){
                for (String ss: compatible){
                    if(s.equals(ss)){
                        for(String sss: compatiblePowerSupply){
                            if(s.equals(sss)){
                                result.add(s);
                            }
                        }
                    }
                }
            }
            result.add("----PREFERABLE----");
            for (String s: preferable){
                for (String ss: compatible){
                    if(s.equals(ss)){
                        for(String sss: compatiblePowerSupply){
                            if(s.equals(sss)){
                                result.add(s);
                            }
                        }
                    }
                }
            }
            result.add("----MORE MEMORY----");
            for (String s: memory){
                for (String ss: compatible){
                    if(s.equals(ss)){
                        for(String sss: compatiblePowerSupply){
                            if(s.equals(sss)){
                                result.add(s);
                            }
                        }
                    }
                }
            }

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
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:areHeadphonesMoreComfortableThan ins:"+getBetterComponentBody.getHeadphones()+".}";
            ArrayList<String> comfortable = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:hasBetterHeadphonesFrequencyResponseRangeThan ins:"+getBetterComponentBody.getHeadphones()+".}";
            ArrayList<String> betterFrequencyResponse = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:hasBetterNoiseIsolationThan ins:"+getBetterComponentBody.getHeadphones()+".}";
            ArrayList<String> betterNoiseIsolation = Jena.execQuery(queryString);
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
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:hasBetterKeystrokeThan ins:"+getBetterComponentBody.getKeyboard()+".}";
            ArrayList<String> betterKeystroke = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isKeyboardMoreComfortableThan ins:"+getBetterComponentBody.getKeyboard()+".}";
            ArrayList<String> comfortable = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isKeyboardMoreDurableThan ins:"+getBetterComponentBody.getKeyboard()+".}";
            ArrayList<String> durable = Jena.execQuery(queryString);
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
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isMicrophoneBetterRegistringSilentVoicesThan ins:"+getBetterComponentBody.getMicrophone()+".}";
            ArrayList<String> silent = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isMicrophoneBetterRegistringDifferentVolumesOfSoundsThan ins:"+getBetterComponentBody.getMicrophone()+".}";
            ArrayList<String> differentVolumes = Jena.execQuery(queryString);

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
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isPowerSupplyStrongerThan ins:"+getBetterComponentBody.getPowerSupply()+".}";
            ArrayList<String> stronger = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isMotherboardAndPowerSupplyCompatible ins:"+getBetterComponentBody.getMotherboard()+".}";
            ArrayList<String> compatibleMotherboard = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isPowerSupplyAndGraphicsCardCompatible ins:"+getBetterComponentBody.getDedicated()+".}";
            ArrayList<String> compatibleGraphicsCard = Jena.execQuery(queryString);

            ArrayList<String> result = new ArrayList<String>();
            result.add("----STRONGER----");

            for(String s: stronger){
                for(String ss: compatibleMotherboard){
                    if(s.equals(ss)){
                        if(getBetterComponentBody.getDedicated()!=null){
                            for(String sss: compatibleGraphicsCard){
                                if(s.equals(sss)){
                                    result.add(s);
                                }
                            }
                        }
                        else{
                            result.add(s);
                        }
                    }
                }
            }

            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("processor")){
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isProcessorFasterThan ins:"+getBetterComponentBody.getProcessor()+".}";
            ArrayList<String> faster = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isMotherboardAndProcessorCompatible ins:"+getBetterComponentBody.getMotherboard()+".}";
            ArrayList<String> compatibleMotherboard = Jena.execQuery(queryString);

            ArrayList<String> result = new ArrayList<String>();
            result.add("----FASTER----");

            for (String s: faster){
                for (String ss: compatibleMotherboard){
                    if(s.equals(ss)){
                        result.add(s);
                    }
                }
            }

            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("port")){
            String queryString = "";
            for(int i = 0;i < getBetterComponentBody.getPorts().size();i++) {
                queryString =
                        "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                                "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                                "SELECT ?x WHERE { ?x kls:isUSBPortMorePreferedThan ins:" + getBetterComponentBody.getPorts().get(i) + ".}";
                ArrayList<String> list = Jena.execQuery(queryString);
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
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isRAMMorePreferableThan ins:"+getBetterComponentBody.getRAM()+".}";
            ArrayList<String> preferable = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isRAMStorageMoreThan ins:"+getBetterComponentBody.getRAM()+".}";
            ArrayList<String> storage = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isMotherboardAndRAMCompatible ins:"+getBetterComponentBody.getMotherboard()+".}";
            ArrayList<String> compatibleMotherboard = Jena.execQuery(queryString);

            ArrayList<String> result = new ArrayList<String>();
            result.add("----PREFERABLE----");

            for (String s: preferable){
                for (String ss: compatibleMotherboard){
                    if(s.equals(ss)){
                        result.add(s);
                    }
                }
            }

            result.add("----MORE CAPACITY----");

            for (String s: storage){
                for (String ss: compatibleMotherboard){
                    if(s.equals(ss)){
                        result.add(s);
                    }
                }
            }

            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("soundCard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("speakers")){
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:areSpeakersMorePowerfulThan ins:"+getBetterComponentBody.getSpeakers()+".}";
            ArrayList<String> powerful = Jena.execQuery(queryString);
            ArrayList<String> result = new ArrayList<String>();
            result.add("----MORE POWERFUL----");
            result.addAll(powerful);
            return new ResponseEntity<ArrayList<String>>(result, HttpStatus.OK);
        }
        else if(getBetterComponentBody.getWhatToUpgrade().equals("storage")){
            String queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isStorageCapacityMoreThan ins:"+getBetterComponentBody.getStorages().get(0)+".}";
            ArrayList<String> capacity = Jena.execQuery(queryString);
            queryString =
                    "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>"+
                            "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>"+
                            "SELECT ?x WHERE { ?x kls:isStorageCapacityPreferableThan ins:"+getBetterComponentBody.getStorages().get(0)+".}";
            ArrayList<String> preferable = Jena.execQuery(queryString);

            ArrayList<String> result = new ArrayList<String>();
            result.add("----FOR "+getBetterComponentBody.getStorages().get(0)+"----");
            result.add("----MORE CAPACITY----");
            result.addAll(capacity);
            result.add("----MORE PREFERABLE----");
            result.addAll(preferable);
            if(getBetterComponentBody.getStorages().size()>1) {
                queryString =
                        "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                                "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                                "SELECT ?x WHERE { ?x kls:isStorageCapacityMoreThan ins:" + getBetterComponentBody.getStorages().get(1) + ".}";
                ArrayList<String> capacity1 = Jena.execQuery(queryString);
                queryString =
                        "PREFIX ins:<http://www.semanticweb.org/IZ/2022/Tim12/Instance#>" +
                                "PREFIX kls:<http://www.semanticweb.org/IZ/2022/Tim12/Klase#>" +
                                "SELECT ?x WHERE { ?x kls:isStorageCapacityPreferableThan ins:" + getBetterComponentBody.getStorages().get(1) + ".}";
                ArrayList<String> preferable1 = Jena.execQuery(queryString);
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
        ArrayList<Camera> cameras = new ArrayList<Camera>();
        ArrayList<Headphones> headphones = new ArrayList<Headphones>();
        ArrayList<Keyboard> keyboards = new ArrayList<Keyboard>();
        ArrayList<Microphone> microphones = new ArrayList<Microphone>();

        adapters.add(Adapter.WiFi_BluetoothCard_AX210);
        adapters.add(Adapter.EthernetCard_BCM5719_4P);
        ports.add(Port.USBPort_2x2);
        ports.add(Port.HDMIPort);
        ports.add(Port.HeadphonesPort);
        ports.add(Port.MicrophonePort);
        storages.add(Storage.HDD_256GB);
        storages.add(Storage.SSD_256GB);
        utilities.add(Utility.CCleaner);
        utilities.add(Utility.WinZip);
        cameras.add(Camera.Camera_Logitech_C505e);
        cameras.add(Camera.Camera_Logitech_Rally_Plus);
        cameras.add(Camera.Camera_Natec_Lori_Plus_NKI_1672);
        cameras.add(Camera.Camera_Trust_SpotLight_Pro);
        cameras.add(Camera.Camera_Kiyo_RZ19);
        cameras.add(Camera.Camera_Trust_Iris_4k);
        headphones.add(Headphones.Headphones_On_Ear_AKG_Y400);
        headphones.add(Headphones.Headphones_On_Ear_Audio_Technica_ATH_M60x);
        headphones.add(Headphones.Headphones_Closed_Back_AKG_N700NC_M2);
        headphones.add(Headphones.Headphones_Closed_Back_Beyerdynamic_DT_770_PRO);
        headphones.add(Headphones.Headphones_Closed_Bose_QuietComfort_35);
        headphones.add(Headphones.Headphones_On_Ear_JBL_Live_460NC_Wireless);
        headphones.add(Headphones.Headphones_Open_Back_Astro_A40_TR);
        headphones.add(Headphones.Headphones_Open_Back_Philips_Fidelio_X2HR);
        headphones.add(Headphones.Headphones_Open_Back_Sennheiser_HD_800_S);
        headphones.add(Headphones.Headphones_Over_Ear_Anker_Soundcore_Life_Q30_Wireless);
        headphones.add(Headphones.Headphones_Over_Ear_HiFiMan_Edition_XS);
        headphones.add(Headphones.Headphones_Over_Ear_Sony_WH_1000XM4);
        keyboards.add(Keyboard.Keyboard_Ergonomic_Logitech_Ergo_K860);
        keyboards.add(Keyboard.Keyboard_Ergonomic_Kinesis_Freestyle_Edge_RGB);
        keyboards.add(Keyboard.Keyboard_Flexible_Sungwoo_Black);
        keyboards.add(Keyboard.Keyboard_Gaming_Corsair_K100_RGB);
        keyboards.add(Keyboard.Keyboard_Flexible_Fly_Way);
        keyboards.add(Keyboard.Keyboard_Gaming_EVGA_Z12);
        keyboards.add(Keyboard.Keyboard_Mechanical_Ducky_Shine_7_Gunmetal_RGB_LED_Double_Shot_PBT);
        keyboards.add(Keyboard.Keyboard_Mechanical_SteelSeries_Apex_Pro);
        keyboards.add(Keyboard.Keyboard_Membrane_Logitech_G213);
        keyboards.add(Keyboard.Keyboard_Membrane_Razer_Cynosa_v2);
        microphones.add(Microphone.Microphone_Boya_BY_PM300);
        microphones.add(Microphone.Microphone_Boya_BY_WM6S);
        microphones.add(Microphone.Microphone_TRUST_GXT_239);
        microphones.add(Microphone.Microphone_Razer_Seiren_Elite_RZ19);
        microphones.add(Microphone.Microphone_Razer_Seiren_Emote_RZ19);
        microphones.add(Microphone.Microphone_TRUST_STARZZ_21671);

        body.setAdapters(adapters);
        body.setCameras(cameras);
        body.setCase(Case.Case_3040);
        body.setDisplay(Display.Display_Sceptre);
        body.setDrivers(drivers);
        body.setFan(Fan.Fan_CP3);
        body.setDedicated(Dedicated.GraphicsCard_NVIDIA_GeForce_GTX_950);
        body.setIntegrated(Integrated.GraphicsCard_Intel_HD_Graphics_530);
        body.setHeadphones(headphones);
        body.setKeyboard(keyboards);
        body.setMicrophone(microphones);
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
}
