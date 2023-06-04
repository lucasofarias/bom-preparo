import { UserDTO } from "./user.dto";

export class SsoDTO {

  accessToken: string = "";
  currentUser: UserDTO = new UserDTO();

}
