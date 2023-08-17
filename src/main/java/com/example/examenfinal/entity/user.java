package com.example.examenfinal.entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

public class user {
    private int id;
    private String user_name;
    private String user_firstname;
    private String email;
    private String password;
    private String mobile;
    private String skills;

    
}
