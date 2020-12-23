import { Usuario } from './../models/usuario.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) {
   }

  getAllUsers(): Observable<Usuario> {
    return this.http.get<Usuario>(`${environment.API}/user`);
  }

  getAllById(idUsuario: Usuario): Observable<Usuario> {
    return this.http.get<Usuario>(`${environment.API}/${idUsuario}`);
  }

  postUser(usuario: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(`${environment.API}`, usuario);
  }



}
