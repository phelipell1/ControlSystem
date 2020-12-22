import { Cliente } from "./cliente";
import { ItemPedido } from "./itemPedido";
import { Usuario } from "./usuario";

export class Pedido{
    idPedido: number;
    dataPedido: Date;
    usuario: Usuario;
    cliente: Cliente;
    itemPedido: ItemPedido;
    valorTotal:number;
    statusPedido:number;
}