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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    PublicRoutingComponent,
    HomeComponent,
    SignUpComponent,
    NavbarComponent,
    ViewRecipeComponent
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
