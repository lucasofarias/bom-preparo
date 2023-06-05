import { HttpClient } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { Ingredient } from 'src/app/domain/models';
import { ModalComponent } from '../../shared/modal/modal.component';
import { ModalConfig } from '../../shared/modal/modal.config';

@Component({
  selector: 'app-view-pantry',
  templateUrl: './view-pantry.component.html',
  styleUrls: ['./view-pantry.component.scss']
})
export class ViewPantryComponent implements OnInit {

  ingredients: Ingredient[] = [];

  constructor(private httpClient: HttpClient) { }

  ngOnInit(): void {
    this.listIngredientsByCurrentUser();
  }

  listIngredientsByCurrentUser(): void {
    this.httpClient.get<Ingredient[]>('http://localhost:8080/ingredient/list-ingredients-by-current-user').subscribe({
      next: (data) => {
        this.ingredients = data;
      }
    });
  }

  selectedIngredient!: Ingredient;

  removeIngredientFromPantry(ingredient: Ingredient): void {
    this.selectedIngredient = ingredient;

    this.modalConfig = {
      alert: () => true,
      message: 'Tem certeza de que quer remover o ingrediente da despensa?.',
      dismissButtonLabel: 'Cancelar',
      confirmButtonLabel: 'Confirmar'
    };

    this.openModal();
  }

  @ViewChild('modal') private modal!: ModalComponent;

  public modalConfig!: ModalConfig;

  async openModal() {
    return await this.modal.open();
  }

  getConfirmationValue(event: any) {
    if (event == 'Confirm click') {
      this.httpClient.delete<void>('http://localhost:8080/ingredient/remove-ingredient-from-pantry?ingredientId=' + this.selectedIngredient?.id).subscribe({
        next: () => {
          let index = this.ingredients.indexOf(this.selectedIngredient!);
          this.ingredients.splice(index, 1);

          this.modalConfig = {
            success: () => true,
            message: 'O ingrediente foi removido.',
            closeButtonLabel: 'Fechar'
          };

          this.openModal();
        }
      });
    }
  }

}
