import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserFormComponent } from './container/user-form/user-form.component';
import { UsersComponent } from './container/users/users.component';


const routes: Routes = [
  { path: '', component: UsersComponent},
  { path: 'new', component: UserFormComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class UsersRoutingModule { }
