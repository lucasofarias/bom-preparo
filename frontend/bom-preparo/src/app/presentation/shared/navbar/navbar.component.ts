import { Component } from '@angular/core';
import { NgbOffcanvas, NgbOffcanvasConfig } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent {

  constructor(config: NgbOffcanvasConfig, private offcanvasService: NgbOffcanvas) {
		config.position = 'end';
		config.keyboard = false;
	}

	open(content: any) {
		this.offcanvasService.open(content);
	}

  isMenuCollapsed: boolean = true;
  isCollapsed: boolean = true;

}
