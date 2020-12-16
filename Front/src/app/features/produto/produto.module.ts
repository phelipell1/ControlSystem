import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AppCommonModule } from 'src/app/app.common.module';
import {MatSelectModule} from '@angular/material/select';
import { ProdutoComponent } from './produto.component';
import { ProdutoRoutingModule } from './produto.routing'
import {DropdownModule} from 'primeng/dropdown';
import { ListaProdutosComponent } from './lista-produtos/lista-produtos.component';
import {InputNumberModule} from 'primeng/inputnumber';

@NgModule({

  imports: [
    CommonModule,
    DropdownModule,
    ProdutoRoutingModule,
    AppCommonModule,
    MatSelectModule,
    InputNumberModule
  ],
  declarations: [ProdutoComponent, ListaProdutosComponent]
})
export class ProdutoModule { }


