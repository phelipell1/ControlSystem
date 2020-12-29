import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AtividadeModel } from '../models/atividade';

@Injectable({
  providedIn: 'root'
})
export class AtividadesService {

  constructor(
    private http: HttpClient
  ) { }

  getAllAtividades(): Observable<AtividadeModel> {
    return this.http.get<AtividadeModel>(`${environment.API}/atividade`)
  }

  save(atividade: AtividadeModel): Observable<AtividadeModel> {
    return this.http.post<AtividadeModel>(`${environment.API}/atividade`, atividade);
  }

  delete(idAtividade: number): Observable<any>{
    return this.http.delete(`${environment.API}/atividade/delete/${idAtividade}`, {responseType: 'text'});
  }
}
