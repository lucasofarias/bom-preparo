import { ImageDTO } from "./image.dto";
import { ListCategoryDTO } from "./list-category.dto";
import { RecipeIngredientDTO } from "./recipe-ingredient.dto";
import { UserDTO } from "./user.dto";

export class RecipeDTO {

  recipeId: number = 0;
  name: string = "";
  description: string = "";
  preparation: string = "";

  isPrivate: boolean = false;
  difficulty: string = "";

  categories: ListCategoryDTO[] = [];
  ingredients: RecipeIngredientDTO[] = [];

  image: ImageDTO = new ImageDTO();
  creatorUser: UserDTO = new UserDTO();

}
