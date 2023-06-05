import { Injectable } from '@angular/core';
import { Router, RouterStateSnapshot } from '@angular/router';

import { AuthenticationService } from '../../../domain/services';

@Injectable({ providedIn: 'root' })
export class AuthGuard {

  constructor(private router: Router, private authenticationService: AuthenticationService) { }

  canActivate(routerState: RouterStateSnapshot) {
    const currentUser = this.authenticationService.currentUser;

    if (currentUser) {
      return true;
    }

    this.router.navigate(['/login']);

    return false;
  }

}
