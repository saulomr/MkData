import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

import { Cliente } from '../cliente';
import { ClientesService } from '../../clientes.service';

@Component({
  selector: 'app-clientes-form',
  templateUrl: './clientes-form.component.html',
  styleUrls: ['./clientes-form.component.css']
})
export class ClientesFormComponent implements OnInit {

  cliente: Cliente;
  success: boolean = false;
  id!: number;
  
  
        constructor( private service: ClientesService,
                     private router : Router,
                     private activatedRoute : ActivatedRoute){
          this.cliente = new Cliente();
          
        }

        ngOnInit(): void {
          
          let params  = this.activatedRoute.params
          params.subscribe( urlParams => {
            this.id = urlParams['id'];
            if(this.id){
              this.service
              .getClientesById(this.id)
              .subscribe( response => this.cliente = response,
                          errorResponse => this.cliente = new Cliente()
          )

            }
            
          })  
          
        }
        voltarParaListagem(){
          this.router.navigate(['/clientes-lista'])

        }

        onSubmit(){
          if(this.id){

            this.service
            .atualizar(this.cliente)
            .subscribe( response => {
              this.success = true;
              
            })

          }else {

          this.service
          .salvar( this.cliente)
          .subscribe( response => {
            this.success = true;
           

          })
        }
    }
  }

  


