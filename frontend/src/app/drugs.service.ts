import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DrugsService {
  
  

  constructor(private http: HttpClient) { }

  drugList = [];
  
  getDrugs(moa : string, generic_name : string, brand_name :string): Observable<any>{
    const url : string = "http://localhost:8080/drug";
    let searchParams = new HttpParams();

    if (moa != ""){
      searchParams = searchParams.set("moa", moa);
    }
    if (generic_name != ""){
      searchParams = searchParams.set("generic_name", generic_name);
    }
    if (brand_name != ""){
      searchParams = searchParams.set("brand_name", brand_name);
    }

    return this.http.get(url, 
      {
  
        params: searchParams

      });
  }
}
