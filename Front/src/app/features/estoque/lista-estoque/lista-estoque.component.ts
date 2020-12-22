import { ToastService } from "src/app/core/services/toast.service";
import { EstoqueService } from "./../../../core/services/estoque.service";
import { Router, RouterModule, ActivatedRoute } from "@angular/router";
import { Component, OnInit } from "@angular/core";
import { Estoque } from "src/app/core/models/estoque";
import { Subject } from "rxjs";

@Component({
  selector: "app-lista-estoque",
  templateUrl: "./lista-estoque.component.html",
  styleUrls: ["./lista-estoque.component.css"],
})
export class ListaEstoqueComponent implements OnInit {
  estoque = new Estoque();
  estoques: Estoque[];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private estoqueService: EstoqueService,
    private toastService: ToastService
  ) {
    this.estoqueService.buscarEstoque().subscribe((data) => {
      this.estoque = data;
      console.log(this.estoque);
    });


  }

  ngOnInit(): void {

  }

  showDetalhes(id) {
    this.router.navigate(["detalhes", id], { relativeTo: this.route });
  }

  cadastro(): void {
    this.router.navigate(["/main/estoque/cadastro"]);
  }

  onUpdate(id: number) {
    this.router.navigate(["update", id], { relativeTo: this.route });
  }

  onDelete(id: number) {
    let valorEscolhido = confirm("Deseja deletar o item ?");

    if (valorEscolhido == true) {
      this.estoqueService.excluirEstoque(id).subscribe((data) => {
        this.estoque = data;
        this.toastService.addSingle(
          "success",
          "fas fa-check",
          "Item excluido !"
        );
        this.router.navigate(["/main/estoque"]);
      });
    }
  }

  findByValue(prod: number): number {
    let valor = null;
    for (let i = 0; i < this.estoques.length; i++) {
      if (this.estoques[i].idEstoque == prod) {
        valor = i;
        break;
      }
    }

    return valor;
    console.log(valor);
  }


}
