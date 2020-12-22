import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Pedido } from '../models/pedido';

@Injectable({
  providedIn: 'root'
})
export class PedidoService {

  constructor(private http: HttpClient) { }

  buscarPedidoPorId(idPedido: Pedido): Observable<Pedido> {
    return this.http.get<Pedido>(`${environment.API}/pedido/${idPedido}`);
  }

  buscarPedido(): Observable<Pedido> {
    return this.http.get<Pedido>(`${environment.API}/pedido`);
  }
  
  gravarPedido(pedido: Pedido): Observable<Pedido> {
    return this.http.post<Pedido>(`${environment.API}/pedido`, pedido);
  }

  updatePedido(pedido: Pedido): Observable<Pedido> {
    return this.http.put<Pedido>(`${environment.API}/pedido`, pedido);
  }
  
  excluirPedido(idPedido: number ): Observable<Pedido> {
    return this.http.delete<Pedido>(`${environment.API}/pedido?idPedido=${idPedido}`);
  }
}
