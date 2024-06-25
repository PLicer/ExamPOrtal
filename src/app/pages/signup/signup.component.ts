import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2'


@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor(private userservice:UserService,private snack:MatSnackBar) { }

  public user={
    username:'',
     password:'',
    firstname:'',
    lastname:'',
    email:'',
    phone:'',
  }

  ngOnInit(): void {
  }

  formSubmit()
  {
   
  
      if (!this.user.username) {
        this.snack.open('Username is required!', '', { duration: 3000 });
        return;
      }
      if (!this.user.password) {
        this.snack.open('Password is required!', '', { duration: 3000 });
        return;
      }
      if (!this.user.firstname) {
        this.snack.open('First name is required!', '', { duration: 3000 });
        return;
      }
      if (!this.user.lastname) {
        this.snack.open('Last name is required!', '', { duration: 3000 });
        return;
      }
      if (!this.user.email) {
        this.snack.open('Email is required!', '', { duration: 3000 });
        return;
      }
      if (!this.user.phone) {
        this.snack.open('Phone number is required!', '', { duration: 3000 });
        return;
      }

    this.userservice.addUser(this.user).subscribe(
      (data:any)=>{
        console.log(data);
        Swal.fire("success","User id is"+data.id+" ","success");
      },
      (error)=>{
        // console.log(error);
        //alert('something went wrong');
        this.snack.open('something went wrong','',{
          duration:3000,
        })
      }
    )

  }

}
