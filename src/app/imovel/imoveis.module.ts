import { CommonModule } from '@angular/common';
import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from "@angular/core";
import { HttpClientModule } from '@angular/common/http';

import { ImovelCreateComponent } from './imovel-create/imovel-create.component'
import {ImovelListComponent} from './imovel-list/imovel-list.component'
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ImovelService} from './imovel.service'


@NgModule({
    imports : [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        HttpClientModule
        
  
         
    ],
    schemas: [ CUSTOM_ELEMENTS_SCHEMA],
    declarations: [
        ImovelCreateComponent,
        ImovelListComponent        
    ],

    exports : [
        ImovelCreateComponent,
        ImovelListComponent
    ],
    
    
})
export class ImoveisModule {}