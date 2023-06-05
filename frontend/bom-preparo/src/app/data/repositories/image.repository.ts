import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Image } from "src/app/domain/models";

import endpoints from "../../core/sources/api.source"
import { environment } from "src/environments/environment";
import { Observable, map } from "rxjs";

@Injectable({ providedIn: 'root' })
export class ImageRepository {

  constructor(private httpClient: HttpClient) { }

  viewImage(imageId: number): Observable<any> {
    return this.httpClient.get<any>(environment.apiUrl + endpoints.image.viewImage + "?imageId=" + imageId).pipe(
      map((data) => {
        return data;
      })
    );
  }

}
