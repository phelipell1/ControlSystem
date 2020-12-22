import { EstoqueUpdateComponent } from './estoque-update/estoque-update.component';
import { EstoqueDetalhesComponent } from './estoque-detalhes/estoque-detalhes.component';
import { ListaEstoqueComponent } from './lista-estoque/lista-estoque.component';
import { EstoqueComponent } from './estoque.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    component: ListaEstoqueComponent
  },
  {
    path: 'cadastro',
    component: EstoqueComponent
  },
  {
    path: 'detalhes/:id',
    component: EstoqueDetalhesComponent
  },
  {
    path: 'update/:id',
    component: EstoqueUpdateComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EstoqueRoutingModule { }
