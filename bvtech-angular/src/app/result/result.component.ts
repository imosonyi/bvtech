import { Component, OnInit, Input } from '@angular/core';
import { TextResponse } from '../model/text-response';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {

  @Input()
  private response: TextResponse;

  @Input()
  private isLoading: boolean;

  constructor() { }

  ngOnInit() {
  }

}
