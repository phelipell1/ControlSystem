import { Loja } from './loja.model';
import { Usuario } from './usuario.model';
export class Produto {

  idProduto: number;
  codProduto: String;
  descricaoProduto: String
  quantidade: number;
  nomeProduto: String;
  dateCadastro: Date;
  idUsuario: Usuario;
  idLoja: Loja;

}
