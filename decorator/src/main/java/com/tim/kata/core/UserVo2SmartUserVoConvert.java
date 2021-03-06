package com.tim.kata.core;

import com.tim.kata.vo.UserVO;
import com.tim.kata.vo.SmartUserVO;
import org.springframework.beans.BeanUtils;

public class UserVo2SmartUserVoConvert extends DecoratorAdapter<SmartUserVO, UserVO> {


    public UserVo2SmartUserVoConvert() {
        super(null);
    }

    public UserVo2SmartUserVoConvert(Decorator decorator) {
        super(decorator);
    }

    @Override
    protected SmartUserVO doConvert(UserVO input) {
        SmartUserVO userVo = new SmartUserVO();
        BeanUtils.copyProperties(input, userVo);
        return userVo;
    }

    @Override
    public void appendExtras(UserVO input, SmartUserVO output) {
        output.setSsn(false);
    }


}
