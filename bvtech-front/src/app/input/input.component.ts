import { Component, OnInit } from '@angular/core';
import { RestClientService } from '../service/rest-client.service';
import { TextRequest } from '../model/text-request';
import { RefreshService } from '../service/refresh.service';
import { Observable } from 'rxjs';
import { TextResponse } from '../model/text-response';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css']
})
export class InputComponent implements OnInit {

  private response: TextResponse;

  private isLoading: boolean = false;

  private textRequest: TextRequest = {
    p_start: undefined,
    p_end: undefined,
    w_count_min: undefined,
    w_count_max: undefined
  };

  constructor(private restClient: RestClientService, private refreshService: RefreshService) { }

  ngOnInit() {
  }

  send(): void {
    this.response = undefined;
    this.isLoading = true;
    this.restClient.getText(this.textRequest).subscribe((response: TextResponse) => {
      this.response = response;
      this.isLoading = false;
      this.refreshService.refresh();
    });
  }

}
