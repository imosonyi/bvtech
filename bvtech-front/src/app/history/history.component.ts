import { Component, OnInit } from '@angular/core';
import { RestClientService } from '../service/rest-client.service';
import { Observable } from 'rxjs';
import { TextResponse } from '../model/text-response';
import { RefreshService } from '../service/refresh.service';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

  private historyList: Observable<TextResponse[]> = this.restClient.getHistory();
  
  constructor(private restClient: RestClientService, private refreshService: RefreshService) { }

  ngOnInit() {
    this.refreshService.subscriber.subscribe((historyList: Observable<TextResponse[]>) => {
      this.historyList = historyList;
    });
  }

}
