import { Cidade } from "./cidade.model";

export class Endereco {

  idEndereco: number;
  logradouro: String;
  numero: number;
  complemento: String;
  setorBairro: String;
  idCidade: Cidade;
}
