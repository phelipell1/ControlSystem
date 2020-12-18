import { Pessoa } from './pessoa.model';
export class Usuario {
  idUsuario: number;
  idPessoa: Pessoa;
  nomeLogin: String;
  password: String;
  status: boolean;
  dateCadastro: Date;
  cargo: number;
}
