import { Component, OnInit } from '@angular/core';

import {WeatherService} from "./service/weather.service";
import {Weather} from "./model/weather.model";

@Component({
  selector: 'app-weather',
  templateUrl: './weather.component.html'
})
export class WeatherComponent implements OnInit {


  cities: Weather[];

  constructor(private weatherService: WeatherService) { }

  ngOnInit() {
    this.showWeather();
  }

  showWeather() {
    this.cities = this.weatherService.getPlacesWeather();
  }
}
