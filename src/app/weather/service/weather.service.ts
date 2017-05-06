import {Injectable} from '@angular/core';
import {Http, Response} from "@angular/http";
import 'rxjs/Rx';
import {Observable} from 'rxjs/Observable';

import {Place} from "../model/place.model";
import {Weather} from "../model/weather.model";


@Injectable()
export class WeatherService {

  private saylentKeyCode: string = '5da5b931dde47dd9';

  private places: Place[] = [
    new Place('Austin', 'TX'),
    new Place('Denver', 'CO'),
    new Place('San Jose', 'CA'),
    new Place('Washington', 'DC'),
    new Place('Fayetteville', 'AR'),
    new Place('Seattle', 'WA'),
    new Place('Raleigh', 'NC'),
    new Place('Boston', 'MA'),
    new Place('Des Moines', 'IA'),
    new Place('Salt Lake City', 'UT')
  ];

  constructor(private http: Http) {
  }

  private getBaseUrl() {
    return 'http://api.wunderground.com/api/' + this.saylentKeyCode + '/conditions/q';
  }

  getPlacesWeather() {
    const weather: Weather[] = [];
    for (let i = 0; i < this.places.length; i++) {
      this.loadTemperature(weather, this.places[i]);
    }
    return weather;
  }

  private loadTemperature(weather: Weather[], place: Place) {
    let temp_f = '';
    let temp_c = '';

    this.accessWebServiceAPI(place)
      .subscribe(
        ((w: any) => {
          console.log(w);
          if (w) {
            temp_f = w.temp_f;
            temp_c = w.temp_c;
          }
          /** simulates network latency **/
          //setTimeout(function () {
            weather.push(new Weather(place, temp_f, temp_c));
          //}, 10000);

        })
        ,
        ((error) => {
          console.log(error);
        })
      );
  }

  accessWebServiceAPI(place: Place): Observable<any> {

    const city = place.city.replace(' ', '_');
    const state = place.state;
    let urlCity = this.getBaseUrl() + '/' + state + '/' + city + '.json';
    //urlCity = 'file.json';
    console.log(urlCity);
    return this.http.get(urlCity).map(
      (response: Response) => {
        const data = response.json();
        console.log(data.current_observation);
        return data.current_observation;
      }
    )
      .catch(
        (error: Response | any) => {
          return Observable.throw(error.json().error || 'Server error');
        }
      );
  }


}
