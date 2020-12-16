import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pessoa } from '../models/pessoa';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  constructor(private http: HttpClient) { }

  buscarPessoaPorId(idPessoa: Pessoa): Observable<Pessoa> {
    return this.http.get<Pessoa>(`${environment.API}/pessoa/${idPessoa}`);
  }

  buscarPessoa(): Observable<Pessoa> {
    return this.http.get<Pessoa>(`${environment.API}/pessoa`);
  }
  
  gravarPessoa(pessoa: Pessoa): Observable<Pessoa> {
    return this.http.post<Pessoa>(`${environment.API}/pessoa`, pessoa);
  }

  updatePessoa(pessoa: Pessoa): Observable<Pessoa> {
    return this.http.put<Pessoa>(`${environment.API}/pessoa`, pessoa);
  }
  
  excluirPessoa(idPessoa: number ): Observable<Pessoa> {
    return this.http.delete<Pessoa>(`${environment.API}/pessoa/${idPessoa}`);
  }
}
