import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Modelo } from '../models/modelo';

@Injectable({
  providedIn: 'root'
})
export class ModeloService {

  constructor(private http: HttpClient) { }

  buscarModeloPorId(idModelo: number): Observable<Modelo> {
    return this.http.get<Modelo>(`${environment.API}/modelo/${idModelo}`);
  }

  buscarModelo(): Observable<Modelo[]> {
    return this.http.get<Modelo[]>(`${environment.API}/modelo`);
  }
  
  gravarModelo(modelo: Modelo): Observable<Modelo> {
    return this.http.post<Modelo>(`${environment.API}/modelo`, modelo);
  }

  updateModelo(modelo: Modelo): Observable<Modelo> {
    return this.http.put<Modelo>(`${environment.API}/modelo`, modelo);
  }
  
  excluirModelo(idModelo: number ): Observable<Modelo> {
    return this.http.delete<Modelo>(`${environment.API}/modelo/${idModelo}`);
  }

}


