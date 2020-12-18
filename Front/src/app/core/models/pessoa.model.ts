import { Endereco } from "./endereco.model";

export class Pessoa {

  idUsuario: number;
  nomeCompleto: String;
  CPF: String;
  sexo: number;
  estCivil: number;
  dataNascimento: Date;
  email: String;
  numCelular: String;
  numFixo: String;
  idEndereco: Endereco;
}
