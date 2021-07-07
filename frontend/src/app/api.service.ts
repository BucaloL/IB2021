import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  config = 'http://localhost:808/api'

  constructor(private http: HttpClient) { }

  register(data: any) {
    return this.http.post(this.config + '/korisnici', data)
  }

  update(data: any) {
    return this.http.put(this.config  + '/korisnici', data)
  }

  get(data:any) {
    return this.http.get(this.config + '/korisnici', data)
  }

  getId(id:any) {
    return this.http.get(this.config + '/korisnici' + id)
  }

  updatePregled(data: any) {
    return this.http.put(this.config  + '/pregledi', data)
  }

  getPregled(data: any) {
    return this.http.get(this.config  + '/pregledi', data)
  }

  getPregledId(id: any) {
    return this.http.get(this.config  + '/pregledi' + id)
  }

  updateKlinickiCentar(data: any) {
    return this.http.put(this.config  + '/klinicki-centar', data)
  }

  getKlinickiCentarId(id: any) {
    return this.http.get(this.config  + '/klinicki-centar' + id)
  }

  getZdravstveniKarton(data:any){
    return this.http.get(this.config + '/zdravstveni-karton', data)
  }

  getRoleId(id:any){
    return this.http.get(this.config + '/role' + id)
  }

  getRole(data:any){
    return this.http.get(this.config + '/role', data)
  }

}
