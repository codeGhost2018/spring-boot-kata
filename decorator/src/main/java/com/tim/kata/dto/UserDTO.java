package com.tim.kata.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    
    private String userId;
    private String userName;
    private String age;
    private String sex;
    private List<String> classNames;
}