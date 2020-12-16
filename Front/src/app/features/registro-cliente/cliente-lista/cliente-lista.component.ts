import { ClienteService } from './../../../core/services/cliente.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { Cliente } from 'src/app/core/models/cliente';

@Component({
  selector: 'app-cliente-lista',
  templateUrl: './cliente-lista.component.html',
  styleUrls: ['./cliente-lista.component.css']
})
export class ClienteListaComponent implements OnInit {

  clientes: Cliente;

  constructor(
    private router: Router,
    private clienteService: ClienteService,
    private route: ActivatedRoute
  ) {
    this.clienteService.buscarClientes().subscribe(data => {
      this.clientes = data;
    })
  }

  ngOnInit(): void {
  }

  onNewCadastro(): void {
    this.router.navigate(['main/usuario/cadastro']);
  }

  onDetails(id): void {
    this.router.navigate(["details", id], {relativeTo: this.route});
  }

  onUpdate(id): void {
    this.router.navigate(['update', id], {relativeTo: this.route});
  }
}
