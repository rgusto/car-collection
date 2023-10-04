import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { User } from '../model/user';
import { UsersService } from '../service/users.service';

@Injectable({
  providedIn: 'root',
})
export class UserResolver implements Resolve<User> {
  constructor(private service: UsersService) {}

  resolve(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
  ): Observable<User> {
    if (route.params && route.params['id']) {
      return this.service.findById(route.params['id']);
    }
    return of({
      id: '',
      firstName: '',
      lastName: '',
      email: '',
      birthday: '',
      phone: '',
      login: '',
      password: '',
      createdAt: '',
      lastLoginAt: '',
    });
  }
}
