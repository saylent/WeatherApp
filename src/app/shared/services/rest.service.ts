import { Injectable } from '@angular/core';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
// Import RxJs required methods
import 'rxjs/add/operator/map';


///////////////////////////////////////////////////////////////////////////////////////////////
// REST Service provider. Provides methods to handle rest calls
///////////////////////////////////////////////////////////////////////////////////////////////
@Injectable()
export class RestService {

    constructor() {}

    //Automatically extracts and passes on data
    extractData(res: Response) {
        let blob = res.json();
        return blob || [];
    }

    //Automatically handles errors and logs it
    handleServerError(error: Response | any) {
        let errMsg: string;
        if (error instanceof Response) {
            const body = error.json() || 'Server Error: Unknown';
            const err = body.error || JSON.stringify(body);
            errMsg = `${error.status} - ${error.statusText || ''} ${err}`;
        } else {
            errMsg = error.message ? error.message : error.toString();
        }
        console.error(errMsg);
        return Observable.throw(errMsg);
    }

}
