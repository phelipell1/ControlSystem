import { Produto } from 'src/app/core/models/produto';
import { EstoqueService } from './../../../core/services/estoque.service';
import { Estoque } from 'src/app/core/models/estoque';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-estoque-detalhes',
  templateUrl: './estoque-detalhes.component.html',
  styleUrls: ['./estoque-detalhes.component.css']
})
export class EstoqueDetalhesComponent implements OnInit {

  estoque: Estoque;
  produto: Produto;
  id: any;

  constructor(
    private router: ActivatedRoute,
    private estoqueService: EstoqueService,
    private route: Router
  ) {

  }
  ngOnInit(): void {

    this.id = this.router.snapshot.params['id'];

    this.estoqueService.buscarEstoquePorId(this.id).subscribe(data => {
      this.estoque = data;
    });

  }

  onBackList(): void {
    this.route.navigate(['/main/estoque'])
  }

}
