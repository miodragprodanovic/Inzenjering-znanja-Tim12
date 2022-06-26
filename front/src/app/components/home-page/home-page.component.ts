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
import { Mouse } from 'src/app/model/mouse';
import { Port } from 'src/app/model/port';
import { PowerSupply } from 'src/app/model/power-supply';
import { Processor } from 'src/app/model/processor';
import { RAM } from 'src/app/model/ram';
import { SoundCard } from 'src/app/model/sound-card';
import { Speakers } from 'src/app/model/speakers';
import { AppService } from 'src/app/service/app.service';

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

    })
  }
  
  estimateComponents() {
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

    this.appService.getComputerPurpose(component).subscribe(ret => {

    })
  }

  findError() {
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

    this.appService.getComputerError(component).subscribe(ret => {

    })
  }
}
