package com.tim.kata;

import com.tim.kata.core.UserDo2UserDtoConvert;
import com.tim.kata.core.UserVo2SmartUserVoConvert;
import com.tim.kata.core.UserDto2UserVoConvert;
import com.tim.kata.entity.UserDO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tim.kata")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        abc(args);
    }


    public static void abc(String[] args) {
        UserDO userDO = new UserDO();
        userDO.setUserId("9527");
        userDO.setUserName("王老虎");
        userDO.setAge("29");
        userDO.setSex("男");

        // DO -> DTO 转换器
        UserDo2UserDtoConvert userDo2UserDtoConvert = new UserDo2UserDtoConvert();
        // DTO -> VO 转换器 (带配置化属性加载器)
        UserDto2UserVoConvert userDto2UserVoConvert = new UserDto2UserVoConvert(userDo2UserDtoConvert).loadMember(true).loadSecretKey(true);
        // VO -> VO2 转换器 (同级互转)
        UserVo2SmartUserVoConvert userVo2Convert = new UserVo2SmartUserVoConvert(new UserDto2UserVoConvert(userDo2UserDtoConvert));
        // 转换并打印
        System.out.println(userDto2UserVoConvert.convertTo(userDO));
        System.out.println(userVo2Convert.convertTo(userDO));

    }

}
