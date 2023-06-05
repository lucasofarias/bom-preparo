import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { NgbOffcanvas, NgbOffcanvasConfig } from '@ng-bootstrap/ng-bootstrap';
import { AuthenticationService } from 'src/app/domain/services';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

  isUserLoggedIn: boolean = false;

  constructor(config: NgbOffcanvasConfig, private offcanvasService: NgbOffcanvas, private authenticationService: AuthenticationService, private router: Router) {
		config.position = 'end';
    config.panelClass = 'bp-offcanvas-panel';
		config.keyboard = false;
	}

  ngOnInit(): void {
    if (this.authenticationService.currentUser) {
      this.isUserLoggedIn = true;
    }
  }

	open(content: any) {
		this.offcanvasService.open(content);
	}

  login() {
    this.router.navigate(['/login']);
  }

  logout() {
    this.authenticationService.logout();
    location.reload();
  }

  isMenuCollapsed: boolean = true;
  isCollapsed: boolean = true;

}
