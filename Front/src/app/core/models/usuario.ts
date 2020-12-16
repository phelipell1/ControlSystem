import { identity } from "rxjs";
import { Loja } from "./loja";
import { Pessoa } from "./pessoa";

export class Usuario{
    idUsuario: number;
    login: string ;
    senha: string;
    pessoa: Pessoa;
    status: number;
    loja: Loja;
    dataCadastro: Date;   
}