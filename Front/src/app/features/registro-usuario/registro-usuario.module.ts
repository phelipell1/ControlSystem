import { ToastModule } from 'primeng/toast';
import { RegistroUsuarioComponent } from './registro-usuario.component';
import { AppCommonModule } from './../../app.common.module';
import { RegistroUsuarioRouting } from './registro-usuario.routing';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RegistroListComponent } from './registro-list/registro-list.component';
import { ToolbarModule } from 'primeng';



@NgModule({
  declarations: [RegistroUsuarioComponent, RegistroListComponent],
  imports: [
    CommonModule,
    AppCommonModule,
    RegistroUsuarioRouting,
    ToolbarModule
  ]
})
export class RegistroUsuarioModule { }
