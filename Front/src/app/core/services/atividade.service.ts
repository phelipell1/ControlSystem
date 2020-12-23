import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Atividade } from '../models/atividade';

@Injectable({
  providedIn: 'root'
})
export class AtividadeService {

  constructor(
    private http: HttpClient
  ) { }

  getAllAtividades(): Observable<Atividade> {
    return this.http.get<Atividade>(`${environment.API}/atividade`);
  }

  getAtividadeId(idAtividade: Atividade): Observable<Atividade> {
    return this.http.get<Atividade>(`${environment.API}/atividade/${idAtividade}`);
  }

  saveAtividade(atividade: Atividade): Observable<Atividade> {
    return this.http.post<Atividade>(`${environment.API}/atividade`,atividade);
  }

  updateAtividade(atividade: Atividade): Observable<Atividade> {
    return this.http.put<Atividade>(`${environment.API}/atividade`,atividade);
  }

  deleteAtividade(idAtividade: number): Observable<Atividade> {
    return this.http.delete<Atividade>(`${environment.API}/atividade/${idAtividade}`);
  }

}