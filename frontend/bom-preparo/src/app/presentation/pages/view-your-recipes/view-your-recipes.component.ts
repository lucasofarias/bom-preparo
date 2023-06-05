import { Component, OnInit, ViewChild } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { UserDTO } from 'src/app/domain/models';
import { ListRecipeDTO } from 'src/app/domain/models/dtos/list-recipe.dto';
import { RecipeService } from 'src/app/domain/services/recipe.service';
import { ModalComponent } from '../../shared/modal/modal.component';
import { ModalConfig } from '../../shared/modal/modal.config';

@Component({
  selector: 'app-view-your-recipes',
  templateUrl: './view-your-recipes.component.html',
  styleUrls: ['./view-your-recipes.component.scss']
})
export class ViewYourRecipesComponent implements OnInit {

  user: UserDTO = new UserDTO();
  recipes: ListRecipeDTO[] = [];

  constructor(private recipeService: RecipeService) { }

  ngOnInit() {
    this.user = JSON.parse(localStorage.getItem('currentUser')!);

    this.listRecipesByUser();
  }

  async listRecipesByUser(): Promise<void> {
    this.recipes = await lastValueFrom(this.recipeService.listRecipesByUser(this.user.userId));

    if (this.recipes.length == 0) {
      this.modalConfig = {
        alert: () => true,
        message: 'Você não possui receitas',
        closeButtonLabel: 'Fechar',
      };

      this.openModal();
    }
  }

  @ViewChild('modal') private modal!: ModalComponent;

  public modalConfig!: ModalConfig;

  async openModal() {
    return await this.modal.open();
  }

  getConfirmationValue(event: any) { }

}
