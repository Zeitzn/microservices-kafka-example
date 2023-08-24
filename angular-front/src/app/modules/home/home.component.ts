import { Component, OnInit } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { XmlDataResponse } from 'src/app/@core/models/response/XmlDataResponse';
import { XmlService } from 'src/app/@core/services/xml.service';
import { EMPTY } from 'rxjs';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  public xmlInfoList: XmlDataResponse[] = [];
  public searchValue: string | undefined = '';
  public size: number = 10;
  public page: number = 0;
  public sort: string = 'id,firstName';
  constructor(private xmlService: XmlService) {}

  ngOnInit(): void {
    this.findAll();
  }

  findAll() {
    this.xmlService
      .findAll(this.size, this.page, this.sort)
      .pipe(
        catchError((err) => {
          console.error(err);
          return EMPTY;
        })
      )
      .subscribe((response) => {
        this.xmlInfoList = response.content;
        console.log(this.xmlInfoList);
      });
  }

  search(event: any) {
    this.searchValue = event.target.value;
    console.log(this.searchValue)
    if(this.searchValue == undefined) {
      return;
    }
    this.xmlService
      .search(this.searchValue, this.size, this.page, this.sort)
      .pipe(
        catchError((err) => {
          console.error(err);
          return EMPTY;
        })
      )
      .subscribe((response) => {
        this.xmlInfoList = response.content;
        console.log(this.xmlInfoList);
      });
  }
}
