import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Factura } from 'src/app/Modelo/Factura';
import { ServiceService } from '../../Service/service.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  facturas!:Factura[];

  constructor(private service:ServiceService,private router:Router) { }

  ngOnInit(): void {
    this.service.getFacturas()
    .subscribe(data=>{
      this.facturas=data;
    })
  }

  Editar(factura:Factura){
    localStorage.setItem("id",factura.id.toString())
    this.router.navigate(["edit"]);
  }
  Delete(factura:Factura){
    this.service.deleteFactura(factura)
    .subscribe(data=>{
      this.facturas = this.facturas.filter(p=>p!==factura);

    })
  }

}
