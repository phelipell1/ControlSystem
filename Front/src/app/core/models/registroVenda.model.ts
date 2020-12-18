import { ListaProdutoVenda } from './listaProdutoVenda.model';
import { Usuario } from './usuario.model';
export class RegistroVenda {

  idRegistro: number;
  listaProduto: ListaProdutoVenda;
  dataCompra: Date;
  totalCompra: DoubleRange;
  tipoPagamento: number;
  idUsuario: Usuario


}
