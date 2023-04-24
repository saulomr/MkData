import { Pipe, PipeTransform } from "@angular/core";
import { Cliente } from "../cliente";

@Pipe ({
    name: 'filterClientes'
})
export class filterPipe implements PipeTransform{
    transform(clientes : Cliente[], filterText : string) {
        if (clientes.length === 0 || filterText === ''){
            return clientes;
        } else {
            return clientes.filter((cliente) => { 
                return cliente.nome!.toLowerCase() === filterText.toLowerCase()})
        }
    }
}