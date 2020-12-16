import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ListaProdutosComponent } from './lista-produtos/lista-produtos.component';
import { ProdutoComponent } from './produto.component';


const routes: Routes = [
  {
    path: '',
    component: ListaProdutosComponent
},
{

  path: 'cadastro',
  component: ProdutoComponent
 
}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProdutoRoutingModule { }
