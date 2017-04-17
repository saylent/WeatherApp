import { Injectable } from '@angular/core';
import { DataConstants } from '../constants/data.constants';
import { Http, Response, Headers, RequestOptions, Jsonp } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { RestService } from './rest.service';


///////////////////////////////////////////////////////////////////////////////////////////////
// Weather Service provider. Provides methods to get weather based on params
///////////////////////////////////////////////////////////////////////////////////////////////

@Injectable()
export class WeatherService {
	private apiKey: string;
	private api: string;

    constructor(private restService: RestService, private jsonp: Jsonp) {
    	this.apiKey = DataConstants.apiKey;
    	this.api = DataConstants.api;
    }

    //Request data for city as observable.
    //Can be subscribed on to
    getCityWeather(city, state): Observable<any> {
    	//Using jsonp as we get CORS if we use http
    	return this.jsonp.get(this.api+'/us/'+state+'/'+city+'.json?callback=JSONP_CALLBACK')
                    .map(this.restService.extractData)
                    .catch(this.restService.handleServerError)
    }

}
