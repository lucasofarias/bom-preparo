import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublicRoutingComponent } from './presentation/pages/public-routing/public-routing.component';
import { LoginComponent } from './presentation/pages/public-routing/login/login.component';
import { HomeComponent } from './presentation/pages/public-routing/home/home.component';
import { AuthGuard } from './core/helpers/guards/auth.guard';
import { SignUpComponent } from './presentation/pages/public-routing/sign-up/sign-up.component';
import { ViewRecipeComponent } from './presentation/pages/public-routing/view-recipe/view-recipe.component';
import { ViewUserComponent } from './presentation/pages/public-routing/view-user/view-user.component';
import { ViewYourRecipesComponent } from './presentation/pages/view-your-recipes/view-your-recipes.component';
import { NewRecipeComponent } from './presentation/pages/new-recipe/new-recipe.component';
import { ExploreRecipesComponent } from './presentation/pages/public-routing/explore-recipes/explore-recipes.component';
import { AddIngredientsToPantryComponent } from './presentation/pages/add-ingredients-to-pantry/add-ingredients-to-pantry.component';
import { ViewPantryComponent } from './presentation/pages/view-pantry/view-pantry.component';

const routes: Routes = [
  {
    path: '', component: PublicRoutingComponent, children: [
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginComponent },
      { path: 'sign-up', component: SignUpComponent },
      { path: 'home', component: HomeComponent },
      { path: 'view-recipe/:id', component: ViewRecipeComponent },
      { path: 'view-user/:id', component: ViewUserComponent },
      { path: 'explore-recipes', component: ExploreRecipesComponent },
      { path: 'add-ingredients-to-pantry', component: AddIngredientsToPantryComponent },
    ]
  },

  { path: 'view-your-recipes', component: ViewYourRecipesComponent, canActivate: [AuthGuard] },
  { path: 'new-recipe', component: NewRecipeComponent, canActivate: [AuthGuard] },
  { path: 'view-pantry', component: ViewPantryComponent, canActivate: [AuthGuard] },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
