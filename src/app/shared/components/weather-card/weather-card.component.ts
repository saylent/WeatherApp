import { Component, OnInit, Input } from '@angular/core';
import { FlexboxContants } from '../../constants/flexbox.constants';


///////////////////////////////////////////////////////////////////////////////////////////////
// Selector: The tag you place in the html. This tag is never replaced on the DOM.
// TemplateUrl: Your html code template to be included on the DOM.
// styleUrls: Style sheets associated with this component and only this component.
///////////////////////////////////////////////////////////////////////////////////////////////
@Component({
    selector: 'app-weather-card',
    templateUrl: './weather-card.component.html',
    styleUrls: ['./weather-card.component.scss']
})
export class WeatherCardComponent implements OnInit {
	@Input('city') city: Object;
	private flexboxDirections: Object;
    
    constructor() {}

    //Initialized on once per view.
    //If you change route that has the same view, this will not be called again.
    ngOnInit() {
        this.flexboxDirections = FlexboxContants.directions;
    }

}
