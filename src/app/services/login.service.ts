import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { JsonPipe } from '@angular/common';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  public loginStatusSubject=new Subject<boolean>();

  constructor(private http:HttpClient) { }

  //generate token

  public generateToken(loginData:any){

    return this.http.post(`${baseUrl}/generate-token`,loginData);

  }

  //this method provide u the current user details
  public getCurrentUser()
  {
    return this.http.get(`${baseUrl}/current-user`);
  }

  public loginUser(token)
  {
    localStorage.setItem("token",token);
   
    return true;
  }

  public isLoggedIn()
  {
    let tokenStr=localStorage.getItem('token');
    if(tokenStr == undefined || tokenStr==''||tokenStr==null)
      {
        return false;
      }
      else{
        return true;
      }
  }
  //logout:remove token from Local storage
  public logout()
  {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    return true;
  }

  //get token
  public getToken()
  {
    return localStorage.getItem("token");
  }
  // set user
  public setUser(user)
  {
    localStorage.setItem("user",JSON.stringify(user));
  }
  //get user
  public getUser()
  {
    let userStr= localStorage.getItem("user");
    if(userStr!=null)
      {
        return JSON.parse(userStr);
      }
    else{
      this.logout();
      return null;
    }
  }

  //get user role

  public getUserRole()
  {
    let user=this.getUser();
    return user.authorities[0].authority;
  }





}
