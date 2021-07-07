import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  public contactForm: FormGroup;

  constructor(private formBuilder: FormBuilder) {

    this.contactForm = this.formBuilder.group({
      email: ['', Validators.email],
      password: ['', Validators.required],
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
      adresa: ['', Validators.required],
      lbo: ['', Validators.required],
    });
   
  }

  ngOnInit(): void {
  }

  onSubmit() {

  }

}
