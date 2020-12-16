import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Endereco } from '../models/endereco';

@Injectable({
  providedIn: 'root'
})
export class EnderecoService {

  constructor(private http: HttpClient) { }

  buscarEnderecos(): Observable<Endereco> {
    return this.http.get<Endereco>(`${environment.API}/endereco`);
  }

  buscarEnderecoPorId(idEndereco: Endereco): Observable<Endereco> {
    return this.http.get<Endereco>(`${environment.API}/endereco/${idEndereco}`);
  }

  gravarEndereco(endereco: Endereco): Observable<Endereco> {
    return this.http.post<Endereco>(`${environment.API}/endereco`, endereco);
  }

  updateEndereco(endereco: Endereco): Observable<Endereco> {
    return this.http.put<Endereco>(`${environment.API}/endereco`, endereco);
  }
  
  excluirEndereco(idEndereco: number ): Observable<Endereco> {
    return this.http.delete<Endereco>(`${environment.API}/cliente/${idEndereco}`);
  }
}
