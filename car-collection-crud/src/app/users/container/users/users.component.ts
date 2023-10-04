import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { catchError, Observable, of } from 'rxjs';
import { MatSnackBar } from '@angular/material/snack-bar';

import { ErrorDialogComponent } from '../../../../shared/components/error-dialog/error-dialog.component';
import { User } from '../../model/user';
import { UsersService } from '../../service/users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss'],
})
export class UsersComponent implements OnInit {
  users$: Observable<User[]> | null = null;

  constructor(
    private usersService: UsersService,
    public dialog: MatDialog,
    private router: Router,
    private route: ActivatedRoute,
    private snackBar: MatSnackBar
  ) {
    this.refresh();
  }

  ngOnInit(): void {}

  refresh() {
    this.users$ = this.usersService.findAll().pipe(
      catchError((error) => {
        this.onError('Erro loading users');
        return of([]);
      })
    );
  }

  onError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg,
    });
  }

  onAdd() {
    this.router.navigate(['new'], { relativeTo: this.route });
  }

  onEdit(user: User) {
    this.router.navigate(['edit', user.id], { relativeTo: this.route });
  }

  onDelete(user: User) {
    this.usersService.delete(user.id).subscribe({
      next: () => {
        this.refresh();
        this.snackBar.open('User deleted', 'X', {
          duration: 3000,
          verticalPosition: 'top',
          horizontalPosition: 'center',
        });
      },
      error: () => this.onError('Error deleting user'),
    });
  }
}
