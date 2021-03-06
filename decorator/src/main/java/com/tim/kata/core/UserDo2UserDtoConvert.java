package com.tim.kata.core;

import com.tim.kata.dto.UserDTO;
import com.tim.kata.entity.UserDO;
import org.springframework.beans.BeanUtils;

import java.util.Arrays;

public class UserDo2UserDtoConvert extends DecoratorAdapter<UserDTO, UserDO> {

    public UserDo2UserDtoConvert() {
        super(null);
    }

    public UserDo2UserDtoConvert(Decorator decorator) {
        super(decorator);
    }

    @Override
    protected UserDTO doConvert(UserDO input) {
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(input, userDTO);
        return userDTO;
    }

    @Override
    public void appendExtras(UserDO input, UserDTO output) {
        output.setClassNames(Arrays.asList("一年一班", "二年四班", "三年二班"));
    }
}
