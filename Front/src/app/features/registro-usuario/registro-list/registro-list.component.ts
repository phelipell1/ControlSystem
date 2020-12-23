import { UsuariosService } from './../../../core/services/usuarios.service';
import { Usuario } from './../../../core/models/usuario.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-registro-list',
  templateUrl: './registro-list.component.html',
  styleUrls: ['./registro-list.component.css']
})
export class RegistroListComponent implements OnInit {

  userModel: Usuario;

  constructor(
    private userService: UsuariosService

  ) {

    this.userService.getAllUsers().subscribe(data => {
      this.userModel = data;

      console.log("List")
      console.log(this.userModel);
    })
    console.log("List")
   }

  ngOnInit(): void {
  }

}
