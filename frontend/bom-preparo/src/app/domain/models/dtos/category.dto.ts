import { ListRecipeDTO } from "./list-recipe.dto";

export class CategoryDTO {

  categoryId: number = 0;
  name: string = "";
  recipes: ListRecipeDTO[] = [];

}
