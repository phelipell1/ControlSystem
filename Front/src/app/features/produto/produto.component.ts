import { Validators } from '@angular/forms';
import { ToastService } from './../../core/services/toast.service';
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Subscriber } from "rxjs";
import { Modelo } from "src/app/core/models/modelo";
import { Produto } from "src/app/core/models/produto";
import { Tamanho } from "src/app/core/models/tamanho";
import { ModeloService } from "src/app/core/services/modelo.service";
import { ProdutoService } from "src/app/core/services/produto.service";
import { TamanhoService } from "src/app/core/services/tamanho.service";

@Component({
    selector: "app-produto",
    templateUrl: "./produto.component.html",
    styleUrls: ["./produto.component.css"],
})
export class ProdutoComponent implements OnInit {
    modelos: Modelo[] = [];
    modelo: Modelo;
    produto: Produto;
    produtos: Produto[] = [];
    tamanhos: Tamanho[] = [];
    tamanho: Tamanho;

    msg: string;



    constructor(
        private modeloService: ModeloService,
        private produtoService: ProdutoService,
        private tamanhoService: TamanhoService,
        private router: Router,
        private toastService: ToastService
    ) {
        this.produto = new Produto();
        this.modeloService.buscarModelo().subscribe((modelos) => {
            this.modelos = modelos;
        });
        this.tamanhoService.buscarTamanho().subscribe((tamanhos) => {
            this.tamanhos = tamanhos;
        });
    }

    ngOnInit(): void {}

    salvar() {

        if(this.produto === null){
          this.toastService.addSingle('warning', '', 'Atenção campo em branco');
        }else{

        this.produtoService.gravarProduto(this.produto).subscribe((produto) => {
            this.produto = produto;

            this.toastService.addSingle('info', '', 'Item adicionado com sucesso');

            this.router.navigate(['/main/produto'])
        });
      }

    }

    cancelar(): void {
        this.router.navigate(["/main/produto"]);
    }
}
