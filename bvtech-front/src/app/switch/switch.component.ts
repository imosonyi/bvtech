import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { RefreshService } from '../service/refresh.service';
import { ActiveTechnologyService } from '../service/active-technology.service';

@Component({
  selector: 'app-switch',
  templateUrl: './switch.component.html',
  styleUrls: ['./switch.component.css']
})
export class SwitchComponent implements OnInit {

  constructor(private refreshService: RefreshService, private activeTechnologyService: ActiveTechnologyService) { }

  ngOnInit() {
  }

  toggle(): void {
    this.activeTechnologyService.toggle();
  }

  refresh(): void {
    this.refreshService.refresh();
  }

}
