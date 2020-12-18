import { RegistroUsuarioComponent } from './registro-usuario.component';
import { Routes, RouterModule } from '@angular/router';
import { Injectable } from '@angular/core';
import { NgModule } from '@angular/core';

const routes: Routes =[
  {
    path:'',
    component: RegistroUsuarioComponent
  }
]

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class RegistroUsuarioRouting {}
