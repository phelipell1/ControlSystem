import { ItemPedido } from './../../core/models/itemPedido';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ItemPedidoService } from './../../core/services/item-pedido.service';
import { ToastService } from './../../core/services/toast.service';
import { Router } from "@angular/router";
import { EstoqueService } from "./../../core/services/estoque.service";
import { Estoque } from "./../../core/models/estoque";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-vendas",
  templateUrl: "./vendas.component.html",
  styleUrls: ["./vendas.component.css"],
})
export class VendasComponent implements OnInit {
  itemPedido: ItemPedido;
  estoque: Estoque;
  estoques: any[]=[];
  codigo: any;
  soma: number = null;
  quantidade: number = 1
  somaQuant: number = 0;
  porcentagem: number = null;
  form: FormGroup;

  constructor(
    private estoqueService: EstoqueService,
    private router: Router,
    private toastService: ToastService,
    private itemPedidoService: ItemPedidoService,
    private fb: FormBuilder
    ) {

  }

  ngOnInit(): void {
    this.form = this.fb.group({
      idEstoque: [this.estoques],
      acrescimo:[null],
      desconto: [this.porcentagem],
      quantidade:[this.estoques.length],
      totalSoma: [this.soma]
    })
  }

  buscarEstoque(event) {
    this.codigo = event.target.value;
      this.estoqueService.buscarEstoquePorId(this.codigo).subscribe(data => {
        this.estoque = data;
        this.estoques.push(this.estoque);
        console.log(this.estoques);
        console.log(this.estoque);

        if(this.soma != 0){
          this.soma = this.soma + this.estoque.produto.precoVenda;
        }

      /*for(let i=0; i<this.estoques.length; i++){

        this.soma = this.estoque.produto.precoVenda + this.estoque.produto.precoVenda;

      }*/
      console.log(this.soma);
      },
      error => this.toastService.addSingle("info", "", "código não encontrado !")
      );
  }

  CalculaDesconto(event){
    this.porcentagem = event.target.value;
    let porcent;
      porcent = (this.porcentagem * this.soma) /100;

      this.soma = this.soma - porcent;
  }

  onCancel(): void {
    this.estoques.length = 0;
    this.soma = null;
  }


  onFinaliza(){
    this.toastService.addSingle("success","Venda", "Operção concluida");
    this.estoques.length = 0;
    this.soma = null;
  }

}
