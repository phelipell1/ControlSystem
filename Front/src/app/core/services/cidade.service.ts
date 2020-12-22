import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cidade } from '../models/cidade';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

  constructor(private http: HttpClient) { }

  buscarCidades(): Observable<Cidade> {
    return this.http.get<Cidade>(`${environment.API}/cidade`);
  }

  buscarCidadePorId(idCidade: Cidade): Observable<Cidade> {
    return this.http.get<Cidade>(`${environment.API}/cidade/${idCidade}`);
  }

  gravarCidade(cidade: Cidade): Observable<Cidade> {
    return this.http.post<Cidade>(`${environment.API}/cidade`, cidade);
  }



}
