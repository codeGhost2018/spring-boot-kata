package com.tim.kata.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserVO {
    
    private String userId;
    private String userName;
    private String age;
    private String sex;
    private List<String> classNames;
    private Boolean isMember;
    private String secretKey;
}