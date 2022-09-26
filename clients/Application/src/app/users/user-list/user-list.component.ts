/*
infrateam and application team
 */

import { Component, OnInit } from '@angular/core';
import { UserService } from 'angular-auth-oidc-client/lib/userData/user-service';
import { Observable, of } from 'rxjs';
import { User } from '../models/user';
import { UsersService } from '../users.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styles: [
  ]
})
export class UserListComponent implements OnInit {
  users: Observable<User[]>;

  constructor(private userSvc: UsersService) {
    this.users = userSvc.fetch();
  }

  ngOnInit(): void {
  }

}

