import { HeaderBreadcrumbComponent } from "./../../../shared/layout/header-breadcrumb/header-breadcrumb.component";
import { ActivatedRoute, Router } from "@angular/router";
import { ClienteService } from "./../../../core/services/cliente.service";
import { Component, OnInit } from "@angular/core";
import { Cliente } from "src/app/core/models/cliente";

@Component({
  selector: "app-clientes-list",
  templateUrl: "./clientes-list.component.html",
  styleUrls: ["./clientes-list.component.css"],
})
export class ClientesListComponent implements OnInit {
  cliente: Cliente;

  constructor(
    private clienteService: ClienteService,
    private route: Router,
    private router: ActivatedRoute
  ) {
    this.clienteService.buscarClientes().subscribe((data) => {
      this.cliente = data;
      console.log(this.cliente);
    });
  }

  ngOnInit(): void {}

  click(): void {
    this.route.navigate(["main/clientes/cadastro"]);
  }

  showDetalhes(id) {
    this.route.navigate(["detalhes", id], { relativeTo: this.router });
  }

  onEditar(id) {
    this.route.navigate(["editar", id], { relativeTo: this.router });
  }

  deleteCliente(id) {
    let valorEscolhido = confirm("Deseja deletar o item ?");

    if (valorEscolhido == true) {
      this.clienteService.excluirCliente(id).subscribe(
        (data) => {
          console.log(data);
        },
        (error) => console.log(error)
      );
    }
  }
}
