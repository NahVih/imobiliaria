import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { JwtClientService } from '../../jwt-client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup = null




  authRequest: any = {
    'username': String,
    'password': String
  }

  constructor(private jwtService: JwtClientService, private router: Router) { }

  ngOnInit(): void {
    this.createForm()
  }
  
  createForm() {
    this.loginForm = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }


  loginUser() {
    this.authRequest = this.loginForm.value
    let resp = this.jwtService.genereteToken(this.authRequest);
    resp.subscribe(resposta => {
      localStorage.setItem('token', resposta.toString())
      this.router.navigateByUrl('create-imovel')
    })
  }
}
