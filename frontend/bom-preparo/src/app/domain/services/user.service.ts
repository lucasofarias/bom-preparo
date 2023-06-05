import { Injectable } from "@angular/core";
import { UserRepository } from "src/app/data/repositories/user.repository";
import { SignUpDTO } from "../models/dtos/sign-up.dto";
import { Observable, map } from "rxjs";
import { UserDTO } from "../models";

@Injectable({ providedIn: 'root' })
export class UserService {

  constructor(private userRepository: UserRepository) { }

  getUser(userId: number): Observable<UserDTO> {
    return this.userRepository.getUser(userId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  signUp(signUpDTO: SignUpDTO): Observable<void> {
    return this.userRepository.signUp(signUpDTO).pipe(
      map((data) => {
        return data;
      })
    );
  }

}
