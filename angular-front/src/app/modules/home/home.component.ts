import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { catchError } from 'rxjs/operators';
import { XmlDataResponse } from 'src/app/@core/models/response/XmlDataResponse';
import { XmlService } from 'src/app/@core/services/xml.service';
import { EMPTY } from 'rxjs';
import { PageableModel } from 'src/app/@core/models/pageable-model';
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {
  public xmlInfoList: PageableModel<XmlDataResponse[]> | undefined = undefined;

  public displayedColumns: string[] = [
    'firstName',
    'lastName',
    'city',
    'country',
    'firstName2',
    'lastName2',
    'email',
    'age',
    'random',
    'randomFloat',
    'bool',
    'date',
    'regEx',
    'enumValue',
    'eltList',
    'createdDate',
    'modifiedDate',
  ];
  dataSource: XmlDataResponse[] = [];

  public searchValue: string | undefined = '';
  public size: number = 10;
  public page: number = 0;
  public sort: string = 'id,firstName';
  constructor(private xmlService: XmlService) {}

  ngOnInit(): void {
    this.findAll();
  }

  public findAll() {
    this.xmlService
      .findAll(this.size, this.page, this.sort)
      .pipe(
        catchError((err) => {
          console.error(err);
          return EMPTY;
        })
      )
      .subscribe((response) => {
        this.xmlInfoList = response;
        this.dataSource = response.content;
      });
  }

  public search(event?: any) {

    if(event != null) this.searchValue = event.target.value;

    if (this.searchValue == undefined) return;

    this.xmlService
      .search(this.searchValue, this.size, this.page, this.sort)
      .pipe(
        catchError((err) => {
          console.error(err);
          return EMPTY;
        })
      )
      .subscribe((response) => {
        this.xmlInfoList = response;
        this.dataSource = response.content;
      });
  }

  public showMoreResults(event: any) {
    this.size = event.pageSize;
    this.page = event.pageIndex;
    if(this.searchValue != undefined && this.searchValue != '') {
      this.search()
    } else {
      this.findAll();
    }

  }
}

