import { constructor } from "assert";
import { Pessoa } from "./pessoa";
import { Usuario } from "./usuario";

export class Cliente {
  constructor(idCliente: number, usuario: Usuario) {
    this.idCliente = idCliente;
    this.usuario = usuario;
  }

  idCliente: number;
  usuario: Usuario;
}
