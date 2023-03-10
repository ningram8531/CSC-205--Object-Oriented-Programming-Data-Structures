package com.company;
/**
 *  Title:  Person Class
 *  Desc:   Models a very bland person
 * @author  Nick Ingram
 */
import com.company.Address;

import java.util.Calendar;


public class Person {
    private String name;
    private int birthYear;
    private Address address;  // This is aggregation.  Including one object as
    //    an instance variable of another.

    // Constructors
    public Person() {
        this.name = "Unknown";
        this.birthYear = 0;
        address = null;
    }

    public Person(String name, int birthYear, Address address) {
        this.name = name;
        this.birthYear = birthYear;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // This one worries me.
    public Address getAddress() {
        // We need to return a copy of the address
        // not the original.
        return new Address(this.address);  // Create a copy
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getBirthYear() {
        return birthYear;
    }

    /**
     * returns the name of the person
     * @return
     */
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    // toString
    @Override
    public String toString() {
        return "      Name: " + this.name +
                "\nBirth Year: " + this.birthYear +
                "\nAge:        " + calculateAge() +
                "\nAddress:    " + address.toString();  // utilizing the toString of address
    }

    // equals
    public boolean equals(Person other) {
        return this.birthYear == other.birthYear;
    }

    // Let's change calculateAge so it is a "Helper Method"
    // i.e. it is private to the class and can't be called
    // by the outside world.
    private int calculateAge() {
        Calendar today = Calendar.getInstance();
        return today.getWeekYear() - this.birthYear;
    }
}

