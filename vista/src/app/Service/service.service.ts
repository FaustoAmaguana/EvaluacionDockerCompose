import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Factura } from '../Modelo/Factura';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  constructor(private http:HttpClient) { }

  getFacturas(){
    return this.http.get<Factura[]>(`${environment.apiUrl}/factura/`);
  }
  createFactura(factura:Factura){
    return this.http.post<Factura>(`${environment.apiUrl}/factura/`, factura);
  }

  getFacturaId(id:number){
    return this.http.get<Factura>(`${environment.apiUrl}/factura/${id}`)
  }

  updateFactura(factura:Factura){
    return this.http.put<Factura>(`${environment.apiUrl}/factura/${factura.id}`,factura)
  }

  deleteFactura(factura:Factura){
    return this.http.delete<Factura>(`${environment.apiUrl}/factura/${factura.id}`);
  }

}
