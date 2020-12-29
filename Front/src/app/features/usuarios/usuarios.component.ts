import { Component, createPlatform, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, MaxLengthValidator, Validators } from '@angular/forms';
import { FormsValidator } from 'src/app/core/validators/formsValidator';

@Component({
  selector: 'app-usuarios',
  templateUrl: './usuarios.component.html',
  styleUrls: ['./usuarios.component.css']
})
export class UsuariosComponent implements OnInit {

  formUsuario: FormGroup;

  constructor(
    private fb: FormBuilder
  ) { }

  ngOnInit(): void {
    this.configFormUsuario();
  }

  configFormUsuario() {

    this.formUsuario = this.fb.group({
     nomeLogin: [null, [Validators.required, Validators.maxLength(20)]],
     password: [null, [Validators.required, Validators.minLength(5)]],
     status: [true],
     dateCadastro: [Date],
     cargo: [null, Validators.required],
    })
  }

  verificaValid(campo) {
    return !campo.valid && !campo.touched;
  }

  aplicaCSSError(campo){
    return {
      'has-error': this.verificaValid(campo),
      'has-feedback': this.verificaValid(campo)
    }
  }

}
