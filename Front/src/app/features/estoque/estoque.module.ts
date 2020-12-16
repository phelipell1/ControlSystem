import { EstoqueUpdateComponent } from './estoque-update/estoque-update.component';
import { CardModule } from 'primeng/card';
import { EstoqueDetalhesComponent } from './estoque-detalhes/estoque-detalhes.component';
import { MatSelectModule } from '@angular/material/select';
import { MatFormFieldModule } from '@angular/material/form-field';
import { TableModule } from 'primeng/table';
import { ListaEstoqueComponent } from './lista-estoque/lista-estoque.component';
import { AppCommonModule } from './../../app.common.module';
import { EstoqueComponent } from './estoque.component';
import { EstoqueRoutingModule } from './estoque.routing.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {PickListModule} from 'primeng/picklist';
import { MatSliderModule } from '@angular/material/slider';
import {ToolbarModule} from 'primeng/toolbar';
import {PanelModule} from 'primeng/panel';




@NgModule({
  declarations: [EstoqueComponent, ListaEstoqueComponent, EstoqueDetalhesComponent, EstoqueUpdateComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    EstoqueRoutingModule,
    PickListModule,
    TableModule,
    MatFormFieldModule,
    MatSelectModule,
    TableModule,
    MatSliderModule,
    CardModule,
    ToolbarModule,
    PanelModule

  ]
})
export class EstoqueModule { }
