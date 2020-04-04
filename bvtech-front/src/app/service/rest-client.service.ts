import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { TextRequest } from '../model/text-request';
import { TextResponse } from '../model/text-response';
import { Observable } from 'rxjs';
import { ActiveTechnologyService } from './active-technology.service';

@Injectable({
  providedIn: 'root'
})
export class RestClientService {

  // TODO: localhost -> bvtech-jakartaee
  private jakartaEeUrl: string = "http://localhost:8080/betvictor/";

  // TODO: localhost -> bvtech-springboot
  private springBootUrl: string = "http://localhost:8081/betvictor/";

  private activeTechnology: string;

  constructor(private http: HttpClient, private activeTechnologyService: ActiveTechnologyService) {
    this.activeTechnologyService.subscriber.subscribe((activeTechnology: string) => {
      this.activeTechnology = activeTechnology;
    });
  }

  getText(request: TextRequest): Observable<TextResponse> {
    return this.http.get<TextResponse>(this.getTextUrl(request));
  }

  getHistory(): Observable<TextResponse[]> {
    return this.http.get<TextResponse[]>(this.getHistoryUrl());
  }

  setActiveTechnology(activeTechnology: string): void {
    this.activeTechnology = activeTechnology;
  }

  private getTextUrl(request: TextRequest): string {
    return this.getBaseUrl() + this.getTextUrlPath(request);
  }

  private getHistoryUrl(): string {
    return this.getBaseUrl() + "history";
  }

  private getBaseUrl(): string {
    if (this.activeTechnology === "Spring Boot") {
      return this.springBootUrl;
    }
    return this.jakartaEeUrl;
  }

  private getTextUrlPath(request: TextRequest) {
    return "text?"
        + "p_start=" + request.p_start + "&"
        + "p_end=" + request.p_end + "&"
        + "w_count_min=" + request.w_count_min + "&"
        + "w_count_max=" + request.w_count_max;
  }

}
