/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author filip
 */
import java.util.*;

public class Person {

    private String name;
    private Set numbers = new HashSet<String>();
    private String street;
    private String city;

    public Person(String name, String number) {
        this.name = name;
        this.numbers.add(number);
    }

    public Person(String name) {
        this.name = name;
    }

    public void addNumber(String number) {
        this.numbers.add(number);
    }

    public void printNumbers() {
        for (Object number : numbers) {
            System.out.println(" " + number);
        }
    }

    public String getNumbersExtraSpace() {
        String string = "";
        for (Object number : numbers) {
            string += "  " + number + "\n";
        }
        return string;
    }

    public boolean checkNumber(String number) {
        return this.numbers.contains(number);
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    public String getAddress() {
        return "  address: " + this.street + " " + this.city;
    }

    @Override
    public String toString() {
        String string = "";
        if (this.city == null) {
            string += "  address unknown\n";
        } else {
            string += getAddress() + "\n";
        }
        if (numbers.isEmpty()) {
            string += "  phone number not found\n";
        } else {
            string += "  phone numbers: \n";
            string += getNumbersExtraSpace();
        }
        return string;
    }

    public String getName() {
        return name;
    }
    
    

}
