import { Component, OnInit } from '@angular/core';
import { Camera } from 'src/app/model/camera';
import { Dedicated } from 'src/app/model/dedicated';
import { Display } from 'src/app/model/display';
import { Fan } from 'src/app/model/fan';
import { GetBetterComponent } from 'src/app/model/get-better-component';
import { Headphones } from 'src/app/model/headphones';
import { Integrated } from 'src/app/model/integrated';
import { Joystick } from 'src/app/model/joystick';
import { Keyboard } from 'src/app/model/keyboard';
import { Microphone } from 'src/app/model/microphone';
import { Motherboard } from 'src/app/model/motherboard';
import { Mouse } from 'src/app/model/mouse';
import { Port } from 'src/app/model/port';
import { PowerSupply } from 'src/app/model/power-supply';
import { Processor } from 'src/app/model/processor';
import { RAM } from 'src/app/model/ram';
import { SoundCard } from 'src/app/model/sound-card';
import { Speakers } from 'src/app/model/speakers';
import { AppService } from 'src/app/service/app.service';
import { Storage } from 'src/app/model/storage';

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {
  upgradePressed: Boolean = false;
  estimatePressed: Boolean = false;
  choosePressed: Boolean = false;
  findPressed: Boolean = false;

  constructor(private appService: AppService) { }

  ngOnInit(): void {
  }

  upgradeButtonPressed() {
    this.upgradePressed = true;
    this.estimatePressed = false;
    this.choosePressed = false;
    this.findPressed = false;
  }

  estimateButtonPressed() {
    this.upgradePressed = false;
    this.estimatePressed = true;
    this.choosePressed = false;
    this.findPressed = false;
  }

  chooseButtonPressed() {
    this.upgradePressed = false;
    this.estimatePressed = false;
    this.choosePressed = true;
    this.findPressed = false;
  }

  findButtonPressed() {
    this.upgradePressed = false;
    this.estimatePressed = false;
    this.choosePressed = false;
    this.findPressed = true;
  }

  findComponentsForUpgrade() {
    let component = new GetBetterComponent();

    let processor = document.getElementById('processor:1') as HTMLSelectElement;
    component.processor = Processor[processor.value]
    let camera = document.getElementById('camera:1') as HTMLSelectElement;
    component.camera = Camera[camera.value]
    let display = document.getElementById('display:1') as HTMLSelectElement;
    component.display = Display[display.value]
    let dedicated = document.getElementById('dedicated:1') as HTMLSelectElement;
    component.dedicated = Dedicated[dedicated.value]
    let integrated = document.getElementById('integrated:1') as HTMLSelectElement;
    component.integrated = Integrated[integrated.value]
    let fan = document.getElementById('fan:1') as HTMLSelectElement;
    component.fan = Fan[fan.value]
    let headphones = document.getElementById('headphones:1') as HTMLSelectElement;
    component.headphones = Headphones[headphones.value]
    let joystick = document.getElementById('joystick:1') as HTMLSelectElement;
    component.joystick = Joystick[joystick.value]
    let keyboard = document.getElementById('keyboard:1') as HTMLSelectElement;
    component.keyboard = Keyboard[keyboard.value]
    let mouse = document.getElementById('mouse:1') as HTMLSelectElement;
    component.mouse = Mouse[mouse.value]
    let microphone = document.getElementById('microphone:1') as HTMLSelectElement;
    component.microphone = Microphone[microphone.value]
    let powerSupply = document.getElementById('powerSupply:1') as HTMLSelectElement;
    component.powerSupply = PowerSupply[powerSupply.value]
    let ram = document.getElementById('ram:1') as HTMLSelectElement;
    component.ram = RAM[ram.value]
    let soundCard = document.getElementById('soundCard:1') as HTMLSelectElement;
    component.soundCard = SoundCard[soundCard.value]
    let speakers = document.getElementById('speakers:1') as HTMLSelectElement;
    component.speakers = Speakers[speakers.value]
    let motherboard = document.getElementById('motherboard:1') as HTMLSelectElement;
    component.motherboard = Motherboard[motherboard.value]
    component.storages = [];
    component.ports = [];

    let port1 = document.getElementById('HDMIPort:1') as HTMLInputElement;
    let port2 = document.getElementById('USBPort_2x1:1') as HTMLInputElement;
    let port3 = document.getElementById('HeadphonesPort:1') as HTMLInputElement;
    let port4 = document.getElementById('MicrophonePort:1') as HTMLInputElement;
    let port5 = document.getElementById('USBPort_2x2:1') as HTMLInputElement;
    let port6 = document.getElementById('USBPort_2x3:1') as HTMLInputElement;
    let port7 = document.getElementById('USBPort_32x1:1') as HTMLInputElement;
    let port8 = document.getElementById('USBPort_32x2:1') as HTMLInputElement;
    let port9 = document.getElementById('USBPort_2x4:1') as HTMLInputElement;
    let port10 = document.getElementById('USBPort_2x5:1') as HTMLInputElement;
    let port11 = document.getElementById('USBPort_32x3:1') as HTMLInputElement;
    let port12 = document.getElementById('USBPort_32x4:1') as HTMLInputElement;
    let port13 = document.getElementById('USBPort_2x6:1') as HTMLInputElement;
    let port14 = document.getElementById('USBPort_32x5:1') as HTMLInputElement;
    let port15 = document.getElementById('USBPort_32x6:1') as HTMLInputElement;
    let port16 = document.getElementById('USBPort_32x7:1') as HTMLInputElement;

    if(port1.checked)
      component.ports.push(Port[port1.value])
    if(port2.checked)
      component.ports.push(Port[port2.value])
    if(port3.checked)
      component.ports.push(Port[port3.value])
    if(port4.checked)
      component.ports.push(Port[port4.value])
    if(port5.checked)
      component.ports.push(Port[port5.value])
    if(port6.checked)
      component.ports.push(Port[port6.value])
    if(port7.checked)
      component.ports.push(Port[port7.value])
    if(port8.checked)
      component.ports.push(Port[port8.value])
    if(port9.checked)
      component.ports.push(Port[port9.value])
    if(port10.checked)
      component.ports.push(Port[port10.value])
    if(port11.checked)
      component.ports.push(Port[port11.value])
    if(port12.checked)
      component.ports.push(Port[port12.value])
    if(port13.checked)
      component.ports.push(Port[port13.value])
    if(port14.checked)
      component.ports.push(Port[port14.value])
    if(port15.checked)
      component.ports.push(Port[port15.value])
    if(port16.checked)
      component.ports.push(Port[port16.value])

    let storage1 = document.getElementById('HDD_128GB:1') as HTMLInputElement;
    let storage2 = document.getElementById('HDD_256GB:1') as HTMLInputElement;
    let storage3 = document.getElementById('HDD_512GB:1') as HTMLInputElement;
    let storage4 = document.getElementById('HDD_64GB:1') as HTMLInputElement;
    let storage5 = document.getElementById('SSD_128GB:1') as HTMLInputElement;
    let storage6 = document.getElementById('SSD_64GB:1') as HTMLInputElement;
    let storage7 = document.getElementById('SSD_512GB:1') as HTMLInputElement;
    let storage8 = document.getElementById('SSD_256GB:1') as HTMLInputElement;

    if(storage1.checked)
      component.storages.push(Storage[storage1.value])
    if(storage2.checked)
      component.storages.push(Storage[storage2.value])
    if(storage3.checked)
      component.storages.push(Storage[storage3.value])
    if(storage4.checked)
      component.storages.push(Storage[storage4.value])
    if(storage5.checked)
      component.storages.push(Storage[storage5.value])
    if(storage6.checked)
      component.storages.push(Storage[storage6.value])
    if(storage7.checked)
      component.storages.push(Storage[storage7.value])
    if(storage8.checked)
      component.storages.push(Storage[storage8.value])

    let upgradeComponent = document.getElementById('upgradeComponent') as HTMLSelectElement;
    component.whatToUpgrade = upgradeComponent.value;

    this.appService.getBetterComponent(component).subscribe(ret => {
      alert(ret);
    })
  }
  
  estimateComponents() {
    let component = new GetBetterComponent();

    let processor = document.getElementById('processor:2') as HTMLSelectElement;
    component.processor = Processor[processor.value]
    let camera = document.getElementById('camera:2') as HTMLSelectElement;
    component.camera = Camera[camera.value]
    let display = document.getElementById('display:2') as HTMLSelectElement;
    component.display = Display[display.value]
    let dedicated = document.getElementById('dedicated:2') as HTMLSelectElement;
    component.dedicated = Dedicated[dedicated.value]
    let integrated = document.getElementById('integrated:2') as HTMLSelectElement;
    component.integrated = Integrated[integrated.value]
    let fan = document.getElementById('fan:2') as HTMLSelectElement;
    component.fan = Fan[fan.value]
    let headphones = document.getElementById('headphones:2') as HTMLSelectElement;
    component.headphones = Headphones[headphones.value]
    let joystick = document.getElementById('joystick:2') as HTMLSelectElement;
    component.joystick = Joystick[joystick.value]
    let keyboard = document.getElementById('keyboard:2') as HTMLSelectElement;
    component.keyboard = Keyboard[keyboard.value]
    let mouse = document.getElementById('mouse:2') as HTMLSelectElement;
    component.mouse = Mouse[mouse.value]
    let microphone = document.getElementById('microphone:2') as HTMLSelectElement;
    component.microphone = Microphone[microphone.value]
    let powerSupply = document.getElementById('powerSupply:2') as HTMLSelectElement;
    component.powerSupply = PowerSupply[powerSupply.value]
    let ram = document.getElementById('ram:2') as HTMLSelectElement;
    component.ram = RAM[ram.value]
    let soundCard = document.getElementById('soundCard:2') as HTMLSelectElement;
    component.soundCard = SoundCard[soundCard.value]
    let speakers = document.getElementById('speakers:2') as HTMLSelectElement;
    component.speakers = Speakers[speakers.value]
    let motherboard = document.getElementById('motherboard:2') as HTMLSelectElement;
    component.motherboard = Motherboard[motherboard.value]
    component.storages = [];
    component.ports = [];

    let port1 = document.getElementById('HDMIPort:2') as HTMLInputElement;
    let port2 = document.getElementById('USBPort_2x1:2') as HTMLInputElement;
    let port3 = document.getElementById('HeadphonesPort:2') as HTMLInputElement;
    let port4 = document.getElementById('MicrophonePort:2') as HTMLInputElement;
    let port5 = document.getElementById('USBPort_2x2:2') as HTMLInputElement;
    let port6 = document.getElementById('USBPort_2x3:2') as HTMLInputElement;
    let port7 = document.getElementById('USBPort_32x1:2') as HTMLInputElement;
    let port8 = document.getElementById('USBPort_32x2:2') as HTMLInputElement;
    let port9 = document.getElementById('USBPort_2x4:2') as HTMLInputElement;
    let port10 = document.getElementById('USBPort_2x5:2') as HTMLInputElement;
    let port11 = document.getElementById('USBPort_32x3:2') as HTMLInputElement;
    let port12 = document.getElementById('USBPort_32x4:2') as HTMLInputElement;
    let port13 = document.getElementById('USBPort_2x6:2') as HTMLInputElement;
    let port14 = document.getElementById('USBPort_32x5:2') as HTMLInputElement;
    let port15 = document.getElementById('USBPort_32x6:2') as HTMLInputElement;
    let port16 = document.getElementById('USBPort_32x7:2') as HTMLInputElement;

    if(port1.checked)
      component.ports.push(Port[port1.value])
    if(port2.checked)
      component.ports.push(Port[port2.value])
    if(port3.checked)
      component.ports.push(Port[port3.value])
    if(port4.checked)
      component.ports.push(Port[port4.value])
    if(port5.checked)
      component.ports.push(Port[port5.value])
    if(port6.checked)
      component.ports.push(Port[port6.value])
    if(port7.checked)
      component.ports.push(Port[port7.value])
    if(port8.checked)
      component.ports.push(Port[port8.value])
    if(port9.checked)
      component.ports.push(Port[port9.value])
    if(port10.checked)
      component.ports.push(Port[port10.value])
    if(port11.checked)
      component.ports.push(Port[port11.value])
    if(port12.checked)
      component.ports.push(Port[port12.value])
    if(port13.checked)
      component.ports.push(Port[port13.value])
    if(port14.checked)
      component.ports.push(Port[port14.value])
    if(port15.checked)
      component.ports.push(Port[port15.value])
    if(port16.checked)
      component.ports.push(Port[port16.value])

    let storage1 = document.getElementById('HDD_128GB:2') as HTMLInputElement;
    let storage2 = document.getElementById('HDD_256GB:2') as HTMLInputElement;
    let storage3 = document.getElementById('HDD_512GB:2') as HTMLInputElement;
    let storage4 = document.getElementById('HDD_64GB:2') as HTMLInputElement;
    let storage5 = document.getElementById('SSD_128GB:2') as HTMLInputElement;
    let storage6 = document.getElementById('SSD_64GB:2') as HTMLInputElement;
    let storage7 = document.getElementById('SSD_512GB:2') as HTMLInputElement;
    let storage8 = document.getElementById('SSD_256GB:2') as HTMLInputElement;

    if(storage1.checked)
      component.storages.push(Storage[storage1.value])
    if(storage2.checked)
      component.storages.push(Storage[storage2.value])
    if(storage3.checked)
      component.storages.push(Storage[storage3.value])
    if(storage4.checked)
      component.storages.push(Storage[storage4.value])
    if(storage5.checked)
      component.storages.push(Storage[storage5.value])
    if(storage6.checked)
      component.storages.push(Storage[storage6.value])
    if(storage7.checked)
      component.storages.push(Storage[storage7.value])
    if(storage8.checked)
      component.storages.push(Storage[storage8.value])

    this.appService.getComputerPurpose(component).subscribe(ret => {
      alert(ret);
    })
  }

  findError() {
    let component = new GetBetterComponent();

    let processor = document.getElementById('processor:3') as HTMLSelectElement;
    component.processor = Processor[processor.value]
    let camera = document.getElementById('camera:3') as HTMLSelectElement;
    component.camera = Camera[camera.value]
    let display = document.getElementById('display:3') as HTMLSelectElement;
    component.display = Display[display.value]
    let dedicated = document.getElementById('dedicated:3') as HTMLSelectElement;
    component.dedicated = Dedicated[dedicated.value]
    let integrated = document.getElementById('integrated:3') as HTMLSelectElement;
    component.integrated = Integrated[integrated.value]
    let fan = document.getElementById('fan:3') as HTMLSelectElement;
    component.fan = Fan[fan.value]
    let headphones = document.getElementById('headphones:3') as HTMLSelectElement;
    component.headphones = Headphones[headphones.value]
    let joystick = document.getElementById('joystick:3') as HTMLSelectElement;
    component.joystick = Joystick[joystick.value]
    let keyboard = document.getElementById('keyboard:3') as HTMLSelectElement;
    component.keyboard = Keyboard[keyboard.value]
    let mouse = document.getElementById('mouse:3') as HTMLSelectElement;
    component.mouse = Mouse[mouse.value]
    let microphone = document.getElementById('microphone:3') as HTMLSelectElement;
    component.microphone = Microphone[microphone.value]
    let powerSupply = document.getElementById('powerSupply:3') as HTMLSelectElement;
    component.powerSupply = PowerSupply[powerSupply.value]
    let ram = document.getElementById('ram:3') as HTMLSelectElement;
    component.ram = RAM[ram.value]
    let soundCard = document.getElementById('soundCard:3') as HTMLSelectElement;
    component.soundCard = SoundCard[soundCard.value]
    let speakers = document.getElementById('speakers:3') as HTMLSelectElement;
    component.speakers = Speakers[speakers.value]
    let motherboard = document.getElementById('motherboard:3') as HTMLSelectElement;
    component.motherboard = Motherboard[motherboard.value]
    component.storages = [];
    component.ports = [];

    let port1 = document.getElementById('HDMIPort:3') as HTMLInputElement;
    let port2 = document.getElementById('USBPort_2x1:3') as HTMLInputElement;
    let port3 = document.getElementById('HeadphonesPort:3') as HTMLInputElement;
    let port4 = document.getElementById('MicrophonePort:3') as HTMLInputElement;
    let port5 = document.getElementById('USBPort_2x2:3') as HTMLInputElement;
    let port6 = document.getElementById('USBPort_2x3:3') as HTMLInputElement;
    let port7 = document.getElementById('USBPort_32x1:3') as HTMLInputElement;
    let port8 = document.getElementById('USBPort_32x2:3') as HTMLInputElement;
    let port9 = document.getElementById('USBPort_2x4:3') as HTMLInputElement;
    let port10 = document.getElementById('USBPort_2x5:3') as HTMLInputElement;
    let port11 = document.getElementById('USBPort_32x3:3') as HTMLInputElement;
    let port12 = document.getElementById('USBPort_32x4:3') as HTMLInputElement;
    let port13 = document.getElementById('USBPort_2x6:3') as HTMLInputElement;
    let port14 = document.getElementById('USBPort_32x5:3') as HTMLInputElement;
    let port15 = document.getElementById('USBPort_32x6:3') as HTMLInputElement;
    let port16 = document.getElementById('USBPort_32x7:3') as HTMLInputElement;

    if(port1.checked)
      component.ports.push(Port[port1.value])
    if(port2.checked)
      component.ports.push(Port[port2.value])
    if(port3.checked)
      component.ports.push(Port[port3.value])
    if(port4.checked)
      component.ports.push(Port[port4.value])
    if(port5.checked)
      component.ports.push(Port[port5.value])
    if(port6.checked)
      component.ports.push(Port[port6.value])
    if(port7.checked)
      component.ports.push(Port[port7.value])
    if(port8.checked)
      component.ports.push(Port[port8.value])
    if(port9.checked)
      component.ports.push(Port[port9.value])
    if(port10.checked)
      component.ports.push(Port[port10.value])
    if(port11.checked)
      component.ports.push(Port[port11.value])
    if(port12.checked)
      component.ports.push(Port[port12.value])
    if(port13.checked)
      component.ports.push(Port[port13.value])
    if(port14.checked)
      component.ports.push(Port[port14.value])
    if(port15.checked)
      component.ports.push(Port[port15.value])
    if(port16.checked)
      component.ports.push(Port[port16.value])

    let storage1 = document.getElementById('HDD_128GB:3') as HTMLInputElement;
    let storage2 = document.getElementById('HDD_256GB:3') as HTMLInputElement;
    let storage3 = document.getElementById('HDD_512GB:3') as HTMLInputElement;
    let storage4 = document.getElementById('HDD_64GB:3') as HTMLInputElement;
    let storage5 = document.getElementById('SSD_128GB:3') as HTMLInputElement;
    let storage6 = document.getElementById('SSD_64GB:3') as HTMLInputElement;
    let storage7 = document.getElementById('SSD_512GB:3') as HTMLInputElement;
    let storage8 = document.getElementById('SSD_256GB:3') as HTMLInputElement;

    if(storage1.checked)
      component.storages.push(Storage[storage1.value])
    if(storage2.checked)
      component.storages.push(Storage[storage2.value])
    if(storage3.checked)
      component.storages.push(Storage[storage3.value])
    if(storage4.checked)
      component.storages.push(Storage[storage4.value])
    if(storage5.checked)
      component.storages.push(Storage[storage5.value])
    if(storage6.checked)
      component.storages.push(Storage[storage6.value])
    if(storage7.checked)
      component.storages.push(Storage[storage7.value])
    if(storage8.checked)
      component.storages.push(Storage[storage8.value])

    let Nece_da_se_upali = document.getElementById('Nece_da_se_upali') as HTMLInputElement;
    let Upali_se_ali_ne_radi = document.getElementById('Upali_se_ali_ne_radi') as HTMLInputElement;
    let Display_se_zamrzne = document.getElementById('Display_se_zamrzne') as HTMLInputElement;
    let Nema_dovoljno_memorije = document.getElementById('Nema_dovoljno_memorije') as HTMLInputElement;
    let Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan = document.getElementById('Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan') as HTMLInputElement;
    let Blue_screen = document.getElementById('Blue_screen') as HTMLInputElement;
    let Kompjuter_je_usporen = document.getElementById('Kompjuter_je_usporen') as HTMLInputElement;
    let Kompjuter_se_jako_zagreva = document.getElementById('Kompjuter_se_jako_zagreva') as HTMLInputElement;
    let Kompjuter_se_spontano_gasi = document.getElementById('Kompjuter_se_spontano_gasi') as HTMLInputElement;
    let Operativni_sistem_ne_radi = document.getElementById('Operativni_sistem_ne_radi') as HTMLInputElement;
    let Nema_zvuka = document.getElementById('Nema_zvuka') as HTMLInputElement;
    let Javljaju_se_sumovi = document.getElementById('Javljaju_se_sumovi') as HTMLInputElement;
    let Slika_je_mutna = document.getElementById('Slika_je_mutna') as HTMLInputElement;
    let Nema_slike = document.getElementById('Nema_slike') as HTMLInputElement;
    let Pointer_se_ne_prikazuje = document.getElementById('Pointer_se_ne_prikazuje') as HTMLInputElement;
    let Kamera_prikazuje_crnu_sliku = document.getElementById('Kamera_prikazuje_crnu_sliku') as HTMLInputElement;
    let Na_skype_poziv_ne_mogu_ukljuciti_kameru = document.getElementById('Na_skype_poziv_ne_mogu_ukljuciti_kameru') as HTMLInputElement;
    let Na_skype_poziv_ne_mogu_ukljuciti_mikrofon = document.getElementById('Na_skype_poziv_ne_mogu_ukljuciti_mikrofon') as HTMLInputElement;
    let Pritisak_tastera_F12_ne_radi = document.getElementById('Pritisak_tastera_F12_ne_radi') as HTMLInputElement;
    let Nece_da_otvori_fajl = document.getElementById('Nece_da_otvori_fajl') as HTMLInputElement;
    let Iskacuci_pop_up_prozori = document.getElementById('Iskacuci_pop_up_prozori') as HTMLInputElement;
    let Instalira_mi_se_nezeljena_aplikacija = document.getElementById('Instalira_mi_se_nezeljena_aplikacija') as HTMLInputElement;
  
    let simptomi = "";

    if(Nece_da_se_upali.checked)
      simptomi += Nece_da_se_upali.value + ";";
    if(Upali_se_ali_ne_radi.checked)
      simptomi += Upali_se_ali_ne_radi.value + ";";
    if(Display_se_zamrzne.checked)
      simptomi += Display_se_zamrzne.value + ";";
    if(Nema_dovoljno_memorije.checked)
      simptomi += Nema_dovoljno_memorije.value + ";";
    if(Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan.checked)
      simptomi += Operativni_sistem_ne_postoji_ili_cvrsti_disk_nije_ucitan.value + ";";
    if(Blue_screen.checked)
      simptomi += Blue_screen.value + ";";
    if(Kompjuter_je_usporen.checked)
      simptomi += Kompjuter_je_usporen.value + ";";
    if(Kompjuter_se_jako_zagreva.checked)
      simptomi += Kompjuter_se_jako_zagreva.value + ";";
    if(Kompjuter_se_spontano_gasi.checked)
      simptomi += Kompjuter_se_spontano_gasi.value + ";";
    if(Operativni_sistem_ne_radi.checked)
      simptomi += Operativni_sistem_ne_radi.value + ";";
    if(Nema_zvuka.checked)
      simptomi += Nema_zvuka.value + ";";
    if(Javljaju_se_sumovi.checked)
      simptomi += Javljaju_se_sumovi.value + ";";
    if(Slika_je_mutna.checked)
      simptomi += Slika_je_mutna.value + ";";
    if(Nema_slike.checked)
      simptomi += Nema_slike.value + ";";
    if(Pointer_se_ne_prikazuje.checked)
      simptomi += Pointer_se_ne_prikazuje.value + ";";
    if(Kamera_prikazuje_crnu_sliku.checked)
      simptomi += Kamera_prikazuje_crnu_sliku.value + ";";
    if(Na_skype_poziv_ne_mogu_ukljuciti_kameru.checked)
      simptomi += Na_skype_poziv_ne_mogu_ukljuciti_kameru.value + ";";
    if(Na_skype_poziv_ne_mogu_ukljuciti_mikrofon.checked)
      simptomi += Na_skype_poziv_ne_mogu_ukljuciti_mikrofon.value + ";";
    if(Pritisak_tastera_F12_ne_radi.checked)
      simptomi += Pritisak_tastera_F12_ne_radi.value + ";";
    if(Nece_da_otvori_fajl.checked)
      simptomi += Nece_da_otvori_fajl.value + ";";
    if(Iskacuci_pop_up_prozori.checked)
      simptomi += Iskacuci_pop_up_prozori.value + ";";
    if(Instalira_mi_se_nezeljena_aplikacija.checked)
      simptomi += Instalira_mi_se_nezeljena_aplikacija.value + ";";

    if (simptomi.length > 0) {
      simptomi = simptomi.substring(0, simptomi.length - 1);
    }

    component.whatToUpgrade = simptomi;
    
    this.appService.getComputerError(component).subscribe(ret => {
      alert(ret);
    })
  }

  findComputers() {
    let component = new GetBetterComponent();

    let processor = document.getElementById('processor:4') as HTMLSelectElement;
    component.processor = Processor[processor.value]
    let camera = document.getElementById('camera:4') as HTMLSelectElement;
    component.camera = Camera[camera.value]
    let display = document.getElementById('display:4') as HTMLSelectElement;
    component.display = Display[display.value]
    let dedicated = document.getElementById('dedicated:4') as HTMLSelectElement;
    component.dedicated = Dedicated[dedicated.value]
    let integrated = document.getElementById('integrated:4') as HTMLSelectElement;
    component.integrated = Integrated[integrated.value]
    let fan = document.getElementById('fan:4') as HTMLSelectElement;
    component.fan = Fan[fan.value]
    let headphones = document.getElementById('headphones:4') as HTMLSelectElement;
    component.headphones = Headphones[headphones.value]
    let joystick = document.getElementById('joystick:4') as HTMLSelectElement;
    component.joystick = Joystick[joystick.value]
    let keyboard = document.getElementById('keyboard:4') as HTMLSelectElement;
    component.keyboard = Keyboard[keyboard.value]
    let mouse = document.getElementById('mouse:4') as HTMLSelectElement;
    component.mouse = Mouse[mouse.value]
    let microphone = document.getElementById('microphone:4') as HTMLSelectElement;
    component.microphone = Microphone[microphone.value]
    let powerSupply = document.getElementById('powerSupply:4') as HTMLSelectElement;
    component.powerSupply = PowerSupply[powerSupply.value]
    let ram = document.getElementById('ram:4') as HTMLSelectElement;
    component.ram = RAM[ram.value]
    let soundCard = document.getElementById('soundCard:4') as HTMLSelectElement;
    component.soundCard = SoundCard[soundCard.value]
    let speakers = document.getElementById('speakers:4') as HTMLSelectElement;
    component.speakers = Speakers[speakers.value]
    let motherboard = document.getElementById('motherboard:4') as HTMLSelectElement;
    component.motherboard = Motherboard[motherboard.value]
    component.storages = [];
    component.ports = [];

    let port1 = document.getElementById('HDMIPort:4') as HTMLInputElement;
    let port2 = document.getElementById('USBPort_2x1:4') as HTMLInputElement;
    let port3 = document.getElementById('HeadphonesPort:4') as HTMLInputElement;
    let port4 = document.getElementById('MicrophonePort:4') as HTMLInputElement;
    let port5 = document.getElementById('USBPort_2x2:4') as HTMLInputElement;
    let port6 = document.getElementById('USBPort_2x3:4') as HTMLInputElement;
    let port7 = document.getElementById('USBPort_32x1:4') as HTMLInputElement;
    let port8 = document.getElementById('USBPort_32x2:4') as HTMLInputElement;
    let port9 = document.getElementById('USBPort_2x4:4') as HTMLInputElement;
    let port10 = document.getElementById('USBPort_2x5:4') as HTMLInputElement;
    let port11 = document.getElementById('USBPort_32x3:4') as HTMLInputElement;
    let port12 = document.getElementById('USBPort_32x4:4') as HTMLInputElement;
    let port13 = document.getElementById('USBPort_2x6:4') as HTMLInputElement;
    let port14 = document.getElementById('USBPort_32x5:4') as HTMLInputElement;
    let port15 = document.getElementById('USBPort_32x6:4') as HTMLInputElement;
    let port16 = document.getElementById('USBPort_32x7:4') as HTMLInputElement;

    if(port1.checked)
      component.ports.push(Port[port1.value])
    if(port2.checked)
      component.ports.push(Port[port2.value])
    if(port3.checked)
      component.ports.push(Port[port3.value])
    if(port4.checked)
      component.ports.push(Port[port4.value])
    if(port5.checked)
      component.ports.push(Port[port5.value])
    if(port6.checked)
      component.ports.push(Port[port6.value])
    if(port7.checked)
      component.ports.push(Port[port7.value])
    if(port8.checked)
      component.ports.push(Port[port8.value])
    if(port9.checked)
      component.ports.push(Port[port9.value])
    if(port10.checked)
      component.ports.push(Port[port10.value])
    if(port11.checked)
      component.ports.push(Port[port11.value])
    if(port12.checked)
      component.ports.push(Port[port12.value])
    if(port13.checked)
      component.ports.push(Port[port13.value])
    if(port14.checked)
      component.ports.push(Port[port14.value])
    if(port15.checked)
      component.ports.push(Port[port15.value])
    if(port16.checked)
      component.ports.push(Port[port16.value])

    let storage1 = document.getElementById('HDD_128GB:4') as HTMLInputElement;
    let storage2 = document.getElementById('HDD_256GB:4') as HTMLInputElement;
    let storage3 = document.getElementById('HDD_512GB:4') as HTMLInputElement;
    let storage4 = document.getElementById('HDD_64GB:4') as HTMLInputElement;
    let storage5 = document.getElementById('SSD_128GB:4') as HTMLInputElement;
    let storage6 = document.getElementById('SSD_64GB:4') as HTMLInputElement;
    let storage7 = document.getElementById('SSD_512GB:4') as HTMLInputElement;
    let storage8 = document.getElementById('SSD_256GB:4') as HTMLInputElement;

    if(storage1.checked)
      component.storages.push(Storage[storage1.value])
    if(storage2.checked)
      component.storages.push(Storage[storage2.value])
    if(storage3.checked)
      component.storages.push(Storage[storage3.value])
    if(storage4.checked)
      component.storages.push(Storage[storage4.value])
    if(storage5.checked)
      component.storages.push(Storage[storage5.value])
    if(storage6.checked)
      component.storages.push(Storage[storage6.value])
    if(storage7.checked)
      component.storages.push(Storage[storage7.value])
    if(storage8.checked)
      component.storages.push(Storage[storage8.value])

    this.appService.getSimilarComputers(component).subscribe(ret => {
      alert(ret);
    })
  }
}
