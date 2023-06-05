import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { Category } from "src/app/domain/models/category.model";

import endpoints from "../../core/sources/api.source"
import { environment } from "src/environments/environment";
import { CategoryDTO } from "src/app/domain/models/dtos/category.dto";

@Injectable({ providedIn: 'root' })
export class CategoryRepository {

  constructor(private httpClient: HttpClient) { }

  listCategories(): Observable<CategoryDTO[]> {
    return this.httpClient.get<CategoryDTO[]>(environment.apiUrl + endpoints.category.listCategories).pipe(
      map((data) => {
        return data;
      })
    );
  }

}
