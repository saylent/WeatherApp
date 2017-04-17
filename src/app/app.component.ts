import { Component, ViewEncapsulation, OnInit } from '@angular/core';
import { FlexboxContants } from './shared/constants/flexbox.constants';

///////////////////////////////////////////////////////////////////////////////////////////////
// Root file or base file
// Selector: The tag you place in the html. This tag is never replaced on the DOM.
// TemplateUrl: Your html code template to be included on the DOM.
// styleUrls: Style sheets associated with this component and only this component.
///////////////////////////////////////////////////////////////////////////////////////////////
@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss'],
    encapsulation: ViewEncapsulation.None // Do not use shadow-root or emulate the DOM.
})
export class AppComponent implements OnInit{
	private flexboxDirections: Object;

	constructor() {
	}
	
	//Initialized on once per view.
    //If you change route that has the same view, this will not be called again.
	ngOnInit(){
		this.flexboxDirections = FlexboxContants.directions;
	}
}
