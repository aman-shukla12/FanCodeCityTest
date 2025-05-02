package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    //"address": {
    //      "street": "Kulas Light",
    //      "suite": "Apt. 556",
    //      "city": "Gwenborough",
    //      "zipcode": "92998-3874",
    //      "geo": {
    //        "lat": "-37.3159",
    //        "lng": "81.1496"
    //      }

}
