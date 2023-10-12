package com.digital.utils;

import com.digital.models.Person;
import com.digital.models.Student;
import com.github.javafaker.Faker;

public class FakeDataProvider {

    static Faker faker = new Faker();



    public Person createFakeUser(){
        Person person = new Person();
        person.setFirstName(generateFakeFirstName());
        person.setLastName(generateFakeLastName());
        person.setLogin(generateLogin());
        person.setPassword(generatePassword());
        return person;
    }


    public static String generateLogin(){
        return faker.name().username();
    }
    public static String generatePassword(){
        return faker.internet().password(5,10);
    }


    public Student createFakeStudent(){
        Student student = new Student();
        student.setFirstName(generateFakeFirstName());
        student.setLastName(generateFakeLastName());
        student.setEmail(generateFakeEmail());
        student.setMobileNumber(generateMobilePhone());
        student.setCurrentAddress(generateFakeUserCurrentAddress());
        return student;
    }




    public static String generateFakeFirstName(){
        return faker.name().firstName();


  } public static String generateFakeLastName(){
        return faker.name().lastName();
    }


    public static String generateFakeEmail(){
        return faker.internet().emailAddress();
    }

    public static String generateMobilePhone(){
        return faker.regexify("[0-9]{10}") ;
    }



    public static String generateFakeUserCurrentAddress(){
        return faker.address().fullAddress();
    }
    public static String generateFakeUserPermanentAddress(){
        return faker.address().streetName() + " " + faker.address().streetAddressNumber();
    }

}
