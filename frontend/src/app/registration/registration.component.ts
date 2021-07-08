import { TOUCH_BUFFER_MS } from '@angular/cdk/a11y/input-modality/input-modality-detector';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ApiService } from '../api.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss']
})
export class RegistrationComponent implements OnInit {

  public contactForm: FormGroup;

  constructor(private formBuilder: FormBuilder, private api: ApiService) {

    this.contactForm = this.formBuilder.group({
      email: ['', Validators.email],
      password: ['', Validators.required],
      password2: ['', Validators.required],
      ime: ['', Validators.required],
      prezime: ['', Validators.required],
      adresa: ['', Validators.required],
      lbo: ['', Validators.required],
    });
   
  }

  ngOnInit(): void {
  }

  onSubmit() {

    this.api.register({
      email: this.contactForm.controls['email'].value,
      ime: this.contactForm.controls['ime'].value,
      prezime:this.contactForm.controls['prezime'].value,
      lozinka:this.contactForm.controls['password'].value,
      ponovljenaLozinka:this.contactForm.controls['password2'].value,
      adresa:this.contactForm.controls['adresa'].value,
      lbo:this.contactForm.controls['lbo'].value,

    }).subscribe((data: any) => {
      console.log(data)
    })

  }

}
