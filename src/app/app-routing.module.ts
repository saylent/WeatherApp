import { NgModule } from '@angular/core';
import { Routes, RouterModule, PreloadAllModules } from '@angular/router';

import {WeatherComponent} from "./weather/weather.component";
import {WeatherService} from "./weather/service/weather.service";

const appRoutes: Routes = [
  { path: '', component: WeatherComponent }

];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes, {preloadingStrategy: PreloadAllModules})
  ],
  exports: [RouterModule],
  providers: [
    WeatherService
  ]
})
export class AppRoutingModule {

}
