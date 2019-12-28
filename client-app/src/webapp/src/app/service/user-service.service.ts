import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';

@Injectable()
export class UserService {

  private usersUrl: string;
  private _user: User;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:9608/rest/person';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }

  public add(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }

  public update(user: User) {
    return this.http.put<User>(this.usersUrl, user);
  }

  public delete(id: string) {
    return this.http.delete(this.usersUrl + '/' + id);
  }

  get user(): User {
    return this._user;
  }

  set user(value: User) {
    this._user = value;
  }
}
