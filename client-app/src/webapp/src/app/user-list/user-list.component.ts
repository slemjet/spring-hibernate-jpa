import {Component, OnInit} from '@angular/core';
import {User} from '../model/user';
import {UserService} from '../service/user-service.service';
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(
    private userService: UserService,
    private router: Router) {
  }

  ngOnInit() {
    this.userService.findAll().subscribe(data => {
      this.users = data;
    });
  }

  editSelected(user: User) {
    console.log('Editing', user);
    this.userService.user = user;
    this.router.navigate(['/edituser']);
  }

  deleteSelected(user: User) {
    console.log('Deleting', user);
    this.userService.delete(user.id).subscribe(value => {
      this.userService.findAll().subscribe(allUsers => this.users = allUsers)
    })
  }

  selected(user: User) {
    console.log('Selected', user);
  }
}
