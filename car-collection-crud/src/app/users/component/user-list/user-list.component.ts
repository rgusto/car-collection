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
}
