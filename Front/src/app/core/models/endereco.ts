import { Cidade } from "./cidade";


export class Endereco{

    idEndereco: number;
    cidade: Cidade;
    complemento: string;
    bairro: string;
    cep: string;
    logradouro: string;
}
