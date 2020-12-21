package com.tim.kata.enums;

/**
 * 状态枚举
 */
public enum StateEnum {
    /**
     * 状态等级
     */
    VS("VS"),
    V1("V1"),
    V2("V2"),
    V3("V3"),
    VE("VE"),
    ;

    private String code;

    StateEnum(String code) {
        this.code = code;
    }
}
