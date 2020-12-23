import { RegistroListComponent } from './registro-list/registro-list.component';
import { RegistroUsuarioComponent } from './registro-usuario.component';
import { Routes, RouterModule } from '@angular/router';
import { Injectable } from '@angular/core';
import { NgModule } from '@angular/core';

const routes: Routes =[
  {
    path: '',
    component: RegistroListComponent
  },
  {
    path:'registro',
    component: RegistroUsuarioComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class RegistroUsuarioRouting {}
