export class PageableModel<T> {
  content!: T;
  totalPages: number = 0;
  totalElements: number = 0;
  last: boolean = true;
  size: number = 0;
  number: number = 0;
  numberOfElements: number = 0;
  first: boolean = true;
  empty: boolean = true;
}
