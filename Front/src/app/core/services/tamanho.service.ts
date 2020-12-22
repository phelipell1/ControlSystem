import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Tamanho } from '../models/tamanho';

@Injectable({
  providedIn: 'root'
})
export class TamanhoService {

  constructor(private http: HttpClient) { }



  buscarTamanhoPorId(idTamanho: number): Observable<Tamanho> {
    return this.http.get<Tamanho>(`${environment.API}/tamanho/${idTamanho}`);
  }

  buscarTamanho(): Observable<Tamanho[]> {
    return this.http.get<Tamanho[]>(`${environment.API}/tamanho`);
  }
  
  gravarTamanho(tamanho: Tamanho): Observable<Tamanho> {
    return this.http.post<Tamanho>(`${environment.API}/tamanho`, tamanho);
  }

  updateTamanho(tamanho: Tamanho): Observable<Tamanho> {
    return this.http.put<Tamanho>(`${environment.API}/tamanho`, tamanho);
  }
  
  excluirTamanho(idTamanho: number ): Observable<Tamanho> {
    return this.http.delete<Tamanho>(`${environment.API}/tamanho/${idTamanho}`);
  }
}
