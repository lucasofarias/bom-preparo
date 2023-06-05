import { HttpClient } from '@angular/common/http';
import { Component, PipeTransform, ViewChild } from '@angular/core';
import { AsyncPipe, DecimalPipe, NgFor } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Observable, lastValueFrom, map, startWith } from 'rxjs';
import { Ingredient } from 'src/app/domain/models';
import { ModalConfig } from '../../shared/modal/modal.config';
import { ModalComponent } from '../../shared/modal/modal.component';

@Component({
  selector: 'app-add-ingredients-to-pantry',
  templateUrl: './add-ingredients-to-pantry.component.html',
  styleUrls: ['./add-ingredients-to-pantry.component.scss'],
  providers: [DecimalPipe]
})
export class AddIngredientsToPantryComponent {

  ingredientsList: Ingredient[] = [];

  ingredients$: Observable<Ingredient[]>;
	filter = new FormControl('', { nonNullable: true });

  constructor(private httpClient: HttpClient, pipe: DecimalPipe) {
    this.listIngredients();

    this.ingredients$ = this.filter.valueChanges.pipe(
      startWith(''),
      map((text) => this.search(text, pipe)),
    );
  }

  ngOnInit() { }

  search(text: string, pipe: PipeTransform): Ingredient[] {
    return this.ingredientsList.filter((ingredient) => {
      const term = text.toLowerCase();
      return (
        ingredient.name.toLowerCase().includes(term)
      );
    });
  }

  async listIngredients() {
    this.ingredientsList = await lastValueFrom(this.httpClient.get<Ingredient[]>('http://localhost:8080/ingredient/list-ingredients'));
  }

  async loadData() {
    await this.listIngredients();


  }

  addIngredientToPantry(ingredient: Ingredient) {
    this.httpClient.post<void>('http://localhost:8080/ingredient/add-ingredient-to-pantry', ingredient.id).subscribe({
      next: () => {
        this.modalConfig = {
          success: () => true,
          message: 'O ingrediente foi adicionado à sua despensa.',
          closeButtonLabel: 'Fechar'
        };

        this.openModal();
      },

      error: (error) => {
        this.modalConfig = {
          error: () => true,
          message: error,
          closeButtonLabel: 'Fechar'
        };

        this.openModal();
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
