import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router) { }
  username: string;
  password: string;

  ngOnInit(): void {
  }
  login(): void {
    if (this.username == null || this.username == "") {
      alert("UserName can't be empty");
      false;
    }
    else if (this.password == null || this.password == "") {
      alert("Password can't be empty");
      false;
    }
    else if (this.username == 'admin' && this.password == 'admin') {

      this.router.navigate(["home"]);
      true;
    }
    else {
      alert("Invalid credentials");
    }

  }

}
