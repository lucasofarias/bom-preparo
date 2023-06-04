import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import endpoints from '../../core/sources/api.source';

import { environment } from '../../../environments/environment';
import { SsoDTO, UserDTO } from '../models';

@Injectable({ providedIn: 'root' })
export class AuthenticationService {

  private currentUserSubject: BehaviorSubject<UserDTO | null>;
  public currentUserObservable: Observable<UserDTO | null>;

  private accessTokenSubject: BehaviorSubject<string | null>;
  public accessTokenObservable: Observable<string | null>;

  constructor(private router: Router, private httpClient: HttpClient) {
    this.currentUserSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('currentUser')!));
    this.currentUserObservable = this.currentUserSubject.asObservable();

    this.accessTokenSubject = new BehaviorSubject(JSON.parse(localStorage.getItem('accessToken')!));
    this.accessTokenObservable = this.accessTokenSubject.asObservable();
  }

  public get currentUser(): UserDTO | null {
    return this.currentUserSubject.value;
  }

  public get accessToken(): string | null {
    return this.accessTokenSubject.value;
  }

  login(username: string, password: string): Observable<SsoDTO> {
    return this.httpClient.post<SsoDTO>(environment.apiUrl + endpoints.user.login, { username, password }).pipe(
      map(ssoDTO => {
        localStorage.setItem('currentUser', JSON.stringify(ssoDTO.currentUser));
        this.currentUserSubject.next(ssoDTO.currentUser);

        localStorage.setItem('accessToken', JSON.stringify(ssoDTO.accessToken));
        this.accessTokenSubject.next(ssoDTO.accessToken);

        console.log(ssoDTO);
        return ssoDTO;
      })
    );
  }

  logout(): void {
    localStorage.removeItem('currentUser');
    this.currentUserSubject.next(null);

    localStorage.removeItem('accessToken');
    this.accessTokenSubject.next(null);

    this.router.navigate(['/login']);
  }

}
