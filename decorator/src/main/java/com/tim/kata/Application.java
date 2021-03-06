package com.tim.kata;

import com.tim.kata.core.UserDtoConvert;
import com.tim.kata.core.UserVo2Convert;
import com.tim.kata.core.UserVoConvert;
import com.tim.kata.entity.UserEntity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tim.kata")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        abc(args);
    }


    public static void abc(String[] args) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId("9527");
        userEntity.setUserName("王老虎");
        userEntity.setAge("29");
        userEntity.setSex("男");

        System.out.println(new UserVoConvert(new UserDtoConvert()).loadMember(true).loadSecretKey(true).convertTo(userEntity));
        System.out.println(new UserVo2Convert(new UserVoConvert(new UserDtoConvert())).convertTo(userEntity));

    }

}
