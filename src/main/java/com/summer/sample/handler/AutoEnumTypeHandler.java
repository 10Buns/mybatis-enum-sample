package com.summer.sample.handler;

import com.summer.sample.constant.IUserLevelEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * All rights Reserved, Designed By mapletowngames.com
 *
 * @Version V1.0
 * @Title: AutoEnumTypeHandler
 * @Package com.summer.sample.handler
 * @Author: summer
 * @Date: 2019-02-24 22:21
 * @Description: 注意：
 */
public class AutoEnumTypeHandler <E extends Enum<E>> extends BaseTypeHandler<E> {

    private BaseTypeHandler typeHandler;

    public AutoEnumTypeHandler(Class<E> enumType){
        if (enumType == null) {
            throw new IllegalArgumentException("枚举类型不能为空");
        }
        //判断两个类是不是父子关系
        if(IUserLevelEnum.class.isAssignableFrom(enumType)){
            System.out.println("数据库使用用户等级枚举自动转换");
            typeHandler = new UserLevelEnumTypeHandler(enumType);
        }else {
            System.out.println("数据库使用默认类型转换");
            typeHandler = new EnumTypeHandler<>(enumType);
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {
        typeHandler.setNonNullParameter(preparedStatement,i, e,jdbcType);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return (E) typeHandler.getNullableResult(resultSet, s);
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return (E) typeHandler.getNullableResult(resultSet, i);
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return (E) typeHandler.getNullableResult(callableStatement, i);
    }
}
