package com.manning.readinglist.enums;

/**
 * @Description 书状态枚举
 * @Author xiaguangyong
 * @Date 2019/10/24 20:53
 * @Param null
 * @Return
 */
public enum BookStatusEnum {

    /**
     * 未读
     */
    UN_READ("0", "unread"),

    /**
     * 在读
     */
    READING("1", "reading"),

    /**
    * 已读
     */
    READ("2", "read");

    private String code;
    private String value;

    BookStatusEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
