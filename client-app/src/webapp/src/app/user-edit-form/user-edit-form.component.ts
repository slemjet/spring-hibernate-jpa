import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../service/user-service.service';
import {User} from '../model/user';

@Component({
  selector: 'app-add-user-form',
  templateUrl: './user-edit-form.component.html',
  styleUrls: ['./user-edit-form.component.css']
})
export class UserEditFormComponent implements OnInit{

  user: User;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
  }

  onSubmit() {
    this.userService.update(this.user).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/users']);
  }

  ngOnInit(): void {
    this.user = this.userService.user;
  }
}
