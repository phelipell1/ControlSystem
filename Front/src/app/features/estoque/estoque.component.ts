import { UsuarioService } from "./../../core/services/usuario.service";
import { Usuario } from "./../../core/models/usuario";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { EstoqueService } from "./../../core/services/estoque.service";
import { Router } from "@angular/router";
import { Component, OnInit } from "@angular/core";
import { Estoque } from "src/app/core/models/estoque";
import { Produto } from "src/app/core/models/produto";
import { ProdutoService } from "src/app/core/services/produto.service";
import { ToastService } from "src/app/core/services/toast.service";

@Component({
  selector: "app-estoque",
  templateUrl: "./estoque.component.html",
  styleUrls: ["./estoque.component.css"],
})
export class EstoqueComponent implements OnInit {
  desativado = true;
  dataInicial: number = Date.now();

  produto: Produto[];
  estoque: Estoque = new Estoque();
  usuario: Usuario;

  formulario: FormGroup;

  constructor(
    private produtoService: ProdutoService,
    private estoqueService: EstoqueService,
    private usuarioServer: UsuarioService,
    private fm: FormBuilder,
    private router: Router,
    private toastService: ToastService
  ) {
    this.produtoService.buscarProduto().subscribe((data) => {
      this.produto = data;
      console.log(this.produto);
    });

    this.usuarioServer.buscarUsuario().subscribe((data) => {
      this.usuario = data;
    });
  }

  ngOnInit(): void {
    this.configuraForm();
  }

  cancelar(): void {
    this.router.navigate(["main/estoque"]);
  }

  configuraForm() {
    this.formulario = this.fm.group({
      dataLancamento: [null, Validators.required],
      quantidade: [null, [Validators.required, Validators.maxLength(4)]],
      produto: [null, Validators.required],
      usuario: [null, Validators.required],
    });
  }

  onSave() {
    console.log(this.formulario.value);
    this.estoqueService
      .gravarEstoque(this.formulario.value)
      .subscribe((data) => {
        this.estoque = data;
        console.log(this.estoque);
      });
    this.toastService.addSingle("success", "", "Item adicionado com sucesso");
    this.router.navigate(["/main/estoque"]);
  }


}
