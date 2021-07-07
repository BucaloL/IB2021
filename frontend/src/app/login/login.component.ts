import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  public contactForm: FormGroup;

  constructor(private formBuilder: FormBuilder) 
  {

    this.contactForm = this.formBuilder.group({
      email: ['', Validators.email],
      password: ['', Validators.required],

    });

  }

  ngOnInit(): void {
  }

  onSubmit() {

  }

}
