import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Estado } from '../models/estado';

@Injectable({
  providedIn: 'root'
})
export class EstadoService {

  constructor(private http: HttpClient) { }

  
  buscarEstados(): Observable<Estado> {
    return this.http.get<Estado>(`${environment.API}/estado`);
  }

  buscarEstadoPorId(idEstado: Estado): Observable<Estado> {
    return this.http.get<Estado>(`${environment.API}/estado/${idEstado}`);
  }

  gravarCidade(estado: Estado): Observable<Estado> {
    return this.http.post<Estado>(`${environment.API}/estado`, estado);
}

}
