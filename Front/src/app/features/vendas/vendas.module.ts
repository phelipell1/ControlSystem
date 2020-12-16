import { VendasComponent } from './vendas.component';
import { CardModule } from 'primeng/card';
import { VendasRoutingModule } from './vendas.routing';
import { AppCommonModule } from './../../app.common.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StepsModule } from 'primeng/steps';
import { ToolbarModule } from 'primeng/toolbar';
import { FieldsetModule } from 'primeng/fieldset';
import { InputMaskModule } from 'primeng/inputmask';
import { PasswordModule } from 'primeng/password';



@NgModule({
  declarations: [ VendasComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    VendasRoutingModule,
    StepsModule,
    ToolbarModule,
    FieldsetModule,
    InputMaskModule,
    PasswordModule,
    ToolbarModule,
    CardModule
  ]
})
export class VendasModule { }
