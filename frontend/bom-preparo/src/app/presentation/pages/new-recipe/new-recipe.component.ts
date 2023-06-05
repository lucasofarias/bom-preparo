import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoryDTO } from 'src/app/domain/models/dtos/category.dto';
import { CreateRecipeDTO } from 'src/app/domain/models/dtos/create-recipe.dto';
import { CategoryService } from 'src/app/domain/services/category.service';
import { RecipeService } from 'src/app/domain/services/recipe.service';

@Component({
  selector: 'app-new-recipe',
  templateUrl: './new-recipe.component.html',
  styleUrls: ['./new-recipe.component.scss']
})
export class NewRecipeComponent {

  recipeForm!: FormGroup;
  ingredientForm!: FormGroup;

  loading = false;
  submitted = false;
  error = '';

  categories: CategoryDTO[] = [];
  selectedCategories: CategoryDTO[] = [];

  constructor(private formBuilder: FormBuilder, private router: Router, private recipeService: RecipeService, private categoryService: CategoryService) {

  }

  get ingredients() {
    return this.ingredientForm.get('ingredients') as FormArray;
  }

  ngOnInit(): void {
    this.recipeForm = this.formBuilder.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      preparation: ['', Validators.required],
      isPrivate: ['', Validators.required],
      categories: ['', Validators.required],
      image: ['', Validators.required],
      difficulty: ['', Validators.required]
    });

    this.ingredientForm = this.formBuilder.group({
      ingredients: this.formBuilder.array([])
    });

    this.listCategories();
  }

  addIngredient() {
    const newIngredient = this.formBuilder.group({
      ingredientName: ['', Validators.required],
      ingredientQuantity: ['', Validators.required],
      ingredientMeasurementUnit: ['', Validators.required],
      ingredientIsOptional: ['', Validators.required],
    });

    this.ingredients.push(newIngredient);
  }

  removeIngredient(index: number) {
    this.ingredients.removeAt(index);
  }

  listCategories() {
    this.categoryService.listCategories().subscribe({
      next: (data) => {
        this.categories = data;
      }
    });
  }

  selectCategory(event: any) {
    if (this.selectedCategories.includes(event.target.value)) {
      let index = this.selectedCategories.indexOf(event.target.value);

      this.selectedCategories.splice(index, 1);
    }

    else {
      this.selectedCategories.push(event.target.value);
    }

    console.log(this.selectedCategories);
  }

  getIngredientControl(index: number): FormGroup {
    return this.ingredients.at(index) as FormGroup;
  }

  get formField() { return this.recipeForm.controls; }
  get formField2() { return this.ingredientForm.controls; }

  onSubmit() {
    this.submitted = true;

    if (this.recipeForm.invalid) {
      return;
    }

    this.error = '';
    this.loading = true;

    let createRecipeObj: any = {
      name: this.formField['name'].value,
      description: this.formField['description'].value,
      preparation: this.formField['preparation'].value,
      isPrivate: this.formField['isPrivate'].value,
      difficulty: this.formField['difficulty'].value,
      categories: this.selectedCategories,
      image: this.formField['image'].value
    };

    console.log(createRecipeObj);
    console.log(this.formField2['ingredientName'].value);
  }

}
