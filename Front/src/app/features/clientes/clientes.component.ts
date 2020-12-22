import { MenuItem } from 'primeng/api';
import { Loja } from "./../../core/models/loja";
import { LojaService } from "./../../core/services/loja.service";
import { EnderecoService } from "./../../core/services/endereco.service";
import { PessoaService } from "./../../core/services/pessoa.service";
import { UsuarioService } from "./../../core/services/usuario.service";
import { ClienteService } from "./../../core/services/cliente.service";
import { Usuario } from "./../../core/models/usuario";
import { Pessoa } from "./../../core/models/pessoa";
import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Cidade } from "src/app/core/models/cidade";
import { CidadeService } from "src/app/core/services/cidade.service";
import { Cliente } from "src/app/core/models/cliente";
import { Endereco } from "src/app/core/models/endereco";
import { Router } from "@angular/router";
import { SelectItem } from "primeng";

@Component({
  selector: "app-clientes",
  templateUrl: "./clientes.component.html",
  styleUrls: ["./clientes.component.css"],
})
export class ClientesComponent implements OnInit {
  formCliente: FormGroup;
  formUsuario: FormGroup;
  formPessoa: FormGroup;
  formEndereco: FormGroup;
  end: any;
  cliente: Cliente;
  usuario: Usuario;
  pessoa: Pessoa;
  enderecos: Endereco;
  sexo: SelectItem[];
  estadoCivil: SelectItem[];
  cidade: Cidade[] = [];
  cidades = new Cidade();
  lojas: Loja;
  submitted = false;
  date = new Date();
  teste: any;
  id: number;

  items: MenuItem[];
  constructor(
    private cidadeService: CidadeService,
    private routerLink: Router,
    private fb: FormBuilder,
    private clienteService: ClienteService,
    private usuarioService: UsuarioService,
    private pessoaService: PessoaService,
    private enderecoService: EnderecoService,
    private lojaService: LojaService
  ) {
    //Irá trazes todas as cidades do banco/////
    this.cidadeService.buscarCidades().subscribe((cidade) => {
      this.cidades = cidade;
      console.log(cidade);
    });

    this.enderecoService.buscarEnderecos().subscribe((data) => {
      this.enderecos = data;
    });

    this.lojaService.getLojas().subscribe((data) => {
      this.lojas = data;
      console.log(this.lojas);
    });

    ///Carrega o select com dados/////////////
    this.estadoCivil = [
      { label: "SOLTEIRO", value: "SOLTEIRO" },
      { label: "CASADO", value: "CASADO" },
      { label: "DIVORCIADO", value: "DIVORCIADO" },
      { label: "VIUVO", value: "VIUVO" },
    ];
    this.sexo = [
      { label: "MASCULINO", value: "MASCULINO" },
      { label: "FEMININO", value: "FEMININO" },
    ];
    /////////////////////////////////////////////


  }
  ngOnInit(): void {
    this.configFormEndereco();
    this.configFormPessoa();

    this.items = [
      {label: 'Endereço'},
      {label: 'Dados Pessoais'}

    ]
  }

  configFormEndereco() {
    this.formEndereco = this.fb.group({
      logradouro: [null, Validators.required],
      complemento: [null, Validators.required],
      bairro: [null, Validators.required],
      cep: [null, [Validators.required, Validators.maxLength(10)]],
      cidade: [null, Validators.required]
    });
  }




  onSaveEndereco(){
    this.enderecoService.gravarEndereco(this.formEndereco.value).subscribe(response => {
      this.enderecos = response
      this.id = response.idEndereco;
      console.log(this.id);
    })
  }


  configFormPessoa() {
    this.formPessoa = this.fb.group({
      nome: [null, Validators.required],
      cpf: [null, Validators.required],
      dataNascimento: [null, Validators.required],
      estadoCivil: [null, Validators.required],
      sexo: [null, Validators.required],
      telefone: [null, Validators.required],
      email: [null, Validators.required],
      endereco:[{'endereco': this.id}]
    });
  }

  onSavePessoa(){
    this.pessoaService.gravarPessoa(this.formPessoa.value).subscribe(data => {
      this.pessoa = data;
      this.onSaveEndereco();
      console.log(this.pessoa);

    })
  }
}
