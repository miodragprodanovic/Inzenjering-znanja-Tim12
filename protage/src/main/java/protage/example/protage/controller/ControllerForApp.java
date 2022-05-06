package protage.example.protage.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import protage.example.protage.model.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ControllerForApp {
    @PostMapping("/getBetterComponent")
    public ResponseEntity<GetBetterComponent> getBetterComponent(@RequestBody GetBetterComponent getBetterComponentBody) {

        if(getBetterComponentBody.getWhatToUpgrade().equals("ethernetCard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("wirelessCard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("camera")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("case")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("display")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("fan")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("dedicated")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("integrated")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("headphones")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("keyboard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("microphone")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("motherboard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("pointingDevice")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("powerSupply")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("processor")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("ram")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("soundCard")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("speakers")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("storage")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("multimediaSoftwares")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("presentationSoftware")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("spreadsheetSoftware")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("webBrowser")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("operatingSystem")){}
        else if(getBetterComponentBody.getWhatToUpgrade().equals("systemSoftware")){}


        return new ResponseEntity<GetBetterComponent>(new GetBetterComponent(), HttpStatus.OK);

    }

    @PostMapping("/getBetterComponentJsonBody")
    public ResponseEntity<GetBetterComponent> getBetterComponentJsonBody() {
        GetBetterComponent body = new GetBetterComponent();
        ArrayList<Adapter> adapters = new ArrayList<Adapter>();
        ArrayList<Driver> drivers = new ArrayList<Driver>();
        ArrayList<GraphicsCard> graphicsCards = new ArrayList<GraphicsCard>();
        ArrayList<MultimediaSoftware> multimediaSoftwares = new ArrayList<MultimediaSoftware>();
        ArrayList<Port> ports = new ArrayList<Port>();
        ArrayList<PresentationSoftware> presentationSoftwares = new ArrayList<PresentationSoftware>();
        ArrayList<SpreadsheetSoftware> spreadsheetSoftwares = new ArrayList<SpreadsheetSoftware>();
        ArrayList<Storage> storages = new ArrayList<Storage>();
        ArrayList<Utility> utilities = new ArrayList<Utility>();
        adapters.add(Adapter.WiFi_BluetoothCard_AX210);
        adapters.add(Adapter.EthernetCard_BCM5719_4P);
        graphicsCards.add(GraphicsCard.GraphicsCard_Intel_UHD_Graphics_630);
        graphicsCards.add(GraphicsCard.GraphicsCard_NVIDIA_GeForce_GTX_950);
        ports.add(Port.USBPort_2x2);
        ports.add(Port.HDMIPort);
        ports.add(Port.HeadphonesPort);
        ports.add(Port.MicrophonePort);
        storages.add(Storage.HDD_256GB);
        storages.add(Storage.SSD_256GB);
        utilities.add(Utility.CCleaner);
        utilities.add(Utility.WinZip);

        body.setAdapters(adapters);
        body.setCamera(Camera.Camera_Logitech_C505e);
        body.setCase(Case.Case_3040);
        body.setDisplay(Display.Display_AW3423DW);
        body.setDrivers(drivers);
        body.setFan(Fan.Fan_CP3);
        body.setGraphicsCards(graphicsCards);
        body.setHeadphones(Headphones.Headphones_On_Ear_AKG_Y400);
        body.setKeyboard(Keyboard.Keyboard_Ergonomic_Logitech_Ergo_K860);
        body.setMicrophone(null);
        body.setMotherboard(Motherboard.Motherboard_B365M);
        body.setMultimediaSoftwares(multimediaSoftwares);
        body.setOperatingSystem(OperatingSystem.OperatingSystem_Windows_10_Pro);
        body.setPointingDevice(PointingDevice.Mouse_Pro_X);
        body.setPorts(ports);
        body.setPowerSupply(PowerSupply.PowerSupply_HU180);
        body.setPresentationSoftwares(presentationSoftwares);
        body.setProcessor(Processor.Processor_i7_8700);
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
