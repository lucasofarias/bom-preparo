import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { CreateRecipeDTO } from "src/app/domain/models/dtos/create-recipe.dto";

import endpoints from "../../core/sources/api.source"
import { environment } from "src/environments/environment";
import { Recipe } from "src/app/domain/models";
import { RecipeDTO } from "src/app/domain/models/dtos/recipe.dto";

@Injectable({ providedIn: 'root' })
export class RecipeRepository {

  httpOptions = {
    headers: new HttpHeaders({
      'Content-type': 'application/json'
    })
  };

  constructor(private httpClient: HttpClient) { }

  createRecipe(createRecipeDTO: CreateRecipeDTO): Observable<void> {
    return this.httpClient.post<void>(environment.apiUrl + endpoints.recipe.createRecipe, createRecipeDTO, this.httpOptions).pipe(
      map((data) => {
        return data;
      })
    );
  }

  getRecipe(recipeId: number): Observable<RecipeDTO> {
    return this.httpClient.get<RecipeDTO>(environment.apiUrl + endpoints.recipe.getRecipe + "?recipeId=" + recipeId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipes(): Observable<Recipe[]> {
    return this.httpClient.get<Recipe[]>(environment.apiUrl + endpoints.recipe.listRecipes).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByCategories(categoriesId: number[]): Observable<Recipe[]> {
    return this.httpClient.get<Recipe[]>(environment.apiUrl + endpoints.recipe.listRecipesByCategories + "?categoriesId=" + categoriesId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByCategory(categoryId: number): Observable<Recipe[]> {
    return this.httpClient.get<Recipe[]>(environment.apiUrl + endpoints.recipe.listRecipesByCategory + "?categoryId=" + categoryId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByIngredients(ingredientsId: number[]): Observable<Recipe[]> {
    return this.httpClient.get<Recipe[]>(environment.apiUrl + endpoints.recipe.listRecipesByIngredients + "?ingredients=" + ingredientsId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  listRecipesByUser(userId: number): Observable<Recipe[]> {
    return this.httpClient.get<Recipe[]>(environment.apiUrl + endpoints.recipe.listRecipesByUser + "?userId=" + userId).pipe(
      map((data) => {
        return data;
      })
    );
  }

  updateRecipe(recipe: Recipe): Observable<void> {
    return this.httpClient.put<void>(environment.apiUrl + endpoints.recipe.updateRecipe, recipe, this.httpOptions).pipe(
      map((data) => {
        return data;
      })
    );
  }

  deleteRecipe(recipeId: number): Observable<void> {
    return this.httpClient.delete<void>(environment.apiUrl + endpoints.recipe.deleteRecipe + "?recipeId=" + recipeId).pipe(
      map((data) => {
        return data;
      })
    );
  }

}
