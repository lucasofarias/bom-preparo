import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { SignUpDTO } from "src/app/domain/models/dtos/sign-up.dto";

import endpoints from "../../core/sources/api.source"
import { environment } from "src/environments/environment";

@Injectable({ providedIn: 'root' })
export class UserRepository {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-type': 'application/json'
    })
  };

  constructor(private httpClient: HttpClient) { }

  signUp(signUpDTO: SignUpDTO): Observable<void> {
    return this.httpClient.post<void>(environment.apiUrl + endpoints.user.signUp, signUpDTO, this.httpOptions).pipe(
      map((data) => {
        return data;
      })
    );
  }

}
