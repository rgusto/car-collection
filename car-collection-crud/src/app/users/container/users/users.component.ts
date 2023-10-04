import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';

import { ErrorDialogComponent } from '../../../../shared/components/error-dialog/error-dialog.component';
import { User } from '../../model/user';
import { UsersService } from '../../service/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent implements OnInit {
  users$: Observable<User[]>;


  constructor(
    private usersService: UsersService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute
    ) {

    this.users$ = this.usersService.findAll().pipe(
      catchError((error) => {
        this.onError('Error loading users')
        return of([])
      })
    );

  }

  ngOnInit(): void {}

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route})
  }


}
