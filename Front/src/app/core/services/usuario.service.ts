import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  buscarUsuarioPorId(idUsuario: Usuario): Observable<Usuario> {
    return this.http.get<Usuario>(`${environment.API}/usuario/${idUsuario}`);
  }

  buscarUsuario(): Observable<Usuario> {
    return this.http.get<Usuario>(`${environment.API}/usuario`);
  }

  gravarUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${environment.API}/usuario`, usuario);
  }

  updateUsuario(usuario: Usuario): Observable<Usuario> {
    return this.http.put<Usuario>(`${environment.API}/usuario`, usuario);
  }
  
  excluirUsuario(idUsuario: number ): Observable<Usuario> {
    return this.http.delete<Usuario>(`${environment.API}/usuario/${idUsuario}`);
  }
}
