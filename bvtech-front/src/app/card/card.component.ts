import { Component, OnInit, Input } from '@angular/core';
import { ActiveTechnologyService } from '../service/active-technology.service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  technology: string;

  @Input()
  port: number;

  @Input()
  pro: string;

  @Input()
  contra: string;

  @Input()
  img: string;

  @Input()
  active: boolean;

  constructor(private activeTechnologyService: ActiveTechnologyService) { }

  ngOnInit() {
    this.active = this.technology === this.activeTechnologyService.getActiveTechnology();
    this.activeTechnologyService.subscriber.subscribe((activeTechnology: string) => {
      this.active = activeTechnology === this.technology;
    });
  }

}
