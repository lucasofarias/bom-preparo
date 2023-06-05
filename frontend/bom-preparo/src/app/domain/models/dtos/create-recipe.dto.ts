import { Category } from "../category.model";
import { Image } from "../image.model";
import { CategoryDTO } from "./category.dto";
import { ImageDTO } from "./image.dto";
import { RecipeIngredientDTO } from "./recipe-ingredient.dto";

export class CreateRecipeDTO {

  name: string = "";
  description: string = "";
  preparation: string = "";

  isPrivate: boolean = false;

  categories: CategoryDTO[] = [];
  recipeIngredients: RecipeIngredientDTO[] = [];
  image: Image = new Image();

  difficulty: string = "";

}
