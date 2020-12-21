package com.tim.kata.enums;

/**
 * 事件枚举
 */
public enum EventEnum {
    /**
     * 时间等级
     */
    START("START"),
    UP_LEVEL("UP_LEVEL"),
    RESTART("RESTART"),
    FINAL("FINAL");

    private String code;

    EventEnum(String code) {
        this.code = code;
    }
}
