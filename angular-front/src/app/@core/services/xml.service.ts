import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { PageableModel } from '../models/pageable-model';
import { XmlDataResponse } from '../models/response/XmlDataResponse';

@Injectable({
  providedIn: 'root',
})
export class XmlService {
  private apiUrl = `${environment.host}xml`
  constructor(private http: HttpClient) {}


  public findAll(size: number, page: number, sort: string): Observable<PageableModel<XmlDataResponse[]>> {
    return this.http.get<PageableModel<XmlDataResponse[]>>(`${this.apiUrl}?size=${size}&page=${page}&sort=${sort}`);
  }

  public search(value: string, size: number, page: number, sort: string): Observable<PageableModel<XmlDataResponse[]>> {
    return this.http.get<PageableModel<XmlDataResponse[]>>(`${this.apiUrl}/search?value=${value}&size=${size}&page=${page}&sort=${sort}`);
  }
}
