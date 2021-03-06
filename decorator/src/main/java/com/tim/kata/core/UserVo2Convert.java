package com.tim.kata.core;

import com.tim.kata.dto.UserDTO;
import com.tim.kata.vo.UserVO;
import com.tim.kata.vo.UserVO2;
import org.springframework.beans.BeanUtils;

public class UserVo2Convert extends DecoratorAdapter<UserVO2, UserVO> {


    public UserVo2Convert() {
        super(null);
    }

    public UserVo2Convert(Decorator decorator) {
        super(decorator);
    }

    @Override
    protected UserVO2 doConvert(UserVO input) {
        UserVO2 userVo = new UserVO2();
        BeanUtils.copyProperties(input, userVo);
        return userVo;
    }

    @Override
    public void appendExtras(UserVO input, UserVO2 output) {
        output.setSsn(false);
    }


}
