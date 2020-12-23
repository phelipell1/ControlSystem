import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AtividadeComponent } from './atividade.component';
import { AppCommonModule } from 'src/app/app.common.module';
import { AtividadeRoutingModule } from './atividade.routing.module';
import { CalendarModule, CardModule, DataViewModule, PanelModule } from 'primeng';
import { MatCommonModule, MatLineModule } from '@angular/material/core';



@NgModule({
  declarations: [AtividadeComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    AtividadeRoutingModule,
    CalendarModule,
    PanelModule,
    CardModule,
    DataViewModule,
    MatLineModule,
    MatCommonModule
  ]
})
export class AtividadeModule { }
