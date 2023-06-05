import { Ingredient } from "../ingredient.model";

export class RecipeIngredientDTO {

  ingredient: Ingredient = new Ingredient();
  quantity: string = "";
  measurementUnit: string = "";
  isOptional: boolean = false;

}
