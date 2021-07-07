import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-records',
  templateUrl: './records.component.html',
  styleUrls: ['./records.component.scss']
})
export class RecordsComponent implements OnInit {

  displayedColumns: string[] = ['id', 'opis','datum', 'lekar', 'pacijent'];
  records = [{
    "id": "1",
    "opis" : "opis pregleda" ,
    "datum" : "05-05-2005" ,
    "lekar" : "Tamara",
    "pacijent" : "Ana",

  }]

  constructor() { }

  ngOnInit(): void {
  }

}
