package com.tim.kata.vo;

import lombok.Data;

import java.util.List;

@Data
public class SmartUserVO {
    
    private String userId;
    private String userName;
    private String age;
    private List<String> classNames;
    private Boolean isMember;
    private Boolean ssn;
}