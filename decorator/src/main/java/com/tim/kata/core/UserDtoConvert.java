package com.tim.kata.core;

import com.tim.kata.dto.UserDTO;
import com.tim.kata.entity.UserEntity;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;

public class UserDtoConvert extends DecoratorAdapter<UserDTO, UserEntity> {

    public UserDtoConvert() {
        super(null);
    }

    public UserDtoConvert(Decorator decorator) {
        super(decorator);
    }

    @Override
    protected UserDTO doConvert(UserEntity input) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(input, userDTO);
        return userDTO;
    }

    @Override
    public void appendExtras(UserEntity input, UserDTO output) {
        output.setClassNames(Arrays.asList("一年一班", "二年四班", "三年二班"));
    }
}
