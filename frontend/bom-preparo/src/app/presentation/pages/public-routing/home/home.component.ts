import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { Recipe } from 'src/app/domain/models';
import { Category } from 'src/app/domain/models/category.model';
import { CategoryDTO } from 'src/app/domain/models/dtos/category.dto';
import { CategoryService } from 'src/app/domain/services/category.service';
import { ImageService } from 'src/app/domain/services/image.service';
import { RecipeService } from 'src/app/domain/services/recipe.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  constructor(private categoryService: CategoryService, private router: Router) { }

  imageUrl: string = "";
  image: any;

  async ngOnInit() {
    await this.listCategories();
  }

  categories: CategoryDTO[] = [];
  recipes: Recipe[] = [];

  async listCategories(): Promise<void> {
    this.categories = await lastValueFrom(this.categoryService.listCategories());
  }

  viewRecipe(recipe: Recipe) {
    this.router.navigate(['/view-recipe/', recipe.id]);
  }

}
