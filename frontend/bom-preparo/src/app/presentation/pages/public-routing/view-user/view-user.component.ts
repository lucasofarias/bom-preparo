import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { UserDTO } from 'src/app/domain/models';
import { ListRecipeDTO } from 'src/app/domain/models/dtos/list-recipe.dto';
import { UserService } from 'src/app/domain/services';
import { RecipeService } from 'src/app/domain/services/recipe.service';

@Component({
  selector: 'app-view-user',
  templateUrl: './view-user.component.html',
  styleUrls: ['./view-user.component.scss']
})
export class ViewUserComponent implements OnInit {

  user: UserDTO = new UserDTO();
  recipes: ListRecipeDTO[] = [];

  constructor(private userService: UserService, private recipeService: RecipeService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.loadData();
  }

  async getUser(): Promise<void> {
    this.user = await lastValueFrom(this.userService.getUser(this.route.snapshot.params['id']));
  }

  async listRecipesByUser(): Promise<void> {
    this.recipes = await lastValueFrom(this.recipeService.listRecipesByUser(this.route.snapshot.params['id']));
  }

  async loadData() {
    await this.getUser();
    await this.listRecipesByUser();
  }

}
