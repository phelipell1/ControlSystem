import { Produto } from "./produto"
import { Usuario } from "./usuario";

export class Estoque{

    idEstoque: number;
    produto: Produto = new Produto();
    quantidade: number;
    dataLancamento: Date;
    usuario: Usuario = new Usuario();

}
