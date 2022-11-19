import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Factura } from 'src/app/Modelo/Factura';
import { ServiceService } from 'src/app/Service/service.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  modelFactura = new Factura();

  constructor(private service:ServiceService,private router:Router) { }

  ngOnInit(): void {
  }

  guardar(factura:Factura){
    try {debugger;
      this.service.createFactura(factura)
      .subscribe(data=>{
        alert("Se guardo la factura");
        this.router.navigate(["listar"]);
      })
    } catch (error) {
      alert("NO se guardo la factura" + error);
    }

  }

}
