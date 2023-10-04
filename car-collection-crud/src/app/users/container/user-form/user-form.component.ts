import { Location } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UsersService } from '../../service/users.service';



@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss'],
})
export class UserFormComponent implements OnInit {
  form = this.formBuilder.group({
    firstName: new FormControl('', { nonNullable: true }),
    lastName: new FormControl('', { nonNullable: true }),
    email: new FormControl('', { nonNullable: true }),
    birthday: new FormControl('', { nonNullable: true }),
    phone: new FormControl('', { nonNullable: true }),
    login: new FormControl('', { nonNullable: true }),
    password: new FormControl('', { nonNullable: true })
  });

  constructor(
    private formBuilder: FormBuilder,
    private service: UsersService,
    private snackBar: MatSnackBar,
    private location: Location
  ) {
    //this.
  }

  ngOnInit(): void {}

  onSubmit() {
    this.service.save(this.form.value).subscribe({
      next: () => {
        this.showMessage('User saved');
        this.onCancel();
      },
      error: () => {
        this.showMessage('Error saving user');
      },
    });
  }

  onCancel() {
    this.location.back();
  }

  private showMessage(message: string) {
    this.snackBar.open(message, '', { duration: 5000 });
  }
}
