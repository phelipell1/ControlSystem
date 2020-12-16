import { Estoque } from "./estoque";

export class ItemPedido{
    idItemPedido: number;
    estoque: Estoque;
    quantidade: number;
    desconto: number;
    acrescimo: number;
    totalSoma: number;
    }