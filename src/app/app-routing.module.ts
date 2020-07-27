import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './seguranca/login/login/login.component';
import { AuthGuard } from './seguranca/guard/auth.guard';
import { ImovelCreateComponent } from './imovel/imovel-create/imovel-create.component';
import { ImovelListComponent } from './imovel/imovel-list/imovel-list.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent},
  { path: 'create-imovel', component: ImovelCreateComponent, canActivate: [AuthGuard]},
  { path: 'list-imovel', component: ImovelListComponent },
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
