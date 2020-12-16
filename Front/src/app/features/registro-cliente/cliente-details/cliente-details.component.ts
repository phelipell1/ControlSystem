import { Usuario } from './../../../core/models/usuario';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastService } from './../../../core/services/toast.service';
import { Cliente } from './../../../core/models/cliente';
import { ClienteService } from './../../../core/services/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { disableCursor } from '@fullcalendar/core';

@Component({
  selector: 'app-cliente-details',
  templateUrl: './cliente-details.component.html',
  styleUrls: ['./cliente-details.component.css']
})
export class ClienteDetailsComponent implements OnInit {

  id: any;
  cliente: Cliente;
  usuario: Usuario;
  formulario: FormGroup;

  constructor(
    private router: ActivatedRoute,
    private clienteService: ClienteService,
    private toastService: ToastService,
    private route: Router,
    private fb: FormBuilder
  ) {

    this.id = this.router.snapshot.params['id'];


    }

  ngOnInit(): void {
    this.clienteService.buscarClientePorId(this.id).subscribe(data => {
      this.cliente = data;
      this.recuperaFormulario(this.cliente);
      console.log(this.recuperaFormulario)
    },
    error => this.toastService.addSingle("error", "Ops!", "Não fui po"));

    this.configFormulario();

  }

  configFormulario(){
    this.formulario = this.fb.group({
      idCliente: [null, Validators.required],
      login: [null, Validators.required],
      senha: [null, Validators.required],
      status: [null, Validators.required],
      loja: [null, Validators.required],
      dataCadastro: [null, Validators.required],
      nome: [null, Validators.required],
      cpf: [null, Validators.required],
      dataNascimento: [null, Validators.required],
      estadoCivil: [null, Validators.required],
      sexo: [null, Validators.required],
      email:[null, Validators.required],
      telefone: [null, Validators.required],
      cidade: [null, Validators.required],
      complemento: [null, Validators.required],
      bairro: [null, Validators.required],
      cep: [null, Validators.required],
      logradouro: [null, Validators.required],
    })
  }


  onBack(): void {

    this.route.navigate(['main/clientes']);
  }

  recuperaFormulario(cliente){
    this.formulario.patchValue({
      idCliente: cliente.idCliente,
      login: cliente.usuario.login,
      senha: cliente.usuario.senha,
      status: cliente.usuario.status,
      loja: cliente.usuario.loja.nomeLoja,
      dataCadastro: [cliente.usuario.dataCadastro],
      nome: cliente.usuario.pessoa.nome,
      cpf: cliente.usuario.pessoa.cpf,
      dataNascimento: cliente.usuario.pessoa.dataNascimento,
      estadoCivil: cliente.usuario.pessoa.estadoCivil,
      sexo: cliente.usuario.pessoa.sexo,
      email: cliente.usuario.pessoa.email,
      telefone: cliente.usuario.pessoa.telefone,
      cidade: cliente.usuario.pessoa.endereco.cidade.nomeCidade,
      complemento: cliente.usuario.pessoa.endereco.complemento,
      bairro: cliente.usuario.pessoa.endereco.bairro,
      cep: cliente.usuario.pessoa.endereco.cep,
      logradouro: cliente.usuario.pessoa.endereco.logradouro,
    })
  }


}
