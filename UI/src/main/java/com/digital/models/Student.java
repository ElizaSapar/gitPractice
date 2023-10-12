package com.digital.models;


import lombok.*;

//@NoArgsConstructor - пустой конструктор без аргументов
//@AllArgsConstructor
//@Getter
//@Setter
//@Builder
//@ToString
//@EqualsAndHashCode
//or

@Data
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String currentAddress;


    public Student() {
    }
}
