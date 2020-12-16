import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cliente } from '../models/cliente';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  buscarClientes(): Observable<Cliente> {
    return this.http.get<Cliente>(`${environment.API}/cliente`);
  }

  buscarClientePorId(idCliente: Cliente): Observable<Cliente> {
    return this.http.get<Cliente>(`${environment.API}/cliente/${idCliente}`);
  }

  gravarCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.post<Cliente>(`${environment.API}/cliente`, cliente);
  }

  updateCliente(cliente: Cliente): Observable<Cliente> {
    return this.http.put<Cliente>(`${environment.API}/cliente`, cliente);
  }

  excluirCliente(idCliente: number ): Observable<Cliente> {
    return this.http.delete<Cliente>(`${environment.API}/cliente/delete/${idCliente}`);
  }


}
