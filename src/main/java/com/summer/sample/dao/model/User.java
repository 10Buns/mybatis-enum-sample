package com.summer.sample.dao.model;

import com.summer.sample.constant.UserLevelEnum;
import lombok.Data;

/**
 * All rights Reserved, Designed By mapletowngames.com
 *
 * @Version V1.0
 * @Title: User
 * @Package com.summer.sample.dao.model
 * @Author: summer
 * @Date: 2019-02-22 19:02
 */
@Data
public class User {

    private int id;

    private String name;

    private UserLevelEnum level;

}
