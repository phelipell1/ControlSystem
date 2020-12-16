import { identity } from 'rxjs';
import { Endereco } from './endereco';

export class Pessoa{
    idPessoa:number;
    nome: string;
    cpf: string;
    dataNascimento: Date;
    estadoCivil: any;
    sexo: any;
    endereco: Endereco;
    email: string;
    telefone: string;
}
