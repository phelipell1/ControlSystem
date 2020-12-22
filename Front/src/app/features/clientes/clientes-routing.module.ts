import { ClientesEditarComponent } from './clientes-editar/clientes-editar.component';
import { ClientesDetalhesComponent } from './clientes-detalhes/clientes-detalhes.component';
import { ClientesListComponent } from './clientes-list/clientes-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ClientesComponent } from './clientes.component';


const routes: Routes = [
  {
    path: '',
    component: ClientesListComponent
  },
  {
    path: 'cadastro',
    component: ClientesComponent
  },
  {
    path: 'detalhes/:id',
    component: ClientesDetalhesComponent
  },
  {
    path: 'editar/:id',
    component: ClientesEditarComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ClientesRoutingModule { }
