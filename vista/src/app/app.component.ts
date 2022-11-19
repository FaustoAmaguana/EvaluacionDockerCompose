import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'vista';

  ngOnInit(): void {
    this.Nuevo();
  }

  constructor(private router:Router){}
  Nuevo(){
    this.router.navigate(["add"]);
  }
  Listar(){
    this.router.navigate(["listar"]);
  }

}
