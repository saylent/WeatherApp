import { Component, OnInit } from '@angular/core';
import { FlexboxContants } from '../shared/constants/flexbox.constants';
import { DataConstants } from '../shared/constants/data.constants';
import { WeatherCardComponent } from '../shared/components/weather-card/weather-card.component';
import { WeatherTableComponent } from '../shared/components/weather-table/weather-table.component';
import { WeatherService } from '../shared/services/weather.service';
import { RestService } from '../shared/services/rest.service';
import { Observable } from 'rxjs/Observable';
import * as _ from "lodash";

///////////////////////////////////////////////////////////////////////////////////////////////
// Selector: The tag you place in the html. This tag is never replaced on the DOM.
// TemplateUrl: Your html code template to be included on the DOM.
// styleUrls: Style sheets associated with this component and only this component.
///////////////////////////////////////////////////////////////////////////////////////////////
@Component({
    selector: 'app-homeview',
    templateUrl: './homeview.component.html',
    styleUrls: ['./homeview.component.scss'],
    providers: [WeatherService, RestService]

})
export class HomeviewComponent implements OnInit {
    private flexboxDirections: Object;
    private cities: Object;
    private requestArray: Array<any>;
    private citiesToRender: Array<any>;
    private renderMode: string;
    constructor(private weatherService: WeatherService) {}

    //Initialized on once per view.
    //If you change route that has the same view, this will not be called again.
    ngOnInit() {
        this.flexboxDirections = FlexboxContants.directions;
        this.cities = DataConstants.cities;
        this.requestArray = [];
        this.citiesToRender = [];
        //Initial render mode is set to cards
        this.renderMode = 'table';

        for(let city in this.cities){
        	let sendCity = this.cities[city]['name'];
        	let sendState = this.cities[city]['state'];
        	//Create an array of all get request
        	this.requestArray.push(this.weatherService.getCityWeather(sendCity, sendState))
        }
        //To Store and sort before displaying
        let citiesToSort = [];
        //Make parallel request and get data all at once as an array
        Observable.forkJoin(this.requestArray).subscribe(data=> {
        	for(let d of data){
        		//Only storing what is required to display data
        		citiesToSort.push(d['current_observation']);
        	}
        	//Sort
        	citiesToSort = _.sortBy(citiesToSort, 'temp_c');
        	//Render
        	this.citiesToRender = citiesToSort;
        })


    }

    //Changes view from table to cards and vice versa
    changeView(mode) {
    	this.renderMode = mode;
    }

}
