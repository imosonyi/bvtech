import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { RestClientService } from './rest-client.service';
import { TextResponse } from '../model/text-response';

@Injectable({
  providedIn: 'root'
})
export class RefreshService {

  private observer = new Subject();

  public subscriber = this.observer.asObservable();

  constructor(private restClient: RestClientService) { }

  refresh() {
    this.observer.next(this.restClient.getHistory());
  }

}
