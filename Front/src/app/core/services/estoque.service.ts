import { Estoque } from './../models/estoque';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class EstoqueService {

  private baseUrl = 'http://localhost:8080/api/estoque/delete';

  constructor(private http: HttpClient) { }

  buscarEstoque(): Observable<Estoque> {
    return this.http.get<Estoque>(`${environment.API}/estoque`);
  }

  buscarEstoquePorId(idEstoque: Estoque): Observable<Estoque> {
    return this.http.get<Estoque>(`${environment.API}/estoque/${idEstoque}`);
  }

  buscarEtoquePorNome(descricao: Estoque): Observable<Estoque> {
    return this.http.get<Estoque>(`${environment.API}/page/${descricao}`);
  }

  gravarEstoque(estoque: Estoque): Observable<Estoque> {
    return this.http.post<Estoque>(`${environment.API}/estoque`, estoque);
  }

  addEstoque(estoque: Estoque): Observable<Estoque> {
    return this.http.post<Estoque>(`${environment.API}/estoques`, estoque);
  }

  updateEstoque(id: number, estoque: any): Observable<Estoque> {
    return this.http.put<Estoque>(`${environment.API}/estoque/update/${id}`, estoque) ;
  }

  /*excluirEstoque(idEstoque: number ): Observable<Estoque> {
    return this.http.delete<Estoque>(`${environment.API}/estoque/delete/${idEstoque}`);
  }*/
  excluirEstoque(id: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${id}`, { responseType: 'text' });
  }
}
