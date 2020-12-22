import { CidadeService } from './../../../core/services/cidade.service';
import { ClienteService } from './../../../core/services/cliente.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { Cliente } from 'src/app/core/models/cliente';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-clientes-detalhes',
  templateUrl: './clientes-detalhes.component.html',
  styleUrls: ['./clientes-detalhes.component.css']
})
export class ClientesDetalhesComponent implements OnInit {

  cliente: Cliente;
  id: any;

  constructor(
    private route: ActivatedRoute,
    private clienteService: ClienteService,
    private router: Router
  ) {

  }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];

    this.clienteService.buscarClientePorId(this.id).subscribe(data =>{
      console.log(data)
        this.cliente = data;
      }, error => console.log(error));
  }

  onListaClient(): void {
    this.router.navigate(['main/clientes']);
  }

}
