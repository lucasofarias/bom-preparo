import { Category } from "../category.model";
import { Image } from "../image.model";
import { RecipeIngredientDTO } from "./recipe-ingredient.dto";

export class CreateRecipeDTO {

  name: string = "";
  description: string = "";
  preparation: string = "";

  isPrivate: boolean = false;

  categories: Category[] = [];
  recipeIngredients: RecipeIngredientDTO[] = [];
  images: Image[] = [];

  difficulty: string = "";

}
