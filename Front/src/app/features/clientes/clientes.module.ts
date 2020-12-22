import { CardModule } from 'primeng/card';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesComponent } from './clientes.component';
import { DropdownModule, MenuModule, PanelModule, PasswordModule } from 'primeng';
import { FormsModule } from '@angular/forms';
import { InputMaskModule } from 'primeng/inputmask';
import { ButtonModule } from 'primeng/button';
import { InputTextModule } from 'primeng/inputtext';
import { HeaderBreadCrumbModule } from 'src/app/shared/layout/header-breadcrumb/header-breadcrumb.module';
import { TableModule } from 'primeng/table';
import { MessageModule } from 'primeng/message';
import { ReactiveFormsModule } from '@angular/forms';
import { ClientesListComponent } from './clientes-list/clientes-list.component';
import { ClientesDetalhesComponent } from './clientes-detalhes/clientes-detalhes.component';
import { ClientesEditarComponent } from './clientes-editar/clientes-editar.component';
import {AccordionModule} from 'primeng/accordion';
import { StepsModule } from 'primeng/steps';


@NgModule({
  declarations: [ClientesComponent, ClientesListComponent, ClientesDetalhesComponent, ClientesEditarComponent],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    PanelModule,
    FormsModule,
    InputMaskModule,
    DropdownModule,
    ButtonModule,
    InputTextModule,
    HeaderBreadCrumbModule,
    TableModule,
    MessageModule,
    ReactiveFormsModule,
    StepsModule,
    CardModule,
    PasswordModule,
    AccordionModule,
    StepsModule,
    MenuModule
  ]
})
export class ClientesModule { }
