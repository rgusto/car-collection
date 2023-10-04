import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { delay, first, tap } from 'rxjs';

import { User } from '../model/user';

@Injectable({
  providedIn: 'root',
})
export class UsersService {
  private readonly API = 'api/users';

  constructor(private httpClient: HttpClient) {}

  findAll() {
    return this.httpClient.get<User[]>(this.API).pipe(
      first()
      //delay(1000),
      //tap(users => console.log(users))
    );
  }

  save(record: Partial<User>) {
    return this.httpClient.post<User>(this.API, record).pipe(first());
  }
}
