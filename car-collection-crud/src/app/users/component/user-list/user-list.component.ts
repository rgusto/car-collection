import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { User } from '../../model/user';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss'],
})
export class UserListComponent implements OnInit {
  @Input() users: User[] = [];
  @Output() add = new EventEmitter(false);
  @Output() edit = new EventEmitter(false);
  @Output() delete = new EventEmitter(false);

  readonly displayedColumns = [
    'firstName',
    'lastName',
    'email',
    'login',
    'actions',
  ];

  constructor() {}

  ngOnInit(): void {}

  onAdd() {
    this.add.emit(true);
  }

  onEdit(user: User) {
    this.edit.emit(user);
  }

  onDelete(user: User) {
    this.delete.emit(user);
  }
}
