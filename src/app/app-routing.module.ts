import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { SigninComponent } from './components/signin/signin.component';
import { RegisterComponent } from './components/register/register.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'signin' },
  { path: 'signin', component: SigninComponent },
  { path: 'register', component: RegisterComponent }
];

@NgModule({
  
  imports: [RouterModule.forRoot(routes),FormsModule, ReactiveFormsModule],
  exports: [RouterModule],

})
export class AppRoutingModule { }
