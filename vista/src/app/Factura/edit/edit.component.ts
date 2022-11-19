import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Factura } from 'src/app/Modelo/Factura';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  modelFactura: Factura=new Factura();
  constructor(private service:ServiceService,private router:Router) { }

  ngOnInit(): void {
    this.Editar();
  }

  Editar(){
    let id=localStorage.getItem("id");
    this.service.getFacturaId(+id!)
    .subscribe(data=>{
      this.modelFactura=data;
    })

  }

  Actualizar(factura:Factura){
    this.service.updateFactura(factura)
    .subscribe(data=>{
      this.modelFactura=data
      alert("Se actualizo la factura")
      this.router.navigate(["listar"]);
    })
  }

}
