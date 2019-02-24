package com.summer.sample.util;

import com.summer.sample.constant.IUserLevelEnum;

/**
 * All rights Reserved, Designed By mapletowngames.com
 *
 * @Version V1.0
 * @Title: EnumUtil
 * @Package com.summer.sample.util
 * @Author: summer
 * @Date: 2019-02-24 21:55
 * @Description: 注意：
 */
public class EnumUtil {

    /**
     * 枚举值转换
     * @param enumClass
     * @param enumCode
     * @param <E>
     * @return
     */
    public static <E extends Enum<?> & IUserLevelEnum> E convertEnumValue(Class<E> enumClass, int enumCode) {
        E[] enumConstants = enumClass.getEnumConstants();
        for (E e : enumConstants) {
            if (e.getLevel() == enumCode)
                return e;
        }
        return null;
    }

}
