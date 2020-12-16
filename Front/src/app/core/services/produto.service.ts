import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Produto } from '../models/produto';

@Injectable({
  providedIn: 'root'
})
export class ProdutoService {

  constructor(private http: HttpClient) { }

  buscarProdutoPorId(idProduto: Produto): Observable<Produto> {
    return this.http.get<Produto>(`${environment.API}/produto/${idProduto}`);
  }

  buscarProduto(): Observable<Produto[]> {
    return this.http.get<Produto[]>(`${environment.API}/produto`);
  }

  gravarProduto(produto: Produto): Observable<Produto> {
    return this.http.post<Produto>(`${environment.API}/produto`, produto);
  }

  updateProduto(produto: Produto): Observable<Produto> {
    return this.http.put<Produto>(`${environment.API}/produto`, produto);
  }

  excluirProduto(idProduto: number ): Observable<Produto> {
    return this.http.delete<Produto>(`${environment.API}/produto/${idProduto}`);
  }
}





