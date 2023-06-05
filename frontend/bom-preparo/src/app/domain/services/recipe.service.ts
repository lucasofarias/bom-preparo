import { Observable, map } from "rxjs";
import { RecipeRepository } from "src/app/data/repositories/recipe.repository";
import { CreateRecipeDTO } from "../models/dtos/create-recipe.dto";
import { Recipe } from "../models";
import { Injectable } from "@angular/core";
import { RecipeDTO } from "../models/dtos/recipe.dto";
import { ListRecipeDTO } from "../models/dtos/list-recipe.dto";

@Injectable({ providedIn: 'root' })
export class RecipeService {

  constructor(private recipeRepository: RecipeRepository) { }

  createRecipe(createRecipeDTO: CreateRecipeDTO): Observable<void> {
    return this.recipeRepository.createRecipe(createRecipeDTO).pipe(
      map((data) => {
        return data;
      })
    );
  }

  getRecipe(recipeId: number): Observable<RecipeDTO> {
    return this.recipeRepository.getRecipe(recipeId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipes(): Observable<Recipe[]> {
    return this.recipeRepository.listRecipes().pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByCategories(categoriesId: number[]): Observable<Recipe[]> {
    return this.recipeRepository.listRecipesByCategories(categoriesId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByCategory(categoryId: number): Observable<Recipe[]> {
    return this.recipeRepository.listRecipesByCategory(categoryId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByIngredients(ingredientsId: number[]): Observable<RecipeDTO[]> {
    return this.listRecipesByIngredients(ingredientsId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByUser(userId: number): Observable<ListRecipeDTO[]> {
    return this.recipeRepository.listRecipesByUser(userId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  updateRecipe(recipe: Recipe): Observable<void> {
    return this.recipeRepository.updateRecipe(recipe).pipe(
      map((data) => {
        return data;
      })
    );
  }

  deleteRecipe(recipeId: number): Observable<void> {
    return this.recipeRepository.deleteRecipe(recipeId).pipe(
      map((data) => {
        return data;
      })
    );
  }

}
