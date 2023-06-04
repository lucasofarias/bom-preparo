import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PublicRoutingComponent } from './presentation/pages/public-routing/public-routing.component';
import { LoginComponent } from './presentation/pages/public-routing/login/login.component';
import { HomeComponent } from './presentation/pages/public-routing/home/home.component';
import { AuthGuard } from './core/helpers/guards/auth.guard';

const routes: Routes = [
  {
    path: '', component: PublicRoutingComponent, children: [
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginComponent },
    ]
  },

  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
