import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Recipe, User, UserDTO } from 'src/app/domain/models';
import { RecipeDTO } from 'src/app/domain/models/dtos/recipe.dto';
import { RecipeService } from 'src/app/domain/services/recipe.service';

@Component({
  selector: 'app-view-recipe',
  templateUrl: './view-recipe.component.html',
  styleUrls: ['./view-recipe.component.scss']
})
export class ViewRecipeComponent implements OnInit {

  recipe: RecipeDTO = new RecipeDTO();

  constructor(private recipeService: RecipeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.getRecipe();
  }

  getRecipe(): void {
    this.recipeService.getRecipe(this.route.snapshot.params['id']).subscribe({
      next: (data) => {
        this.recipe = data;
        console.log(this.recipe);
      },
      error: (error) => {
        console.log(error);
      }
    });
  }

  viewUser(user: UserDTO): void {
    this.router.navigate(['/view-user/', user.userId]);
  }

}
