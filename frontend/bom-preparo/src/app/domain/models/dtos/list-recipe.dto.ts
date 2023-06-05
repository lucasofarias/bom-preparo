import { Image } from "../image.model";
import { ImageDTO } from "./image.dto";
import { UserDTO } from "./user.dto";

export class ListRecipeDTO {

  recipeId: number = 0;
  name: string = "";
  description: string = "";
  preparation: string = "";

  isPrivate: boolean = false;
  difficulty: string = "";

  image: ImageDTO = new ImageDTO();
  creatorUser: UserDTO = new UserDTO();

}
