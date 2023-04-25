import { Pipe, PipeTransform } from "@angular/core";
import { Cliente } from "../cliente";

@Pipe ({
    name: 'filterClientes'
})

export class filterPipe implements PipeTransform{
    transform(clientes : Cliente[], filterText : string) : Cliente[] {
        if (!clientes || !filterText){
            return clientes;
        } 
            return clientes.filter(cliente => 
            
                cliente.nome.toLowerCase().indexOf (filterText.toLocaleLowerCase()) !==-1);
                
        }
    
    }


