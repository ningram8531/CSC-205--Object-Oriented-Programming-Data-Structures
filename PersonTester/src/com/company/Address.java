package com.company;

import com.sun.org.apache.xalan.internal.xsltc.dom.AdaptiveResultTreeImpl;

public class Address {
    // The street number and name
    private String street;

    // The city in which the address is located
    private String city;

    // The state in which the address is located
    private String state;

    // The zip code associated with the city and street
    private String zip;

    /**
     Constructor
     @param road Describes the street number and name.
     @param town Describes the city.
     @param st Describes the state.
     @param zipCode Describes the zip code.
     */

    public Address(String road, String town, String st,
                   String zipCode) {
        street = road;
        city = town;
        state = st;
        zip = zipCode;
    }

    public Address(Address copy) {
        this.street = copy.street;
        this.city = copy.city;
        this.state = copy.state;
        this.zip = copy.zip;
    }

    /**
     *
     * @param road
     * @param town
     * @param st
     * @param zipCode
     */
    public void setAddress(String road, String town, String st,
                           String zipCode) {
        street = road;
        city = town;
        state = st;
        zip = zipCode;

    }

    /**
     The toString method
     @return Information about the address.
     */

    public String toString()
    {
        return (street + ", " + city +
                ", " + state + " " + zip);
    }
}
