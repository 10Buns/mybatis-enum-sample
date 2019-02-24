package com.summer.sample.constant;

/**
 * All rights Reserved, Designed By mapletowngames.com
 *
 * @Version V1.0
 * @Title: UserType
 * @Package com.summer.sample.constant
 * @Author: summer
 * @Date: 2019-02-24 21:41
 * @Description: 用户类型
 * 注意：
 */
public enum UserLevelEnum implements IUserLevelEnum {

    CARD_MEMBER(0),
    SILVER_MEMBER(1),
    GOLD_MEMBER(2)
    ;

    private int level;

    UserLevelEnum(int type){
        this.level = type;
    }

    public int getType() {
        return level;
    }

    public void setType(int level) {
        this.level = level;
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}
