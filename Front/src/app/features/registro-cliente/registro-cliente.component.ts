import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { ClienteService } from './../../core/services/cliente.service';
import { Cidade } from "src/app/core/models/cidade";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { CidadeService } from "./../../core/services/cidade.service";
import { MessageService, SelectItem } from "primeng/api";
import { Component, OnInit } from "@angular/core";
import { Cliente } from "src/app/core/models/cliente";
import { ToastService } from 'src/app/core/services/toast.service';

@Component({
  selector: "app-registro-cliente",
  templateUrl: "./registro-cliente.component.html",
  styleUrls: ["./registro-cliente.component.css"],
})
export class RegistroClienteComponent implements OnInit {
  cliente: Cliente;
  cidades: Cidade;
  formCliente: FormGroup;
  estadoCivil: SelectItem[];
  sexo: SelectItem[];
  date = new Date();

  constructor(
    public messageService: MessageService,
    private cidadeService: CidadeService,
    private fb: FormBuilder,
    private clienteService: ClienteService,
    private toastService: ToastService,
    private router: Router
  ) {
    this.cidadeService.buscarCidades().subscribe((data) => {
      this.cidades = data;
    });

    this.estadoCivil = [
      { label: "SOLTEIRO", value: 0 },
      { label: "CASADO", value: 1 },
      { label: "DIVORCIADO", value: 2 },
      { label: "VIUVO", value: 3 },
    ];

    this.sexo = [
      { label: "MASCULINO", value: "MASCULINO" },
      { label: "FEMININO", value: "FEMININO" },
    ];
  }

  ngOnInit(): void {
    this.configformCliente();
  }

  configformCliente() {
    this.formCliente = this.fb.group({
      usuario: this.fb.group({
        login: [null, Validators.required],
        senha: [null, Validators.required],
        status: [0],
        loja: [{'idLoja': 1}],
        dataCadastro: [this.date],
        pessoa: this.fb.group({
          nome: [null, Validators.required],
          cpf: [null, Validators.required],
          dataNascimento: [null, Validators.required],
          estadoCivil: [null, Validators.required],
          sexo: [null, Validators.required],
          email: [null, Validators.required],
          telefone: [null, Validators.required],
          endereco: this.fb.group({
            cidade: [null, Validators.required],
            complemento: [null, Validators.required],
            bairro: [null, Validators.required],
            cep: [null, Validators.required],
            logradouro: [null, Validators.required]
          }),
        }),
      })
    });
  }

  onSave() {
    this.clienteService
      .gravarCliente(this.formCliente.value)
      .subscribe((data) => {
        this.cliente = data;
        this.toastService.addSingle("success", "", `${data.usuario.pessoa.nome} adicionado com sucesso !`);
        this.router.navigate(["/main/clientes"]);
      },

      error => this.toastService.addSingle("error", "Ops!", "Erro interno, consulte o suporte")

      );
  }
}
