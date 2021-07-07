import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  displayedColumns: string[] = ['id', 'email','ime', 'prezime', 'lozinka','uloga','adresa', 'pregled','lbo'];
  users = [{
    "id": "0",
    "email" : "ana@gmail.com" ,
    "ime" : "Ana" ,
    "prezime" : "Anic",
    "lozinka" : "tajna",
    "uloga" : "LEKAR",
    "adresa" : "adresa1",
    "pregled" : "01-01-2020",
    "lbo" : "123456"
  }]

  constructor() { }

  ngOnInit(): void {
  }

}
