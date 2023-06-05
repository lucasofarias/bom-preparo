import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ReactiveFormsModule } from '@angular/forms';

import { LoginComponent } from './presentation/pages/public-routing/login/login.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { JwtInterceptor, HttpErrorInterceptor } from './core/helpers/interceptors';
import { PublicRoutingComponent } from './presentation/pages/public-routing/public-routing.component';
import { HomeComponent } from './presentation/pages/public-routing/home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SignUpComponent } from './presentation/pages/public-routing/sign-up/sign-up.component';
import { NavbarComponent } from './presentation/shared/navbar/navbar.component';
import { ViewRecipeComponent } from './presentation/pages/public-routing/view-recipe/view-recipe.component';
import { ViewUserComponent } from './presentation/pages/public-routing/view-user/view-user.component';
import { ViewYourRecipesComponent } from './presentation/pages/view-your-recipes/view-your-recipes.component';
import { NewRecipeComponent } from './presentation/pages/new-recipe/new-recipe.component';
import { ExploreRecipesComponent } from './presentation/pages/public-routing/explore-recipes/explore-recipes.component';
import { AddIngredientsToPantryComponent } from './presentation/pages/add-ingredients-to-pantry/add-ingredients-to-pantry.component';
import { ViewPantryComponent } from './presentation/pages/view-pantry/view-pantry.component';
import { ModalComponent } from './presentation/shared/modal/modal.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PublicRoutingComponent,
    HomeComponent,
    SignUpComponent,
    NavbarComponent,
    ViewRecipeComponent,
    ViewUserComponent,
    ViewYourRecipesComponent,
    NewRecipeComponent,
    ExploreRecipesComponent,
    AddIngredientsToPantryComponent,
    ViewPantryComponent,
    ModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgbModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: HttpErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
