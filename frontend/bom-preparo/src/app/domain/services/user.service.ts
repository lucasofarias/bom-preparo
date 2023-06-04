import { Injectable } from "@angular/core";
import { UserRepository } from "src/app/data/repositories/user.repository";
import { SignUpDTO } from "../models/dtos/sign-up.dto";
import { Observable, map } from "rxjs";

@Injectable({ providedIn: 'root' })
export class UserService {

  constructor(private userRepository: UserRepository) { }

  signUp(signUpDTO: SignUpDTO): Observable<void> {
    return this.userRepository.signUp(signUpDTO).pipe(
      map((data) => {
        return data;
      })
    );
  }

}
