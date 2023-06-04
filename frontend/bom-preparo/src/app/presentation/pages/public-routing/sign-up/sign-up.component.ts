import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SignUpDTO } from 'src/app/domain/models/dtos/sign-up.dto';
import { AuthenticationService, UserService } from 'src/app/domain/services';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  signUpForm!: FormGroup;
  loading = false;
  submitted = false;
  error = '';

  constructor(
    private formBuilder: FormBuilder, private route: ActivatedRoute,
    private router: Router,
    private userService: UserService,
    private authenticationService: AuthenticationService
  ) {
    if (this.authenticationService.currentUser) {
      this.router.navigate(['/home']);
    }
  }

  ngOnInit(): void {
    this.signUpForm = this.formBuilder.group({
      fullName: ['', Validators.required],
      email: ['', Validators.required],
      username: ['', Validators.required],
      password: ['', Validators.required],
      passwordConfirmation: ['', Validators.required],
    });
  }

  get formField() { return this.signUpForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.signUpForm.invalid) {
      return;
    }

    this.error = '';
    this.loading = true;

    let signUpDTO: SignUpDTO = {
      fullName: this.formField['fullName'].value,
      email: this.formField['email'].value,
      username: this.formField['username'].value,
      password: this.formField['password'].value,
      passwordConfirmation: this.formField['passwordConfirmation'].value
    };

    this.userService.signUp(signUpDTO).subscribe({
      next: () => {
        this.router.navigate(['/login']);
      }
    });
  }

}
