import { Component, OnInit } from '@angular/core';
import { Atividade } from 'src/app/core/models/atividade';
import { Cidade } from 'src/app/core/models/cidade';
import { AtividadeService } from 'src/app/core/services/atividade.service';
import { CidadeService } from 'src/app/core/services/cidade.service';

@Component({
  selector: 'app-atividade',
  templateUrl: './atividade.component.html',
  styleUrls: ['./atividade.component.css']
})
export class AtividadeComponent implements OnInit {
  
  atv: Atividade;
  cid: Cidade;

  constructor(
    private atividadeService: AtividadeService,
    private cidadeService: CidadeService
  ) { 

    atividadeService.getAllAtividades().subscribe(data => {
      this.atv = data;
      console.log(this.atv)
    })

  }

  ngOnInit(): void {
  }

}
