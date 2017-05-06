import {Place} from "./place.model";

export class Weather {
  public place: Place;
  public temp_f: string;
  public temp_c: string;

  constructor(place: Place, temp_f: string, temp_c: string) {
    this.place = place;
    this.temp_f = temp_f;
    this.temp_c = temp_c;
  }

}
