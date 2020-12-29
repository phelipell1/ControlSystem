import { EnderecoModel } from "./endereco.model";

export class PessoaModel {

    idUsuario: number;
    nomeCompleto: String;
    cpf: String;
    sexo: number;
    estCivil: number;
    dataNascimento: Date;
    email: String;
    numCelular: String;
    numFixo: String;
    idEndereco: EnderecoModel;
}