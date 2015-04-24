package edu.uw;

import java.util.*;

// JavaBeans Specification <-- clients/UI/components
//Enterprise JavaBeans Specification <-- companies that have too much money

public class Person {
    // firstName is just a reference
    private String firstName;
    private String lastName;

    // Constructor
    Public Person(String firstName, String lastName) {
        // firstName = firstName won't work
        // To reference the outside scope:
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // age is not; it's primitive
    private int age;

    // Getter
    public String getFirstName() {
        return firstName;
    }
    // Setter
    public void setFirstName(String value) {
        firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        lastName = value;
    }
}

public class Main {

    public static void main(String[] args) {
        // Arrays are fixed length
        String[] names = { "Ted", "Charlotte", "Michael", "Matthew"};

        // List better from the java.util.*; library
        List<String> names = { "Ted", "Charlotte", "Michael", "Matthew"};

        System.out.println("Hello world" + names[0]);

        Object o = null;
        o.toString(); // <-- null pointer exception

        Person a = new Person();
        a.setFirstName("Ted");

        Person b = a;
        b.setFirstName("Fred");

        Person c = new Person();
        c.setFirstName("Ted");

        a.getFirstName(); // Returns Fred

        if(a == b){}      // True; an identity comparison
        if(a.equals(b)){} // True; an equality comparson
        // We should typically override the equals object

        if(a == c){}      // False
        if(a.equals(c)){} // True

        // A and B point to the same thing; they're aliasing objects.
        // If we write an equals method, we should alwrite a hashCode method.
        // But only when we're specifically putting this into hash table or set
    }
}