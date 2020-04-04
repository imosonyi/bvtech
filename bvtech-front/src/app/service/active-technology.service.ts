import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ActiveTechnologyService {

  private observer = new Subject();

  public subscriber = this.observer.asObservable();

  private technologies: string[] = ["Jakarta EE", "Spring Boot"];

  private activeTechnology: number = 0;

  constructor() { }

  toggle(): void {
    this.activeTechnology = ++this.activeTechnology % 2;
    this.observer.next(this.getActiveTechnology());
  }

  getActiveTechnology(): string {
    return this.technologies[this.activeTechnology];
  }

}
