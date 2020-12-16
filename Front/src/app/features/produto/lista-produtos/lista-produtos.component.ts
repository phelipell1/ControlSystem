import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produto } from 'src/app/core/models/produto';
import { ProdutoService } from 'src/app/core/services/produto.service';

@Component({
  selector: 'app-lista-produtos',
  templateUrl: './lista-produtos.component.html',
  styleUrls: ['./lista-produtos.component.css']
})
export class ListaProdutosComponent implements OnInit {
  produtos: Produto[];
  columns: any[];


  constructor(private produtoService: ProdutoService,
    private router: Router) { 
      this.produtoService.buscarProduto().subscribe(produtos =>{
        this.produtos = produtos
      })
    }

  ngOnInit(): void {
  }


  cadastro(): void {
    this.router.navigate(['/main/produto/cadastro'])
  }

}
