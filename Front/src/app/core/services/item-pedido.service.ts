import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ItemPedido } from '../models/itemPedido';

@Injectable({
  providedIn: 'root'
})
export class ItemPedidoService {

  constructor(private http: HttpClient) { }

  buscarItemPedido(): Observable<ItemPedido> {
    return this.http.get<ItemPedido>(`${environment.API}/item-pedido`);
  }

  buscarItemPedidoPorId(idItemPedido: ItemPedido): Observable<ItemPedido> {
    return this.http.get<ItemPedido>(`${environment.API}/item-pedido/${idItemPedido}`);
  }

  gravarItemPedido(itemPedido: ItemPedido): Observable<ItemPedido> {
    return this.http.post<ItemPedido>(`${environment.API}/item-pedido`, itemPedido);
  }

  updateItemPedido(itemPedido: ItemPedido): Observable<ItemPedido> {
    return this.http.put<ItemPedido>(`${environment.API}/item-pedido`, itemPedido);
  }
  
  excluirItemPedido(idItemPedido: number ): Observable<ItemPedido> {
    return this.http.delete<ItemPedido>(`${environment.API}/item-pedido/${idItemPedido}`);
  }
}
