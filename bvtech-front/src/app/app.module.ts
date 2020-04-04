import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardComponent } from './card/card.component';
import { SwitchComponent } from './switch/switch.component';
import { TechnologySelectorComponent } from './technology-selector/technology-selector.component';
import { InputComponent } from './input/input.component';
import { HistoryComponent } from './history/history.component';
import { FooterComponent } from './footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
import { ResultComponent } from './result/result.component';
import { LoadingComponent } from './loading/loading.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    SwitchComponent,
    TechnologySelectorComponent,
    InputComponent,
    HistoryComponent,
    FooterComponent,
    ResultComponent,
    LoadingComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
