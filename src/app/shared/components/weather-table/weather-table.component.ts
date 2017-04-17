import { Component, OnInit, Input } from '@angular/core';
import { FlexboxContants } from '../../constants/flexbox.constants';


///////////////////////////////////////////////////////////////////////////////////////////////
// Selector: The tag you place in the html. This tag is never replaced on the DOM.
// TemplateUrl: Your html code template to be included on the DOM.
// styleUrls: Style sheets associated with this component and only this component.
///////////////////////////////////////////////////////////////////////////////////////////////
@Component({
    selector: 'app-weather-table',
    templateUrl: './weather-table.component.html',
    styleUrls: ['./weather-table.component.scss']
})
export class WeatherTableComponent implements OnInit {
	private flexboxDirections: Object;
	@Input('cities') cities: Object;
    constructor() {}
    //Initialized on once per view.
    //If you change route that has the same view, this will not be called again.
    ngOnInit() {
    	this.flexboxDirections = FlexboxContants.directions;
    }

}
