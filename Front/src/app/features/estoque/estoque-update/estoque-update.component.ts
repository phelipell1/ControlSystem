import { DataViewModule } from 'primeng/dataview';
import { ToastService } from 'src/app/core/services/toast.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Usuario } from './../../../core/models/usuario';
import { UsuarioService } from './../../../core/services/usuario.service';
import { ProdutoService } from 'src/app/core/services/produto.service';
import { Produto } from 'src/app/core/models/produto';
import { EstoqueService } from './../../../core/services/estoque.service';
import { Estoque } from 'src/app/core/models/estoque';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-estoque-update',
  templateUrl: './estoque-update.component.html',
  styleUrls: ['./estoque-update.component.css']
})
export class EstoqueUpdateComponent implements OnInit {

  estoque: Estoque;
  produto: Produto[];
  usuario: Usuario;
  formulario: FormGroup;
  id: any;

  constructor(
    private router: ActivatedRoute,
    private route: Router,
    private estoqueService: EstoqueService,
    private produtoService: ProdutoService,
    private usuarioService: UsuarioService,
    private fb: FormBuilder,
    private toastService: ToastService
  ) {

    this.usuarioService.buscarUsuario().subscribe(data => {
      this.usuario = data;
    });

    this.produtoService.buscarProduto().subscribe(data => {
      this.produto = data;
    });
  }

  ngOnInit(): void {
    this.configFormulario();


    this.id = this.router.snapshot.params['id'];

    this.estoqueService.buscarEstoquePorId(this.id).subscribe(data => {
      this.estoque = data;
      this.updateFormulario(this.estoque);
    })
  }

  configFormulario(){
    this.formulario = this.fb.group({
      dataLancamento: [null, Validators.required],
      quantidade: [null, Validators.required],
      produto: [null, Validators.required],
      usuario: [null, Validators.required]

    });
  }


  updateFormulario(estoque){
    this.formulario.patchValue({
      idEstoque: estoque.idEstoque,
      dataLancamento: estoque.dataLancamento,
      quantidade: estoque.quantidade,
      produto: estoque.produto.descricao,
      usuario: estoque.usuario.login
    })
  }

  onBack(): void {
    this.route.navigate(['main/estoque']);
  }

  onUpdate(){
    this.estoqueService.updateEstoque(this.id).subscribe(data => {
      this.estoque = data;
      this.toastService.addSingle("success", "", "Item atualizado");
      this.route.navigate(['main/estoque']);
    });
  }


}
