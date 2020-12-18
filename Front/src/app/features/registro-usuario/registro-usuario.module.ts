import { RegistroUsuarioComponent } from './registro-usuario.component';
import { AppCommonModule } from './../../app.common.module';
import { RegistroUsuarioRouting } from './registro-usuario.routing';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';



@NgModule({
  declarations: [RegistroUsuarioComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    RegistroUsuarioRouting
  ]
})
export class RegistroUsuarioModule { }
