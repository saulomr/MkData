import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { ClientesRoutingModule } from './clientes-routing.module';
import { ClientesFormComponent } from './clientes-form/clientes-form.component';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { filterPipe } from './clientes-lista/filter.pipe';


@NgModule({
  declarations: [
    ClientesFormComponent,
    ClientesListaComponent,
    filterPipe
    
  ],
  imports: [
    CommonModule,
    ClientesRoutingModule,
    FormsModule
  ], exports: [
    ClientesFormComponent,
    ClientesListaComponent,
    filterPipe
  ]
})
export class ClientesModule { }
