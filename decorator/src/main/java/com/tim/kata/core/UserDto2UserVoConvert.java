package com.tim.kata.core;

import com.tim.kata.FieldLoader;
import com.tim.kata.dto.UserDTO;
import com.tim.kata.vo.UserVO;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

@Accessors(fluent = true)
@Setter
public class UserDto2UserVoConvert extends DecoratorAdapter<UserVO, UserDTO> {

    private boolean loadMember;
    private boolean loadSecretKey;

    @Autowired
    private FieldLoader fieldLoader;

    public UserDto2UserVoConvert() {
        super(null);
    }

    public UserDto2UserVoConvert(Decorator decorator) {
        super(decorator);

    }

    @Override
    protected UserVO doConvert(UserDTO input) {
        UserVO userVo = new UserVO();
        BeanUtils.copyProperties(input, userVo);
        return userVo;
    }

    @Override
    public void appendExtras(UserDTO input, UserVO output) {
        if(loadMember) {
            output.setIsMember(true);
        }
        if(loadSecretKey) {
            output.setSecretKey(fieldLoader.getSecret());
        }
    }



}
