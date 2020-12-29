import { CidadeModel } from "./cidade.model";

export class EnderecoModel {
    idEndereco: number;
    logradouro: String;
    numero: number;
    complemento: String;
    setorBairro: String;
    cep: String;
    idCidade: CidadeModel;
}