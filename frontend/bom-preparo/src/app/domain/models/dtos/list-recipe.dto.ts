import { Image } from "../image.model";
import { UserDTO } from "./user.dto";

export class ListRecipeDTO {

  recipeId: number = 0;
  name: string = "";
  description: string = "";
  preparation: string = "";

  isPrivate: boolean = false;
  difficulty: string = "";

  image: Image = new Image();
  creatorUser: UserDTO = new UserDTO();

}
