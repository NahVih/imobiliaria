import { BrowserModule } from '@angular/platform-browser';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { NavBarComponent } from './nav-bar/nav-bar.component';
import { LoginComponent } from './seguranca/login/login/login.component';
import { ImoveisModule} from './imovel/imoveis.module';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';

import { JwtClientService } from './seguranca/jwt-client.service';
import { AuthGuard } from './seguranca/guard/auth.guard';
import { from } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    LoginComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ImoveisModule,
    ReactiveFormsModule,
    FormsModule,
     
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
