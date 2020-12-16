import { Cliente } from './../../../core/models/cliente';
import { ClienteService } from './../../../core/services/cliente.service';
import { SelectItem } from 'primeng';
import { CidadeService } from './../../../core/services/cidade.service';
import { Cidade } from './../../../core/models/cidade';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-clientes-editar',
  templateUrl: './clientes-editar.component.html',
  styleUrls: ['./clientes-editar.component.css']
})
export class ClientesEditarComponent implements OnInit {

  id: any;
  cidades: Cidade;
  estadoCivil: SelectItem[];
  sexo: SelectItem[];
  clientes: Cliente;

  constructor(
    private router: ActivatedRoute,
    private route: Router,
    private cidadeServices: CidadeService,
    private clienteService: ClienteService
  ) {

    this.estadoCivil = [
      { label: "Solteiro", value: "SOLTEIRO" },
      { label: "Casado", value: "CASADO" },
      { label: "Divorciado", value: "DIVORCIADO" },
      { label: "Viuvo", value: "VIUVO" }
    ];
    this.sexo = [
      { label: "MASCULINO", value: "MASCULINO" },
      { label: "FEMININO", value: "FEMININO" }
    ];

    this.cidadeServices.buscarCidades().subscribe(data => {
      this.cidades = data;
    });

  }

  ngOnInit(): void {

    this.id = this.router.snapshot.params['id'];

    this.clienteService.buscarClientePorId(this.id).subscribe(data => {
      this.clientes = data;
    });
  }

  onBack(): void {
    this.route.navigate(['/main/clientes']);
  }


}
