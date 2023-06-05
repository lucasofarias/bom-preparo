import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Ingredient, Recipe } from 'src/app/domain/models';
import { RecipeDTO } from 'src/app/domain/models/dtos/recipe.dto';
import { RecipeService } from 'src/app/domain/services/recipe.service';
import { ModalComponent } from 'src/app/presentation/shared/modal/modal.component';
import { ModalConfig } from 'src/app/presentation/shared/modal/modal.config';

@Component({
  selector: 'app-explore-recipes',
  templateUrl: './explore-recipes.component.html',
  styleUrls: ['./explore-recipes.component.scss']
})
export class ExploreRecipesComponent implements OnInit {

  ingredientsForm!: FormGroup;
  ingredients: Ingredient[] = [];

  selectedIngredients: Ingredient[] = [];

  recipes: RecipeDTO[] = [];

  constructor(private recipeService: RecipeService, private formBuilder: FormBuilder, private httpClient: HttpClient) { }

  ngOnInit() {
    this.ingredientsForm = this.formBuilder.group({
      id: ['', Validators.required]
    });

    this.listIngredients();
  }

  listIngredients() {
    this.httpClient.get<Ingredient[]>('http://localhost:8080/ingredient/list-ingredients-by-current-user').subscribe({
      next: (data) => {
        this.ingredients = data;
        console.log(this.ingredients);
      }
    });
  }

  selectIngredient(event: any) {
    if (this.selectedIngredients.includes(event.target.value)) {
      let index = this.selectedIngredients.indexOf(event.target.value);

      this.selectedIngredients.splice(index, 1);
    }

    else {
      this.selectedIngredients.push(event.target.value);
    }

    console.log(this.selectedIngredients);
  }

  listRecipesByIngredients() {
    this.httpClient.get<RecipeDTO[]>('http://localhost:8080/recipe/list-recipes-by-ingredients?ingredientsId=' + this.selectedIngredients).subscribe({
      next: (data) => {
        this.recipes = data;
        console.log(this.recipes);
      },
      error: (error) => {
        if (this.selectedIngredients.length === 0) {
          this.modalConfig = {
            success: () => true,
            message: 'Por favor, selecione um ingrediente.',
            closeButtonLabel: 'Fechar'
          };

          this.openModal();
        }

        else {
          this.modalConfig = {
            error: () => true,
            message: error,
            closeButtonLabel: 'Fechar'
          };

          this.openModal();
        }
      }
    });
  }

  @ViewChild('modal') private modal!: ModalComponent;

  public modalConfig!: ModalConfig;

  async openModal() {
    return await this.modal.open();
  }

  getConfirmationValue(event: any) { }

}
