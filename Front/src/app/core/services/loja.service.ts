import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Loja } from '../models/loja';

@Injectable({
  providedIn: 'root'
})
export class LojaService {

  constructor(private http: HttpClient) { }
Cidades
  getLojas(): Observable<Loja> {
    return this.http.get<Loja>(`${environment.API}/loja`);
  }

  buscarLoja(idLoja: number): Observable<Loja> {
    return this.http.get<Loja>(`${environment.API}/loja/${idLoja}`);
  }
}
