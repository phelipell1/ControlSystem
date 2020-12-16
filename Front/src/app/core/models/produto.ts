
import { Modelo } from "./modelo";
import { Tamanho } from "./tamanho";

export class Produto{
    idProduto: number;
    descricao: string;
    modelo: Modelo = new Modelo();
    tamanho: Tamanho = new Tamanho();
    medida: number;
    precoVenda: number;
    precoCusto: number;

}
